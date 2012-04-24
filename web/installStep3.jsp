<%-- 
    Document   : installStep3
    Created on : Oct 26, 2011, 4:46:45 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="common.CMD"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/default.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.css" rel="stylesheet">

        <style type="text/css">
            body {
                padding-top: 60px;
            }
        </style>

        <title>Sispro Sniffer Network</title>
    </head>
    <body>

        <div class="topbar"> <!--topbar-->
            <div class="fill"> <!-- fill -->
                <div class="container"> <!-- container -->
                    <a class="brand" href="#">
                        Sispro Sniffer Network
                    </a>
                    <ul class="nav"> <!--nav -->
                        <li>
                            <a href="index.jsp">
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="screenshots.jsp">
                                Screenshots
                            </a>
                        </li>
                        <li class="active">
                            <a href="#">
                                Install
                            </a>
                        </li>
                    </ul><!--end nav -->
                </div> <!-- end container -->
            </div> <!-- end fill -->
        </div> <!--end topbar-->

        <div class="container"> <!-- container -->

            <div class="page-header">
                <h1>Installation <small>step 3 of 3</small></h1>
            </div>

            <div class="row">
                <div class="span11">

                    The database <b><%=request.getParameter("dataBaseName")%></b> was Created successionally !!
                    <br>
                    <br>
                    The final step is to create a connection pool and queue in the server
                    <br>
                    <br>
                    <b>Connection Pool</b>
                    <br>
                    executing command = 
                    <%
                        String cmd = request.getParameter("glassfishHome") + "asadmin create-jdbc-connection-pool --user admin --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype javax.sql.DataSource --property user=" + request.getParameter("userDataBase") + ":password=" + request.getParameter("passwordDataBase") + ":DatabaseName=" +  request.getParameter("dataBaseName") + ":ServerName=" + request.getParameter("serverDataBase") + ":port=" + request.getParameter("dataBasePort") + " connection_pool_ssn";
                        //out.println(new CMD(response.getWriter()).exec(cmd));                        
                    %>
                    
                    <br/>
                    <br/>
                    
                    <div class="textRed">
                        <%=cmd%>
                    </div>
                    <br>
                    <br>                    
                    <b>Connection Pool Resource JDBC</b>
                    <br>                    
                    <%
                        cmd = request.getParameter("glassfishHome") + "asadmin create-jdbc-resource --user admin --connectionpoolid connection_pool_ssn jdbc/ssn";
                        //out.println(new CMD(response.getWriter()).exec(cmd));
                    %> 
                    <br/>
                    <br/>
                    <div class="textRed">
                        <%=cmd%>
                    </div>
                    <br>
                    <br>
                    <br>
                    <b>Connection Factory</b>
                    <br>                    
                    <%
                        cmd = request.getParameter("glassfishHome") + "asadmin create-jms-resource --restype=javax.jms.TopicConnectionFactory jms_connection_factory_ssn";
                        //out.println(new CMD(response.getWriter()).exec(cmd));
                    %>
                    <br/>
                    <br/>
                    <div class="textRed">
                        <%=cmd%>
                    </div>
                    <br>
                    <br>
                    <br>
                    <b>JMS resource</b>
                    <br>                    
                    <%
                        cmd = request.getParameter("glassfishHome") + "asadmin create-jms-resource --restype=javax.jms.Topic jms_topic_ssn";
                        //out.println(new CMD(response.getWriter()).exec(cmd));
                    %>
                    <div class="textRed">
                        <%=cmd%>
                    </div>

                </div>

                <div class="span5">
                    <h3>Help</h3>
                    <ul>
                        <li>
                            Please copy the commands in orange and paste in the glassfish console "$GLASSFISH_HOME/bin"
                        </li>
                    </ul>
                </div>
            </div>

            <footer> <!-- footer -->
                <p>&copy; General DataComm 2012</p>
            </footer> <!-- end footer -->

        </div> <!-- end container -->

    </body>
</html>
