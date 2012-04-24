<!DOCTYPE html>
<html>
    <head>

        <title>Sispro Sniffer Network</title>

        <script type="text/javascript" language="javascript" src="scripts/checkFormInstaller.js"></script>

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/default.css" rel="stylesheet">

        <style type="text/css">            
            body {
                padding-top: 60px;
            }
        </style>

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

        <div class="container">

            <div class="content">
                <div class="page-header">
                    <h1>Installation <small>step 1 of 3</small></h1>
                </div>
                <div class="row">
                    <div class="span11"> <!-- span 11 -->
                        <h2>Installation Form</h2>

                        <form action="installStep2.jsp" id="formCreateDatabase" name="formCreateDatabase" method="post">

                            <table border="0" align="center">
                                <thead>
                                <tbody>
                                    <tr>
                                        <td>project name:</td>
                                        <td><input type="text" id="projectName" name="projectName" value="projectName" maxlength="50">* e.g. geusa</td>
                                    </tr>
                                    <tr>
                                        <td>server dataBase:</td>
                                        <td><input type="text" id="serverDataBase" name="serverDataBase" value="" maxlength="50">* e.g. hostname</td>
                                    </tr>
                                    <tr>
                                        <td>user database:</td>
                                        <td><input type="text" id="userDataBase" name="userDataBase" value="root" maxlength="50">* e.g. root</td>
                                    </tr>
                                    <tr>
                                        <td>password database:</td>
                                        <td><input type="password" id="passwordDataBase" name="passwordDataBase" value="vitalnoc" maxlength="50">*</td>
                                    </tr>
                                    <tr>
                                        <td>database name:</td>
                                        <td><input type="text" id="dataBaseName" name="dataBaseName" maxlength="50" readonly> e.g. ssn_projectName</td>
                                    </tr>
                                    <tr>
                                        <td>database port:</td>
                                        <td><input type="text" id="dataBasePort" name="dataBasePort" maxlength="50" value="3306"> e.g. 3300</td>
                                    </tr>
                                    <tr>
                                    <tr>
                                        <td>user glassfish:</td>
                                        <td><input type="text" id="userGlassfish" name="userGlassfish" value="admin" maxlength="50">* e.g. admin</td>
                                    </tr>
                                    <tr>
                                        <td>password glassfish:</td>
                                        <td><input type="password" id="passwordGlassfish" name="passwordGlassfish" value="adminadmin" maxlength="50">* </td>
                                    </tr>
                                    <tr>
                                        <td>glassfish instalation home:</td>
                                        <td><input type="text" id="glassfishHome" name="glassfishHome" value="/opt/glassfish/bin/" maxlength="50">* e.g. /opt/glassfish/</td>
                                    </tr>
                                    <tr>
                                        <td>glassfish web port:</td>
                                        <td><input type="text" id="glassfishWebPort" name="glassfishWebPort" value="8080" maxlength="50">* e.g. 8080</td>
                                    </tr>
                                <td></td>
                                <td>
                                    <input type="reset" value="reset form">
                                    <a class="btn" href="javascript:checkFormInstaller(document.formCreateDatabase)">create database &raquo;</a>
                                </td>
                                </tr>
                                </tbody>
                            </table>

                        </form>

                    </div> <!-- end span 11 -->
                    <div class="span5"> <!-- span 5 -->
                        <h3>Help</h3>
                        <ul>
                            <li>
                                All the fields with * are necessary.
                            </li>
                            <li>
                                The information a side of each fields is an example.
                            </li>
                            <li>
                                <div class="textRed">
                                    You must change the project name.
                                </div>
                            </li>
                            <li>
                                database name field is filled automatically
                            </li>
                        </ul>
                    </div> <!-- end span 5 -->
                </div>
            </div>

            <footer> <!-- footer -->
                <p>&copy; General DataComm 2012</p>
            </footer> <!-- end footer -->

        </div> <!-- /container -->

    </body>
</html>