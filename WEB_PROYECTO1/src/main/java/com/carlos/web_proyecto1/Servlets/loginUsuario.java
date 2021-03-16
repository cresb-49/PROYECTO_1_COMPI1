package com.carlos.web_proyecto1.Servlets;

import com.carlos.web_proyecto1.Acciones.ejecutarInstrucciones;
import com.carlos.web_proyecto1.DataBases.DBusuarios;
import com.carlos.web_proyecto1.Lexer.lexerIndigo;
import com.carlos.web_proyecto1.Objetos.userNew;
import com.carlos.web_proyecto1.Objetos.usuario;
import com.carlos.web_proyecto1.Parser.parserIndigo;
import com.carlos.web_proyecto1.escribirRespuestaIndigo.resIndigo;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
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
        usuario user = new usuario();

        List<String> errSin = new ArrayList<>();
        List<String> errLex = new ArrayList<>();

        StringBuilder resultado = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String linea;

        while ((linea = rd.readLine()) != null) {
            resultado.append(linea + "\n");
        }

        rd.close();

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

        if (user.getUser() == null || user.getPass() == null || !errLex.isEmpty() || !errSin.isEmpty()) {
            System.out.println("Usuario invalido");
            envioRespuesta(req, resp, user, errSin, errLex);
        } else {
            usuario tmp = recuperarDBusuarios(req).buscarUsuario(user.getUser());
            if (tmp == null) {
                envioMensaje(req, resp, "No existe un usuario con ese nombre");
            } else {
                if (tmp.getPass().equals(user.getPass())) {
                    envioMensaje(req, resp, "Solicitud Aceptada!!:)");
                } else {
                    envioMensaje(req, resp, "Error en credenciales de usuario verifique usuario y password");
                }

            }
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

    private void envioMensaje(HttpServletRequest req, HttpServletResponse resp, String mensaje) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            writer.println(respuesta.escribirMensaje(mensaje));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public DBusuarios recuperarDBusuarios(HttpServletRequest req) {

        try {

            String original = req.getServletContext().getRealPath("");
            String p = original.replaceAll("/WEB_PROYECTO1/target/WEB_PROYECTO1-1.0-SNAPSHOT/", "");

            if (p.equals(original)) {
                System.out.println("SO: WINDOWS");
                p = original.replaceAll("\\WEB_PROYECTO1\\target\\WEB_PROYECTO1-1.0-SNAPSHOT\\", "");
            } else {
                System.out.println("SO: LINUX");
            }

            InputStream input = new FileInputStream(p+"/Almacenamiento/users.db");
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String linea;
            String code = "";
            while ((linea = br.readLine()) != null) {
                code += linea;
            }
            br.close();

            Gson gson = new Gson();
            DBusuarios usuarios = gson.fromJson(code, DBusuarios.class);
            return usuarios;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
