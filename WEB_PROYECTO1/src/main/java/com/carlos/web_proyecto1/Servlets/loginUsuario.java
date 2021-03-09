package com.carlos.web_proyecto1.Servlets;

import com.carlos.web_proyecto1.Lexer.lexerIndigo;
import com.carlos.web_proyecto1.Objetos.userNew;
import com.carlos.web_proyecto1.Objetos.usuario;
import com.carlos.web_proyecto1.Parser.parserIndigo;
import com.carlos.web_proyecto1.escribirRespuestaIndigo.resIndigo;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.security.util.Password;

@WebServlet("/loginUser")
public class loginUsuario extends HttpServlet {

    private resIndigo respuesta = new resIndigo();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FUNCIONAMIENTO DEL SERVLET");

        usuario user = new usuario();

        List<String> errSin = new ArrayList<>();
        List<String> errLex = new ArrayList<>();

        StringBuilder resultado = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String linea;

        while ((linea = rd.readLine()) != null) {
            resultado.append("\n" + linea);
        }

        rd.close();

        System.out.println("Texto recuperado: " + resultado.toString());
        try {
            lexerIndigo lex = new lexerIndigo(new StringReader(resultado.toString()));
            parserIndigo parser = new parserIndigo(lex);
            parser.parse();
            errSin = parser.getErrorsList();
            errLex = lex.getErrorsList();
            user = parser.getLogUser();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user.getUser() == null || user.getPass() == null) {
            System.out.println("Usuario invalido");
            envioRespuesta(req, resp, user, errSin, errLex);

        } else {
            System.out.println("Se recupero el usuario");
            envioMensaje(req, resp,"Solicitud Aceptada!!:)");
        }

    }

    private void envioRespuesta(HttpServletRequest req, HttpServletResponse resp, usuario user, List<String> errSin, List<String> errLex) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            writer.println(respuesta.escribirMensajeError(errSin, errLex));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void envioMensaje(HttpServletRequest req, HttpServletResponse resp,String mensaje) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            writer.println(respuesta.escribirMensaje(mensaje));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FUNCIONAMIENTO DEL SERVLET");
    }

}
