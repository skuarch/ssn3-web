package network;

import com.sun.rowset.CachedRowSetImpl;
import java.rmi.UnexpectedException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import org.apache.log4j.Logger;
import util.DatabaseUtilities;

/**
 *
 * @author skuarch
 */
public class ConnectPool {

    private Logger log = Logger.getLogger(ConnectPool.class);
    DatabaseUtilities databaseUtilities = null;
    private int reconnections = 0;

    //==========================================================================
    public ConnectPool() {
        databaseUtilities = DatabaseUtilities.getInstance();
    } // end ConnectPool

    //==========================================================================
    private Connection getConnection() {

        Connection connection = null;
        DataSource dataSource = null;

        try {

            dataSource = databaseUtilities.getDataSource();

            if (dataSource != null) {
                connection = dataSource.getConnection();
            } else {

                InitialContext initialContext = new InitialContext();
                dataSource = (DataSource) initialContext.lookup("jdbc/ssn");

                tryReconnect();
            }

        } catch (NullPointerException npe) {
            tryReconnect();
        } catch (Exception e) {
            log.error("in connection with dataBase", e);
            databaseUtilities.closeConnection(connection);
        }

        return connection;

    } // end getConnection

    //=========================================================================
    @SuppressWarnings("unchecked")
    public ResultSet executeQuery(String sql) {

        if (sql == null || sql.length() < 1) {
            log.error("sql is null or empty", new NullPointerException("sql is null or empty"));
            return null;
        }


        ResultSet resultSet = null;
        Connection connection = null;
        Statement statement = null;
        CachedRowSet crs = null;

        try {

            connection = getConnection();

            if (connection == null) {
                return null;
            }

            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery(sql);

            //resultset is null ?
            if (resultSet == null) {
                log.error("resultSet is null", new NullPointerException("resultSet is null"));
            }

            crs = new CachedRowSetImpl();
            crs.populate(resultSet);

        } catch (Exception e) {
            log.error("error during the execution of query", e);
        } finally {
            databaseUtilities.closeConnection(connection);
            databaseUtilities.closeStatement(statement);
            databaseUtilities.closeResultSet(resultSet);
        }

        return crs;
    } //end executeQuery

    //=========================================================================
    public void update(String sql) {

        if (sql == null || sql.length() < 1) {
            log.error("sql is null or empty", new NullPointerException("sql is null or empty"));
            return;
        }

        Connection connection = null;
        Statement statement = null;

        try {

            connection = getConnection();

            if (connection == null) {
                return;
            }

            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception e) {
            log.error("error in update", e);
        } finally {
            databaseUtilities.closeConnection(connection);
            databaseUtilities.closeStatement(statement);
            sql = null;
        }

    } //end update

    //==========================================================================
    public int getNumRows(ResultSet resultSet) {

        if (resultSet == null) {
            log.error("resultSet is null", new NullPointerException("resultSet is null"));
            return 0;
        }

        int numRows = 0;

        try {

            resultSet.last();
            numRows = resultSet.getRow();
            resultSet.beforeFirst();

        } catch (Exception e) {
            log.error("error in getNumRows", e);
        }

        return numRows;

    } // getNumRows

    //==========================================================================
    private void tryReconnect() {

        try {

            if (reconnections >= 3) {
                log.error("imposible establish connection with dataBase", new UnexpectedException("imposible establish connection with dataBase"));
                return;
            }

            reconnections++;
            Thread.sleep(4000);
            getConnection();

        } catch (Exception e) {
            log.error("in reconnection", e);
        }

    } // end tryReconect
} // end ConnectPool

