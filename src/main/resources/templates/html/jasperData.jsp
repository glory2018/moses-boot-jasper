<%@ page session="false" %>
<%@ page import="net.sf.jasperreports.engine.JasperExportManager" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title></title>
    <%
        JasperExportManager.exportReportToHtmlFile( "D:\\temp\\Coffee.jrprint");
    %>
</head>
<body>
</body>
</html>
