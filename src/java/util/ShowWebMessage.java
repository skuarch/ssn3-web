package util;

import java.io.PrintWriter;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class ShowWebMessage {

    static final Logger logger = Logger.getLogger(ShowWebMessage.class);

    //=========================================================================
    public ShowWebMessage() {
    } //end ShowWebMessage

    //=========================================================================
    public void alertError(PrintWriter out, String message) {

        String alert = "";

        try {

            if (message == null || message.equalsIgnoreCase("")) {
                message = "ERROR: alertError().message is null";
                alert = "<script type='text/javascript' language='javascript'>"
                        + "alert('" + message + "'); "
                        + "</script>";
                out.println(alert);
                return;
            } else {

                message = message.replace("'", "");

                alert = "<script type='text/javascript' language='javascript'>"
                        + "alert('" + message + "'); "
                        + "</script>";
                out.println(alert);
            }

        } catch (Exception e) {
            logger.error("ERROR: ShowWebMessage().alertError() " + e);
            out.println("ERROR: ShowWebMessage().alertError() " + e);
            System.err.println("ERROR: ShowWebMessage().alertError() " + e);
        }

    } //end alertError
} //end class