<%-- 
    Document   : index
    Created on : Oct 26, 2011, 9:22:55 AM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <li class="active">
                            <a href="#">
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="screenshots.jsp">
                                Screenshots
                            </a>
                        </li>
                    </ul><!--end nav -->
                </div> <!-- end container -->
            </div> <!-- end fill -->
        </div> <!--end topbar-->

        <div class="container"> <!-- container -->           

            <div class="hero-unit">
                <h1>Sispro Sniffer Network</h1>
                <p>
                    <br>
                    Sispro Sniffer Network is a visually rich and powerful analyzer for wired and wireless networks
                    that revolutionizes the use of sniffer by providing capabilities not found in the world? is  the most
                    popular packet and network analysis tool. Fully integrated with sniffer,
                    Sispro Sniffer Network capitalizes on user's existing expertise while dramatically increasing
                    efficiency in identifying and diagnosing network problems.
                </p>
                <p>
                <div class="right">
                    <a class="btn primary large" href="<%= new common.JWS().getJWSPath() %>">
                        Launch application &raquo;
                    </a>
                </div>                
            </div>

            <div class="row"> <!-- row -->
                <div class="span-one-third">
                    <h2>Requeriments</h2>                    
                    <ul>
                        <li>
                            java 6 or higher (java virtual machine)
                        </li>
                        <li>
                            50 MB of free memory ram
                        </li>
                    </ul>
                </div>
                <div class="span-one-third">
                    <h2>Skills</h2>
                    <ul>
                        <li>Easily identify traffic</li>
                        <li>Easy to use</li>
                        <li>Shows information quickly</li>
                    </ul>
                </div>
                <div class="span-one-third">
                    <h2>Screenshots</h2>
                    <ul>
                        <li>
                            Take a tour for see the application
                        </li>
                    </ul>
                    <div class="right">
                        <a class="btn" href="screenshots.jsp">View details &raquo;</a>
                    </div>
                </div>
            </div> <!-- end row -->

            <footer> <!-- footer -->
                <p>&copy; General DataComm 2012</p>
            </footer> <!-- end footer -->

        </div> <!-- end container -->

    </body>
</html>
