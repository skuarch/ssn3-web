package common;

import java.io.PrintWriter;
import org.apache.log4j.Logger;
import util.ShowWebMessage;

/**
 *
 * @author skuarch
 */
public class ErrorWeb {

    static final Logger logger = Logger.getLogger(ErrorWeb.class);
    private PrintWriter out;
    private ShowWebMessage swm;

    public ErrorWeb(PrintWriter out) {
        this.out = out;
        this.swm = new ShowWebMessage();
    }

    public void printError(String error, Throwable e) {
        this.out.println(error + " " + e);
        System.err.println(error + " " + e);
        this.swm.alertError(this.out, error + " " + e);
        logger.error(error + " ", e);
    }

    public void printError(String error) {
        this.swm.alertError(this.out, error);
        this.out.println(error);
        System.err.println(error);
        logger.error(error);
    }
} //end class