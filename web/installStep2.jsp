<%-- 
    Document   : installStep2
    Created on : Oct 26, 2011, 1:42:32 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="common.CreateDatabase"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>

        <link href="css/default.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.css" rel="stylesheet">

        <style type="text/css">
            body {
                padding-top: 60px;
            }
        </style>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                <h1>Installation <small>step 2 of 3</small></h1>
            </div>

            creating database and tables, done !!

            <% new CreateDatabase(response.getWriter()).create(request.getParameter("projectName"), request.getParameter("userDataBase"),request.getParameter("passwordDataBase"),request.getParameter("serverDataBase"),request.getParameter("dataBasePort"),request.getParameter("dataBaseName"),request.getParameter("glassfishWebPort")); %>
            
                    <br>
                    <br>
                    <br>
                    <br> 
                    
                    <a class="btn" href="installStep3.jsp?projectName=<%=request.getParameter("projectName")%>&dataBaseName=<%=request.getParameter("dataBaseName")%>&userDataBase=<%=request.getParameter("userDataBase")%>&passwordDataBase=<%=request.getParameter("passwordDataBase")%>&glassfishWebPort=<%=request.getParameter("glassfishWebPort")%>&serverDataBase=<%=request.getParameter("serverDataBase")%>&dataBasePort=<%=request.getParameter("dataBasePort") %>&glassfishHome=<%=request.getParameter("glassfishHome") %>">next &raquo;</a>

            <footer> <!-- footer -->
                <p>&copy; General DataComm 2012</p>
            </footer> <!-- end footer -->

        </div> <!-- end container -->


    </body>
</html>
