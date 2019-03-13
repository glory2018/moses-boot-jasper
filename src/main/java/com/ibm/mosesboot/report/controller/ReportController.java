/*********************************************
 *
 * Copyright (C) 2019 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.ibm.mosesboot.report.controller;
/**
 * @author Moses *
 * @Date 2019/1/2 23:34
 */

import com.ibm.mosesboot.report.util.JasperHelper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ReportController {
    @Resource
    private DataSource dataSource;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/report")
    public String report() {
        return "html/report";
    }

    /**
     * 生成报表
     *
     * @param reportName 报表名称
     * @param whereSql   查询条件
     * @param inline     是否在线展示
     * @param type       文件类型
     * @param parameters 参数
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    @GetMapping("/{reportName}")
    public void getReportByParam(
            @PathVariable("reportName") final String reportName,
            @RequestParam(required = false) String whereSql,
            @RequestParam(required = false, defaultValue = "false") String inline,
            @RequestParam(required = false, defaultValue = "pdf") String type,
            @RequestParam(required = false) Map<String, Object> parameters,
            HttpServletRequest request,
            HttpServletResponse response) throws SQLException, IOException {
        parameters = parameters == null ? new HashMap<>() : parameters;
        ClassPathResource resource = new ClassPathResource("jaspers" + File.separator + reportName + ".jasper");
        InputStream jasperStream = resource.getInputStream();
        // parameters.put("whereSql", whereSql);
        JasperHelper.export(type, reportName, jasperStream, inline, request, response, parameters, dataSource.getConnection());
    }
}