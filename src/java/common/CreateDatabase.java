package common;

import java.io.PrintWriter;
import network.ConnectDriverWeb;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class CreateDatabase {

    private static final Logger logger = Logger.getLogger(CreateDatabase.class);
    private PrintWriter out = null;
    private ErrorWeb errorWeb = null;

    //==========================================================================
    public CreateDatabase(PrintWriter out){
        this.out = out;
        this.errorWeb = new ErrorWeb(out);
    } // end CreateDatabase

    //==========================================================================
    public void create(String projectName,String userDataBase, String passwordDataBase, String serverDataBase, String portDataBase, String dataBaseName, String glassfishWebPort){

        ConnectDriverWeb cdw = null; // this is only for create database
        ConnectDriverWeb cdw2 = null;        
        
        try {

            cdw = new ConnectDriverWeb(out, userDataBase, passwordDataBase, serverDataBase, "",portDataBase);
            cdw2 = new ConnectDriverWeb(out, userDataBase, passwordDataBase, serverDataBase, dataBaseName,portDataBase);

            //creating database
            cdw.update("CREATE DATABASE IF NOT EXISTS " + dataBaseName + ";");

            //table categories
            cdw2.update("CREATE TABLE categories (categorie_id bigint(20) NOT NULL AUTO_INCREMENT,  categorie_active int(11) DEFAULT NULL,  categorie_name varchar(255) DEFAULT NULL,  categorie_order int(2) DEFAULT NULL,  PRIMARY KEY (categorie_id)) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1");
            
            //data for table categories
            cdw2.update("truncate table categories");
            cdw2.update("INSERT INTO categories (categorie_active, categorie_name, categorie_order) VALUES ('1', 'Bandwidth', '1');");
            cdw2.update("INSERT INTO categories (categorie_active, categorie_name, categorie_order) VALUES ('1', 'Protocols', '2');");
            cdw2.update("INSERT INTO categories (categorie_active, categorie_name, categorie_order) VALUES ('1', 'Host', '3');");
            cdw2.update("INSERT INTO categories (categorie_active, categorie_name, categorie_order) VALUES ('1', 'Conversations', '4');");
            cdw2.update("INSERT INTO categories (categorie_active, categorie_name, categorie_order) VALUES ('1', 'Web', '5');");
            cdw2.update("INSERT INTO categories (categorie_active, categorie_name, categorie_order) VALUES ('1', 'QoS', '6');");
            cdw2.update("INSERT INTO categories (categorie_active, categorie_name, categorie_order) VALUES ('1', 'Ports', '7');");
            
            //table subcategories
            cdw2.update("CREATE TABLE subcategories (subcategorie_id BIGINT(20) NOT NULL AUTO_INCREMENT, subcategorie_active INT(11) DEFAULT NULL, subcategorie_name VARCHAR(255) DEFAULT NULL,  subcategorie_categorie_id BIGINT(20) DEFAULT NULL,  subcategorie_order INT(2) DEFAULT NULL,  PRIMARY KEY (subcategorie_id)) ENGINE=MYISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1");
            
            //data for table subcategories
            cdw2.update("truncate table subcategories");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Bandwidth Over Time Bits', '1', '1');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Bandwidth Over Time Bytes', '1', '2');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Bandwidth Over Time Source Bits', '1', '3');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Bandwidth Over Time Destination Bits', '1', '4');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Bandwidth Over Time Source and Destination Bits', '1', '5');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('0', 'Bandwidth Over Time Bits Live', '1', '6');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Network Protocols', '2', '1');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'IP Protocols', '2', '2');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'TCP Protocols', '2', '3');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'UDP Protocols', '2', '4');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'IP Talkers Bytes', '3', '1');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'IP Talkers Destinations Bytes', '3', '2');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'IP Talkers Sources Bytes', '3', '3');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Hostname Talkers Bytes', '3', '4');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Hostname Talkers Destinations Bytes', '3', '5');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Hostname Talkers Sources Bytes', '3', '6');");            
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Host Conversations Bytes', '4', '1');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Host TCP Conversations Bytes', '4', '2');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Host UDP Conversations Bytes', '4', '3');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Web Server Hosts', '5', '1');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Type of Service', '6', '1');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'Top Ports', '7', '1');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'TCP Ports', '7', '2');");
            cdw2.update("INSERT INTO subcategories (subcategorie_active, subcategorie_name, subcategorie_categorie_id, subcategorie_order) VALUES ('1', 'UDP Ports', '7', '3');");
            
            //table collectors
            cdw2.update("CREATE TABLE collectors (collector_id bigint(20) NOT NULL AUTO_INCREMENT, collector_type int(1) DEFAULT NULL COMMENT '1 openblocks 2 server', collector_host varchar(50) DEFAULT NULL, collector_ip varchar(15)DEFAULT NULL, collector_site varchar(100) DEFAULT NULL, collector_description varchar(150) DEFAULT NULL, collector_port int(5) DEFAULT NULL, collector_port_connection_server int(5) DEFAULT NULL,   collector_is_active int(1) DEFAULT NULL COMMENT '1 active 0 no active', collector_context varchar(25) DEFAULT NULL COMMENT 'part of url', collector_date_register timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'date of register', PRIMARY KEY (collector_id)) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;");
            //table configuration            
            cdw2.update("CREATE TABLE configuration (id_configuration bigint(20) NOT NULL AUTO_INCREMENT, help_path varchar(255) DEFAULT NULL, jws_path varchar(255) DEFAULT NULL, jms_time_wait_connectivity int(11) DEFAULT NULL, jms_time_wait_message int(11) DEFAULT NULL, project_name varchar(255) DEFAULT NULL, seconds_live varchar(20) DEFAULT NULL, PRIMARY KEY (id_configuration)) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1");

            //data for table configuration
            cdw2.update("truncate table configuration");
            cdw2.update("INSERT INTO configuration (jws_path, help_path, project_name, jms_time_wait_message, jms_time_wait_connectivity,seconds_live) VALUES ('http://" + serverDataBase + ":" + glassfishWebPort + "/" + projectName.split("_")[1] + "/ssn-app-client','http://" + serverDataBase + ":" + glassfishWebPort + "/ssn-war/help.jsp', '"+projectName.split("_")[1]+"', '10000', '10000','20');");

            //table users
            cdw2.update("CREATE TABLE users (user_id bigint(20) NOT NULL AUTO_INCREMENT,user_name varchar(50) DEFAULT NULL,user_password varchar(50) DEFAULT NULL,user_level int(1) DEFAULT NULL COMMENT '1 =admin 2 = guest',  user_description varchar(100) DEFAULT NULL, PRIMARY KEY (user_id)) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;");
            //data for table users
            cdw2.update("truncate table users");
            cdw2.update("insert  into users(user_id,user_name,user_password,user_level,user_description) values (1,'skuarch','123',1,'administrator');");
            cdw2.update("insert  into users(user_id,user_name,user_password,user_level,user_description) values (2,'julio','123',1,'administrator');");
            cdw2.update("insert  into users(user_id,user_name,user_password,user_level,user_description) values (3,'invitado','123',2,'guest');");

        } catch (Exception e) {
            logger.error("ERROR: CreateDataBase().create() ", e);
            errorWeb.printError("ERROR: CreateDataBase().create() ", e);
        } finally{
            cdw = null;
            cdw2 = null;
        }
        
    } // end createDatabase

} // end class
