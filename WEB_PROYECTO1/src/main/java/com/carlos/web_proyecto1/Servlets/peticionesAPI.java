package com.carlos.web_proyecto1.Servlets;

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
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        StringBuilder resultado = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String linea;

        while ((linea = rd.readLine()) != null) {
            resultado.append(linea+"\n");
        }
        rd.close();
        
        String code = resultado.toString();
        System.out.println("Texto recuperado: " + code);
        try {
            lexerIndigo lex = new lexerIndigo(new StringReader(code));
            parserIndigo parser = new parserIndigo(lex);
            parser.parse();
            List<Object> instrucciones = parser.getInstrucciones();
            System.out.println("Numero de instrucciones a realizar: "+instrucciones.size());
            
            if(lex.getErrorsList().size()>0 || parser.getErrorsList().size()>0){
                envioRespuesta(req, resp, parser.getErrorsList(), lex.getErrorsList());
            }else{
                
            }
            
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
