<%-- 
    Document   : screenshots
    Created on : Oct 26, 2011, 10:40:17 AM
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
        <link rel="stylesheet" href="css/lightbox.css" type="text/css" media="screen" />

        <script src="scripts/prototype.js" type="text/javascript"></script>
        <script src="scripts/scriptaculous.js?load=effects,builder" type="text/javascript"></script>
        <script src="scripts/lightbox.js" type="text/javascript"></script>

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
                        <li class="active">
                            <a href="screenshots.jsp">
                                Screenshots
                            </a>
                        </li>
                    </ul><!--end nav -->
                </div> <!-- end container -->
            </div> <!-- end fill -->
        </div> <!--end topbar-->

        <div class="container"> <!-- container -->

            <div class="page-header">
                <h1>Screenshots <small>Take a tour and see the application</small></h1>
            </div> 

            <table border="0" align="center">
                <tbody>
                    <tr>
                        <td>
                            <center>
                                <a href="images/1.png" rel="lightbox[roadtrip]">
                                    Bandwidth over time bits
                                    <br>
                                    <br>
                                    <img src="images/1.png" border="0" width="150" height="100" alt="bandwidth">
                                </a>
                            </center>
                        </td>
                        <td>
                            <center>
                                <a href="images/2.png" rel="lightbox[roadtrip]">
                                    Bandwidth source and destination
                                    <br>
                                    <br>
                                    <img src="images/2.png" border="0" width="150" height="100" alt="Bandwidth over time source and destination">
                                </a>
                            </center>
                        </td>
                        <td>
                            <center>
                                <a href="images/3.png" rel="lightbox[roadtrip]">
                                    Host conversation bytes
                                    <br>
                                    <br>
                                    <img src="images/3.png" border="0" width="150" height="100" alt="Host conversation bytes">
                                </a>
                            </center>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <center>
                                <a href="images/4.png" rel="lightbox[roadtrip]">
                                    IP Traffic
                                    <br>
                                    <br>
                                    <img src="images/4.png" border="0" width="150" height="100" alt="IP Traffic">
                                </a>
                            </center>
                        </td>
                        <td>
                            <center>
                                <a href="images/5.png" rel="lightbox[roadtrip]">
                                    Network protocols
                                    <br>
                                    <br>
                                    <img src="images/5.png" border="0" width="150" height="100" alt="Network protocols">
                                </a>
                            </center>
                        </td>
                        <td>                            
                            <center>
                                <a href="images/6.png" rel="lightbox[roadtrip]">
                                    UDP protocols
                                    <br>
                                    <br>
                                    <img src="images/6.png" border="0" width="150" height="100" alt="UDP protocols">
                                </a>
                            </center>
                        </td>
                    </tr>                    
                </tbody>
            </table>

            <footer> <!-- footer -->
                <p>&copy; General DataComm 2012</p>
            </footer> <!-- end footer -->

        </div> <!-- end container -->
    </body>
</html>
