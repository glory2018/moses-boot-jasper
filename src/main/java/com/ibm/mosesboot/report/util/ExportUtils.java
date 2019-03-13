/**************************************************
 * 
 * Copyright (C) 2018 INSCRIBE All rights reserved.
 * 
 ********** K*I*N*G ********** B*A*C*K
 ***********/
package com.ibm.mosesboot.report.util;

import java.io.File;

import com.ibm.mosesboot.common.Constant;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOdsReportConfiguration;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

/**
 * @author bjfansr@cn.ibm.com
 * @Date 2019-03-04
 */
public class ExportUtils {
  /**
  *
  */
  public static void fill(String name) throws JRException {
// JasperFillManager.fillReportToFile(Constant.REPORTS + name + ".jasper", null,
// new JREmptyDataSource());
    File sourceFile = new File(Constant.REPORTS + name + ".jasper");
    System.err.println(" : " + sourceFile.getAbsolutePath());
    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(sourceFile);
    fill(name, jasperReport);
  }

  public static void fill(String name, JasperReport jasperReport) throws JRException {
    long start = System.currentTimeMillis();
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, (JRDataSource) null);
    // sourceFile.getParent()
    File destFile = new File(Constant.PRINTS, jasperReport.getName() + ".jrprint");
    JRSaver.saveObject(jasperPrint, destFile);
    outLog("Filling time : ", start);
  }

  /**
  *
  */
  public static void print(String name) throws JRException {
    long start = System.currentTimeMillis();
    JasperPrintManager.printReport(Constant.PRINTS + name + ".jrprint", true);
    outLog("Printing time : ", start);
  }

  private static void outLog(String msg, long start) {
    System.err.println(msg + (System.currentTimeMillis() - start));
  }

  /**
  *
  */
  public static void pdf(String name) throws JRException {
    long start = System.currentTimeMillis();
    JasperExportManager.exportReportToPdfFile(Constant.PRINTS + name + ".jrprint");
    outLog("PDF creation time : ", start);
  }

  /**
  *
  */
  public static void xml(String name) throws JRException {
    long start = System.currentTimeMillis();
    JasperExportManager.exportReportToXmlFile(Constant.PRINTS + name + ".jrprint", false);
    System.err.println("XML creation time : " + (System.currentTimeMillis() - start));
  }

  /**
  *
  */
  public static void xmlEmbed(String name) throws JRException {
    long start = System.currentTimeMillis();
    JasperExportManager.exportReportToXmlFile(Constant.PRINTS + name + ".jrprint", true);
    System.err.println("XML creation time : " + (System.currentTimeMillis() - start));
  }

  /**
  *
  */
  public static void html(String name) throws JRException {
    long start = System.currentTimeMillis();
    JasperExportManager.exportReportToHtmlFile(Constant.PRINTS + name + ".jrprint");
    System.err.println("HTML creation time : " + (System.currentTimeMillis() - start));
  }

  private static void export(JRAbstractExporter exporter, String name, String type, String msg)
      throws JRException {
    long start = System.currentTimeMillis();
    File sourceFile = new File(Constant.PRINTS + name + ".jrprint");
    JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);
    File destFile = new File(Constant.DIST, jasperPrint.getName() + type);
    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    if (".rtf".equals(type) || ".csv".equals(type)) {
      exporter.setExporterOutput(new SimpleWriterExporterOutput(destFile));
    } else {
      exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
    }
    exporter.exportReport();
    outLog(msg, start);
  }

  public static void rtf(String name) throws JRException {
    JRRtfExporter exporter = new JRRtfExporter();
    export(exporter, name, ".rtf", "RTF creation time : ");
  }

  public static void xls(String name) throws JRException {
    JRXlsExporter exporter = new JRXlsExporter();
    SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
    configuration.setOnePagePerSheet(true);
    exporter.setConfiguration(configuration);
    export(exporter, name, ".xls", "XLS creation time : ");
  }

  /**
  *
  */
  public static void csv(String name) throws JRException {
    JRCsvExporter exporter = new JRCsvExporter();
    export(exporter, name, ".csv", "CSV creation time : ");
  }

  /**
  *
  */
  public static void odt(String name) throws JRException {
    JROdtExporter exporter = new JROdtExporter();
    export(exporter, name, ".odt", "ODT creation time : ");
  }

  /**
  *
  */
  public static void ods(String name) throws JRException {
    JROdsExporter exporter = new JROdsExporter();
    SimpleOdsReportConfiguration configuration = new SimpleOdsReportConfiguration();
    configuration.setOnePagePerSheet(true);
    exporter.setConfiguration(configuration);
    export(exporter, name, ".ods", "ODS creation time : ");
  }

  /**
  *
  */
  public static void docx(String name) throws JRException {
    JRDocxExporter exporter = new JRDocxExporter();
    export(exporter, name, ".docx", "DOCX creation time : ");
  }

  /**
  *
  */
  public static void xlsx(String name) throws JRException {
    JRXlsxExporter exporter = new JRXlsxExporter();
    SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
    configuration.setOnePagePerSheet(true);
    exporter.setConfiguration(configuration);
    export(exporter, name, ".xlsx", "XLSX creation time : ");
  }

  /**
  *
  */
  public static void pptx(String name) throws JRException {
    JRPptxExporter exporter = new JRPptxExporter();
    export(exporter, name, ".pptx", "PPTX creation time : ");
  }

}
