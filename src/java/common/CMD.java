package common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class CMD {

    private static final Logger logger = Logger.getLogger(CMD.class);
    private PrintWriter out = null;
    private ErrorWeb errorWeb = null;

    //==========================================================================
    public CMD(PrintWriter out) {
        this.out = out;
        this.errorWeb = new ErrorWeb(out);
    } // end CMD

    //==========================================================================
    public String exec(String cmd) {

        if(cmd == null){
            logger.error("cmd is null", new NullPointerException("cmd is null"));
            return null;
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        String tmp = null;
        Process process = null;
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;

        try {

            process = Runtime.getRuntime().exec(cmd);
            inputStream = process.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            while ((tmp = bufferedReader.readLine()) != null) {
                stringBuilder.append(tmp);
            }

        } catch (Exception e) {
            logger.error("ERROR: CreateDataBase().create() ", e);
            errorWeb.printError("ERROR: CreateDataBase().create() ", e);
        }

        return stringBuilder.toString();

    } // exec
} // end class
