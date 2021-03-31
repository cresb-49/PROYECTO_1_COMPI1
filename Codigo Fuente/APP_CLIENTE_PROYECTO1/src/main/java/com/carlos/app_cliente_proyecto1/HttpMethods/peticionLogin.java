package com.carlos.app_cliente_proyecto1.HttpMethods;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class peticionLogin {

    public peticionLogin() {
    }
    
    public String iniciarSesion (String contenido) {
        String wsURL = "http://localhost:8080/WEB_PROYECTO1/loginUser";
        URL url = null;
        URLConnection connection = null;
        HttpURLConnection httpConn = null;
        String responseString = null;
        String outputString = "";
        OutputStream out = null;
        InputStreamReader isr = null;
        BufferedReader in = null;
        
        try {
            url = new URL(wsURL);
            connection = url.openConnection();
            httpConn = (HttpURLConnection) connection;

            byte[] buffer = new byte[contenido.length()];
            buffer = contenido.getBytes();

            String SOAPAction = "";
            // Set the appropriate HTTP parameters.
            httpConn.setRequestProperty("Content-Length", String
                    .valueOf(buffer.length));
            httpConn.setRequestProperty("Content-Type",
                    "text/xml; charset=utf-8");

            httpConn.setRequestProperty("SOAPAction", SOAPAction);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            out = httpConn.getOutputStream();
            out.write(buffer);
            out.close();

            // Read the response and write it to standard out.
            isr = new InputStreamReader(httpConn.getInputStream());
            in = new BufferedReader(isr);

            while ((responseString = in.readLine()) != null) {
                outputString = outputString + responseString+"\n";
            }
            //System.out.println(outputString);
            //System.out.println("");

            // Get the response from the web service call
            /*
            Document document = parseXmlFile(outputString);
             
            NodeList nodeLst = document.getElementsByTagName("ns2:sayhelloResponse");
            String webServiceResponse = nodeLst.item(0).getTextContent();
            System.out.println("The response from the web service call is : " + webServiceResponse);
             */
            return outputString;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
