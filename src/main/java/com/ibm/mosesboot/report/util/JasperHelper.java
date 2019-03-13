/*********************************************
 *
 * Copyright (C) 2018 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.ibm.mosesboot.report.util;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.Map;

@SuppressWarnings("deprecation")
public class JasperHelper {
    private static void prepareReport(JasperReport jasperReport, String docType) {
        /*
         * 如果导出的是excel，则需要去掉周围的margin
         */
        if (DocType.XLS.name().equals(docType) || DocType.XLSX.name().equals(docType)) {
            try {
                Field margin = JRBaseReport.class
                        .getDeclaredField("leftMargin");
                margin.setAccessible(true);
                margin.setInt(jasperReport, 0);
                margin = JRBaseReport.class.getDeclaredField("topMargin");
                margin.setAccessible(true);
                margin.setInt(jasperReport, 0);
                margin = JRBaseReport.class.getDeclaredField("bottomMargin");
                margin.setAccessible(true);
                margin.setInt(jasperReport, 0);
                Field pageHeight = JRBaseReport.class
                        .getDeclaredField("pageHeight");
                pageHeight.setAccessible(true);
                pageHeight.setInt(jasperReport, 2147483647);
            } catch (Exception exception) {
            }
        }
    }

    @SuppressWarnings("rawtypes")
    private static JRAbstractExporter getJRExporter(DocType docType) {
        JRAbstractExporter exporter = null;
        switch (docType) {
            case PDF:
                exporter = new JRPdfExporter();
                break;
            case DOC:
                exporter = new JRDocxExporter();
                break;
            case DOCX:
                exporter = new JRDocxExporter();
                break;
            case XLS:
                exporter = new JRXlsxExporter();
                break;
            case XLSX:
                exporter = new JRXlsxExporter();
                break;
            case XML:
                exporter = new JRXmlExporter();
                break;
            case RTF:
                exporter = new JRRtfExporter();
                break;
        }
        return exporter;
    }

    /**
     * 按照类型导出不同格式文件
     *
     * @param type       文件类型
     * @param fileName   文件名称
     * @param is         jasper文件的来源
     * @param request
     * @param response
     * @param parameters
     * @param conn
     */
    public static void export(String type, String fileName, InputStream is, String inline, HttpServletRequest
            request, HttpServletResponse response, Map parameters, Connection conn) {
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(is);
//            prepareReport(jasperReport, type);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            // JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());
            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
            /*
             * 设置头信息
             */
            DocType docType = DocType.fromTypeName(type);
//            request.setCharacterEncoding("utf-8");
//            response.setCharacterEncoding("utf-8");
            response.setContentType(docType.getTypeContent());
            if ("true".equals(inline)) {
                response.setHeader("Content-Disposition", "inline;");
            } else {
                response.setHeader("Content-Disposition", "attachment; filename=\""
                        + URLEncoder.encode(fileName, "UTF-8") + docType.getTypeSuffix() + "\"");
            }
//        String fileName = new String(defaultname.getBytes("GBK"), "ISO8859_1");
            final OutputStream outputStream = response.getOutputStream();
//            ServletOutputStream outputStream = response.getOutputStream();
            JRAbstractExporter exporter = getJRExporter(docType);
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
            exporter.exportReport();
            outputStream.flush();
            outputStream.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
