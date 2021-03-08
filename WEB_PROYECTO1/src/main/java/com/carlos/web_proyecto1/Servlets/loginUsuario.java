package com.carlos.web_proyecto1.Servlets;

import com.carlos.web_proyecto1.Lexer.lexerIndigo;
import com.carlos.web_proyecto1.Objetos.userNew;
import com.carlos.web_proyecto1.Objetos.usuario;
import com.carlos.web_proyecto1.Parser.parserIndigo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginUser")
public class loginUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FUNCIONAMIENTO DEL SERVLET");
        
        usuario user=new usuario();
        
        
        StringBuilder resultado = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String linea;
        
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        
        rd.close();
        
        try {
            lexerIndigo lex = new lexerIndigo(new StringReader(resultado.toString()));
            parserIndigo parser = new parserIndigo(lex);
            parser.parse();
            user=parser.getLogUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Usuario recuperado: "+user.toString());
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FUNCIONAMIENTO DEL SERVLET");
    }

}
