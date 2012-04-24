package common;

import java.sql.ResultSet;
import network.ConnectPool;
import util.DatabaseUtilities;

/**
 *
 * @author skuarch
 */
public class JWS {

    public JWS() {
    }

    public String getJWSPath() {

        ResultSet resultSet = null;
        String path = null;

        try {

            resultSet = new ConnectPool().executeQuery("SELECT jws_path FROM configuration;");
            resultSet.next();
            path = resultSet.getString("jws_path");

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DatabaseUtilities.getInstance().closeResultSet(resultSet);
        }

        return path;
    }
} // end class

