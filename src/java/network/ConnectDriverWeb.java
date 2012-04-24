package network;

import com.sun.rowset.CachedRowSetImpl;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;
import org.apache.log4j.Logger;
import common.ErrorWeb;
import java.sql.PreparedStatement;

/**
 * Connect with mysql using driver.
 * @author skuarch
 */
public class ConnectDriverWeb {

    static final Logger logger = Logger.getLogger(ConnectDriverWeb.class);
    private PrintWriter out = null;
    private ErrorWeb errorWeb = null;
    private String user = "";
    private String password = "";
    private String server = "";
    private String dataBaseName = null;
    private String port = null;

    //=========================================================================
    public ConnectDriverWeb(PrintWriter out, String user, String password, String server, String dataBaseName,String port) {
        this.out = out;
        this.user = user;
        this.password = password;
        this.server = server;
        this.dataBaseName = dataBaseName;
        this.errorWeb = new ErrorWeb(this.out);
        this.port = port;
    } //end ConnectDriver

    //=========================================================================
    private Connection getConnection() {

        Connection conn = null;

        String jdbc = "";

        try {

            jdbc = "jdbc:mysql://" + server + ":"+port+"/" + dataBaseName;

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = (Connection) DriverManager.getConnection(jdbc, user, password);

            if (conn == null) {
                logger.error("ERROR: ConnectDriver().getConnection().conn is null");
                this.errorWeb.printError("ERROR: ConnectDriver().getConnection().conn is null");
            }

        } catch (Exception e) {
            logger.error("ERROR: ConnectDriver().getConnection() " + e);
            this.errorWeb.printError("ERROR: ConnectDriver().getConnection() " + e);
        }

        return conn;

    } //end getConnection

    //=========================================================================
    private void closeConnection(Connection conn) {

        try {

            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            logger.error("ERROR: ConnectDriver().closeConnection() " + e);
            this.errorWeb.printError("ERROR: ConnectDriver().closeConnection() " + e);
        } finally {
            conn = null;
        }

    } //end closeConnection

    //=========================================================================
    public ResultSet executeQuery(String sql) {

        if (sql.equals("")) {
            logger.error("ERROR: select().sql is null or empty");
            this.errorWeb.printError("ERROR: select().sql is null or empty");
        }

        ResultSet rs = null;
        Connection con = null;
        Statement st = null;
        CachedRowSet crs = null;

        try {

            con = getConnection();

            if (con == null) {
                logger.error("ERROR: ConnectDriver().executeQuery().conn is null");
                this.errorWeb.printError("ERROR: ConnectDriver().executeQuery().conn is null");
            }

            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);

            //resultset is null ?
            if (rs == null) {
                logger.error("ERROR: ConnectDriver().executeQuery().rs is null ");
                this.errorWeb.printError("ERROR: ConnectDriver().executeQuery().rs is null ");
            }

            crs = new CachedRowSetImpl();
            crs.populate(rs);

            try {
                closeConnection(con);
                st.close();
                rs.close();
            } finally {
                con = null;
                st = null;
                rs = null;
            }

        } catch (Exception e) {
            logger.error("ERROR: ConnectDriver().executeQuery() " + e);
            this.errorWeb.printError("ERROR: ConnectDriver().executeQuery() " + e);
        } finally {
            con = null;
            st = null;
            rs = null;
        }

        return crs;
    } //end executeQuery

    //=========================================================================
    public void update(String sql) {

        if (sql.equals("")) {
            logger.error("ERROR: update().sql is null or empty");
            this.errorWeb.printError("ERROR: update().sql is null or empty");
        }

        Connection cons = null;
        Statement sts = null;

        try {

            cons = getConnection();
            sts = cons.createStatement();
            sts.executeUpdate(sql);

            try {
                closeConnection(cons);
                sts.close();
            } finally {
                cons = null;
                sts = null;
                sql = null;
            }

        } catch (Exception e) {
            logger.error("ERROR: ConnectDriverWeb().update() " + e);
            this.errorWeb.printError("ERROR: ConnectDriverWeb().update() " + e);
        } finally {
            cons = null;
            sts = null;
            sql = null;
        }

    } //end update

    //==========================================================================
    public int getNumRows(ResultSet rs) {

        if (rs == null) {
            logger.error("ERROR: ConnectDriver().getNumFilas().rs is null ");
            this.errorWeb.printError("ERROR: ConnectDriver().getNumFilas().rs is null ");
        }

        int numRows = 0;

        try {

            rs.last();
            numRows = rs.getRow();
            rs.beforeFirst();

        } catch (Exception e) {
            logger.error("ERROR: ConnectDriver().getNumFilas() " + e);
            this.errorWeb.printError("ERROR: ConnectDriver().getNumFilas() " + e);
        }

        return numRows;

    } // getNumRows

    //==========================================================================
    public ResultSet selectLogin(String sql, String usr, String pwd) {

        ResultSet rs = null;
        Connection con = null;
        PreparedStatement ps = null;
        CachedRowSet crs = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usr);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(rs);

            try {
                con.close();
                rs.close();
            } finally {
                con = null;
                rs = null;
            }

        } catch (Exception ex) {
            logger.error("ERROR: ConnectDriver().selectLogin() " + ex);
            this.errorWeb.printError("ERROR: ConnectDriver().selectLogin() " + ex);
        } finally {
            rs = null;
            con = null;
        }

        return crs;
    } //end selectLogin
} //end class

