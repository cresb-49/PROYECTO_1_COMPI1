package com.carlos.proyecto1_compi1.Servlets;

import com.carlos.proyecto1_compi1.Lexer.lexerIndigo;
import com.carlos.proyecto1_compi1.Parser.parserIndigo;
import java.io.IOException;
import java.io.StringReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginUser")
public class loginUsuario extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String indigoCode = req.getParameter("code");
        
        lexerIndigo lex = new lexerIndigo(new StringReader(indigoCode));
        parserIndigo parser = new parserIndigo(lex);
        
        try {
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
