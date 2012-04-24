package util;

import common.ErrorWeb;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author skuarch
 */
public class ExecuteCommand {

    private PrintWriter out = null;
    private String pathFileDir = null;

    //=========================================================================
    public ExecuteCommand(PrintWriter out, String pathFileDir) {
        this.out = out;
        this.pathFileDir = pathFileDir + "bin/";
    } //end ExecuteCommand

    //=========================================================================
    public String exec(String command) {

        if (command == null) {
            return "ERROR: ExecuteCommand().exec().command is null or empty";
        }

        Process p = null;
        InputStream is = null;
        BufferedReader br = null;
        String rtn = null;
        String aux = "";
        StringBuffer bs = null;
        File wd = new File(pathFileDir);

        try {

            bs = new StringBuffer();
            p = Runtime.getRuntime().exec(command,null,wd);
            is = p.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            while (p.waitFor() == 2) {
                //logger.info("waiting for finished command");
            }            

            aux = br.readLine();
            while ((rtn = br.readLine()) != null) {
                bs.append(rtn);
            }

            aux = bs.toString();

            try {
                p.destroy();
                is.close();
                br.close();
            } finally {
                p = null;
                is = null;
                br = null;
                bs = null;
            }

        } catch (Exception e) {
            new ErrorWeb(out).printError("ERROR: ExecuteCommand().exec() ", e);
        }

        return aux;
    } //end exec

    //=========================================================================
    public void voidExec(String command) {

        if (command == null) {
        }

        Process p = null;        
        File wd = new File(pathFileDir);

        try {
out.print(command+"<br>");
            p = Runtime.getRuntime().exec(command,null,wd);
            

            try {
                p.destroy();            
            } finally {
                p = null;            
            }

        } catch (Exception e) {
            new ErrorWeb(out).printError("ERROR: ExecuteCommand().voidExec() ", e);
        }
    } //end voidExec
} //end class
