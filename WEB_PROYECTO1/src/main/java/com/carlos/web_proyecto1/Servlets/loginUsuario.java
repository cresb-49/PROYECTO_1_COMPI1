package com.carlos.web_proyecto1.Servlets;

import com.carlos.web_proyecto1.Lexer.lexerIndigo;
import com.carlos.web_proyecto1.Parser.parserIndigo;
import java.io.IOException;
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

        String indigoCode = req.getParameter("code");
        System.out.println("Cadena recivida: "+indigoCode);
        try {
            lexerIndigo lex = new lexerIndigo(new StringReader(indigoCode));
            parserIndigo parser = new parserIndigo(lex);
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FUNCIONAMIENTO DEL SERVLET");
    }

}
