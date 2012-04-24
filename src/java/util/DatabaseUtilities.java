package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
/**
 *
 * @author skuarch
 */
public class DatabaseUtilities {

    private static Logger log = Logger.getLogger(DatabaseUtilities.class);
    private static DatabaseUtilities INSTANCE = null;
    private static final String DATA_SOURCE = "jdbc/ssn";
    @Resource(mappedName="jdbc/ssn")
    private static DataSource dataSource;

    //==========================================================================
    private DatabaseUtilities() {
        verifyResources();
    }

    //==========================================================================
    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseUtilities();
        }
    }

    //==========================================================================
    public static DatabaseUtilities getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    //==========================================================================
    public DataSource getDataSource() {
        return dataSource;
    }

    //==========================================================================
    public void closeConnection(Connection connection) {
        try {

            if (connection != null) {
                connection.close();
            }

        } catch (Exception e) {
        } finally {
            connection = null;
        }
    } // end closeConnection

    //==========================================================================
    public void closeStatement(Statement statement) {
        try {

            if (statement != null) {
                statement.close();
            }

        } catch (Exception e) {
        } finally {
            statement = null;
        }
    } // end closeStatement

    //==========================================================================
    public void closeResultSet(ResultSet resultSet) {
        try {

            if (resultSet != null) {
                resultSet.close();
            }

        } catch (Exception e) {
        } finally {
            resultSet = null;
        }
    } // end closeStatement

    //==========================================================================
    private void verifyResources() {

        InitialContext initialContext = null;

        try {

            initialContext = new InitialContext();

            if (dataSource == null) {
                System.out.println("creating initial context");
                dataSource = (DataSource) initialContext.lookup(DATA_SOURCE);
            }

        } catch (Exception e) {
            log.error("verifying resources", e);
        }

    } // end verifyResources
} // end class

