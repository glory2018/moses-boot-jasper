<%@ page session="false" %>
<%@ page import="net.sf.jasperreports.engine.JasperExportManager" %>
<%@ page import="com.lowagie.text.SplitCharacter" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title></title>
    <%
        try {
            String path = "D:/temp/";
            String name = "Coffee";
            JasperExportManager.exportReportToPdfFile(path + name + ".jrprint");
            response.sendRedirect(path + name + ".pdf");
        } catch (Exception ex) {
            out.print("出现例外，信息是:" + ex.getMessage());
            ex.printStackTrace();
        }
    %>
</head>
<body>
</body>
</html>
