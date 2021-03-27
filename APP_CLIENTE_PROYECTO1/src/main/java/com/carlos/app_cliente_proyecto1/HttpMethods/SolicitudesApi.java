package com.carlos.app_cliente_proyecto1.HttpMethods;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class SolicitudesApi {
    public SolicitudesApi(){
        
    }
    public String envioRespuesta(String envio){
        String respuesta="";
        
        
        String wsURL = "http://localhost:8080/WEB_PROYECTO1/solicitudAPI";
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

            byte[] buffer = new byte[envio.length()];
            buffer = envio.getBytes();

            String SOAPAction = "";
            
            httpConn.setRequestProperty("Content-Length", String.valueOf(buffer.length));
            httpConn.setRequestProperty("Content-Type","text/xml; charset=utf-8");

            httpConn.setRequestProperty("SOAPAction", SOAPAction);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            out = httpConn.getOutputStream();
            out.write(buffer);
            out.close();
            isr = new InputStreamReader(httpConn.getInputStream());
            in = new BufferedReader(isr);

            while ((responseString = in.readLine()) != null) {
                outputString = outputString + responseString+"\n";
            }
            
            return outputString;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
