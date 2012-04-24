<%@ page import="java.io.*" %>
<%

    Process process = null;
    BufferedReader bufferedReader = null;
    String string = null;

    try{
        
        process = Runtime.getRuntime().exec("pwd");
        bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        
        while((string = bufferedReader.readLine()) != null){
            out.println(string);
            out.println("<br/>");
        }
        
    }catch(Exception e){
        out.println(e);
    }

%>