package network;

import common.ErrorWeb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.ExecuteCommand;

/**
 *
 * @author skuarch
 */
public class Installer extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        RequestDispatcher dispatcher = null;
        ConnectDriverWeb cdw = null;
        ConnectDriverWeb cdw2 = null;
        ExecuteCommand executeCommand = null;
        String projectName = null;
        String userDataBase = null;
        String passwordDataBase = null;
        String serverDataBase = null;
        String dataBaseName = null;
        String dataBasePort = null;
        String glassfishWebPort = null;
        String glassfishHome = null;
        String userGlassfish = null;

        try {

            dispatcher = request.getRequestDispatcher("install2.jsp");
            projectName = request.getParameter("projectName");
            userDataBase = request.getParameter("userDataBase");
            passwordDataBase = request.getParameter("passwordDataBase");
            serverDataBase = request.getParameter("serverDataBase");
            dataBaseName = request.getParameter("dataBaseName");
            dataBasePort = request.getParameter(dataBasePort);
            glassfishWebPort = request.getParameter("glassfishWebPort");
            glassfishHome = request.getParameter("glassfishHome");
            userGlassfish = request.getParameter("userGlassfish");
            out = response.getWriter();

            out.println("creating database and tables");

            //for exec commands
            executeCommand = new ExecuteCommand(out, glassfishHome);

            //connect and create database ******
            cdw = new ConnectDriverWeb(response.getWriter(), userDataBase, passwordDataBase, serverDataBase, "",dataBasePort);
            //creating database
            cdw.update("CREATE DATABASE IF NOT EXISTS " + dataBaseName + ";");

            // creating tables
            //connect to the new database
            cdw2 = new ConnectDriverWeb(out, userDataBase, passwordDataBase, serverDataBase, dataBaseName,dataBasePort);
            //table collectors
            cdw2.update("CREATE TABLE collectors (collector_id int(5) NOT NULL AUTO_INCREMENT, collector_type int(1) DEFAULT NULL COMMENT '1 openblocks 2 server', collector_host varchar(50) DEFAULT NULL, collector_ip varchar(15)DEFAULT NULL, collector_site varchar(100) DEFAULT NULL, collector_description varchar(150) DEFAULT NULL, collector_port int(5) DEFAULT NULL, collector_port_connection_server int(5) DEFAULT NULL,   collector_is_active int(1) DEFAULT NULL COMMENT '1 active 0 no active', collector_context varchar(25) DEFAULT NULL COMMENT 'part of url', collector_date_register timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'date of register', PRIMARY KEY (collector_id)) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;");
            //table configuration
            cdw2.update("CREATE TABLE configuration (jws_path varchar(100) DEFAULT NULL,help_path varchar(100) DEFAULT NULL) ENGINE=MyISAM DEFAULT CHARSET=latin1; ");
            //data for table configuration
            cdw2.update("insert  into configuration(jws_path,help_path) values ('http://" + serverDataBase + ":" + glassfishWebPort + "/" + projectName + "/snc-app-client','http://" + serverDataBase + ":" + glassfishWebPort + "/snc-war/help.jsp');");
            //table users
            cdw2.update("CREATE TABLE users (user_id int(5) NOT NULL AUTO_INCREMENT,user_name varchar(50) DEFAULT NULL,user_password varchar(50) DEFAULT NULL,user_level int(1) DEFAULT NULL COMMENT '1 =admin 2 = guest',  user_description varchar(100) DEFAULT NULL, PRIMARY KEY (user_id)) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;");
            //data for table users
            cdw2.update("insert  into users(user_id,user_name,user_password,user_level,user_description) values (1,'skuarch','123',1,'administrator');");
            cdw2.update("insert  into users(user_id,user_name,user_password,user_level,user_description) values (2,'julio','123',1,'administrator');");
            cdw2.update("insert  into users(user_id,user_name,user_password,user_level,user_description) values (3,'invitado','123',2,'guest');");

            

             //those doesn't work
            /*//cd
            //glassfishHome += "bin/";
            executeCommand.voidExec("cd " + glassfishHome);

            //create connection pool
            executeCommand.voidExec(glassfishHome + "./asadmin create-jdbc-connection-pool --user " + userGlassfish + " --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype javax.sql.DataSource --property user=" + userDataBase + ":password=" + passwordDataBase + ":DatabaseName=" + dataBaseName + ":ServerName=" + serverDataBase + ":port=3306 " + projectName);
            //create jdbc for pool
            executeCommand.voidExec(glassfishHome + "./asadmin create-jdbc-resource --connectionpoolid " + projectName + " jdbc/" + projectName + "");

            //crear la cola
            executeCommand.voidExec(glassfishHome + "./asadmin create-jms-resource --restype=javax.jms.TopicConnectionFactory jms/ConnectionFactory_" + projectName);
            executeCommand.voidExec(glassfishHome + "./asadmin create-jms-resource --restype=javax.jms.Topic jms_Topic_" + projectName);
             */

            //mandar a una pagina y decir que todo salio bien
            dispatcher.forward(request, response);



        } catch (Exception e) {
            new ErrorWeb(out).printError("ERROR: Installer().processRequest() ", e);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
