package com.carlos.web_proyecto1.Servlets;

import com.carlos.web_proyecto1.Lexer.lexerIndigo;
import com.carlos.web_proyecto1.Parser.parserIndigo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/solicitudAPI")
public class peticionesAPI extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        StringBuilder resultado = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String linea;

        while ((linea = rd.readLine()) != null) {
            resultado.append("\n" + linea);
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
            
        } catch (Exception e) {
        }
    }
    
    
}
