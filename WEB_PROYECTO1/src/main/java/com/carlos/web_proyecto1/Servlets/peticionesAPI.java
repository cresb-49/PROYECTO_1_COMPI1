package com.carlos.web_proyecto1.Servlets;

import com.carlos.web_proyecto1.Acciones.ejecutarInstrucciones;
import com.carlos.web_proyecto1.Lexer.lexerIndigo;
import com.carlos.web_proyecto1.Objetos.usuario;
import com.carlos.web_proyecto1.Parser.parserIndigo;
import com.carlos.web_proyecto1.escribirRespuestaIndigo.resIndigo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/solicitudAPI")
public class peticionesAPI extends HttpServlet {
    
    private resIndigo respuesta = new resIndigo();
    private ejecutarInstrucciones ejecutar = null;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder resultado = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String linea;

        while ((linea = rd.readLine()) != null) {
            resultado.append(linea+"\n");
        }
        rd.close();
        
        try {
            lexerIndigo lex = new lexerIndigo(new StringReader(resultado.toString()));
            parserIndigo parser = new parserIndigo(lex);
            parser.parse();
            List<Object> instrucciones = parser.getInstrucciones();
            System.out.println("Numero de instrucciones a realizar: "+instrucciones.size());
            
            if(lex.getErrorsList().size()>0 || parser.getErrorsList().size()>0){
                envioRespuesta(req, resp, parser.getErrorsList(), lex.getErrorsList());
            }else{
                if(instrucciones.size()==0){
                    envioMensaje(req, resp, "No hay intrucciones a realizar :(");
                }else{
                    String original = req.getServletContext().getRealPath("");
                    String p = original.replaceAll("/WEB_PROYECTO1/target/WEB_PROYECTO1-1.0-SNAPSHOT/","");
                    
                    if(p.equals(original)){
                        System.out.println("SO: WINDOWS");
                        p = original.replaceAll("\\\\WEB_PROYECTO1\\\\target\\\\WEB_PROYECTO1-1.0-SNAPSHOT\\\\","");
                        ejecutar = new ejecutarInstrucciones(p);
                    }else{
                        System.out.println("SO: LINUX");
                        ejecutar = new ejecutarInstrucciones(p);
                    }
                    ejecutar.ejecutarIntrucciones(instrucciones);
                    
                    if(ejecutar.getLog().isEmpty()){
                        this.envioMensaje(req, resp, "Hubo un error en el servidor");
                    }else{
                        this.envioRespuestas(req, resp, ejecutar.getLog());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void envioRespuestas(HttpServletRequest req, HttpServletResponse resp,List<String> mensajes) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            writer.println(respuesta.escribirMensajes(mensajes));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void envioRespuesta(HttpServletRequest req, HttpServletResponse resp,List<String> errSin, List<String> errLex) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            writer.println(respuesta.escribirMensajeError(errSin, errLex));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void envioMensaje(HttpServletRequest req, HttpServletResponse resp, String mensaje) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            writer.println(respuesta.escribirMensaje(mensaje));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
