<%@ page session="false" %>
<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="javax.naming.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title></title>
    <%
        DataSource ds = null;
        try{
            InitialContext ctx=new InitialContext();
            ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
            Connection conn = ds.getConnection();
//装载jasper 文件
            File business_rpt = new
                    File(application.getRealPath("/reports/BusinessRpt.jasper"));
// http://blog.csdn.net/jemlee2002/archive/2004/10/08/JJem3.aspx
//ProjectName 就是iReport 的变量$P{ProjectName}的名称，
//proname 就是从界面上获取的值。
            Map parameters = new HashMap();
            parameters.put("ProjectName ", "test");
// JasperRunManager是一个输出控制管理类，下文会提及部分内容
            JasperRunManager.runReportToHtmlFile(business_rpt.getPath(),parameters,conn);
//如果创建报表成功，则转向该报表，其实可以把报表套在框架内，这样实现比较有意
            response.sendRedirect("/reports/BusinessRpt.html");
        }catch(Exception ex){
            out.print("出现例外，信息是:"+ex.getMessage());
            ex.printStackTrace();
        }
    %>
</head>
<body>
</body>
</html>
