package com.carlos.web_proyecto1.Servlets;

import com.carlos.web_proyecto1.ComponentesToHTML.ComponenteToHTML;
import com.carlos.web_proyecto1.DataBases.DBFormularios;
import com.carlos.web_proyecto1.Objetos.Formulario;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getForm")
public class getForm extends HttpServlet {

    private DBFormularios baseForms = new DBFormularios();
    private ComponenteToHTML conversion = new ComponenteToHTML();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String original = req.getServletContext().getRealPath("");
        String path = original.replaceAll("/WEB_PROYECTO1/target/WEB_PROYECTO1-1.0-SNAPSHOT/", "");
        this.cargarBaseDatos(path);

        String idForm = req.getParameter("idForm");

        Formulario form = this.baseForms.buscarFormulario(((idForm == null) ? "" : idForm));

        if (form != null) {
            String HTML = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "<head>\n"
                    + "    <meta charset=\"UTF-8\">\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + ((form.getTema().equals("Dark")?"<link rel=\"stylesheet\" href=\"/WEB_PROYECTO1/Resourses/CSS/dark2.css\">":"<link rel=\"stylesheet\" href=\"/WEB_PROYECTO1/Resourses/CSS/defaultTheme.css\">"))
                    + "    <title>FORMULARIO DATA FORMS</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<header>\n"
                    + "<br/>\n"
                    + "<h1>" + form.getTitulo() + "</h1>\n"
                    + "</header>"
                    + "    <form action=\"registarRespuesta\" enctype=\"multipart/form-data\" method=\"post\">\n"
                    + "        <input type=\"hidden\" name=\"idForm\" id=\"idForm\" value=\"" + idForm + "\">\n"
                    + this.conversion.convertir(form.getComponentes())
                    + "    </form>\n"
                    + "<footer>\n"
                    + "<h5>DATA FORMS 2021</h5>\n"
                    + "</footer>"
                    + "</body>\n"
                    + "</html>";
            this.enviarHTML(req, resp, HTML);
        } else {
            String HTML = "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "    <meta charset=\"UTF-8\">\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    <title>ERROR DE FORMULARIO</title>\n"
                    + "    <link rel='stylesheet' href='/WEB_PROYECTO1/Resourses/CSS/error.css'>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "    <form action=\"/WEB_PROYECTO1/index.jsp\">\n"
                    + "        <h6>Parece que no hay un formulario con el codigo ingresado :c</h6>\n"
                    + "        <button class=\"btn\">Regresar al inicio</button>\n"
                    + "    </form>\n"
                    + "</body>\n"
                    + "</html>";
            this.enviarHTML(req, resp, HTML);
        }

    }

    private void cargarBaseDatos(String path) {
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path + "/Almacenamiento/forms.db")));
            String liena;
            String code = "";

            while ((liena = br.readLine()) != null) {
                code += liena;
            }
            br.close();
            this.baseForms = gson.fromJson(code, DBFormularios.class);
        } catch (Exception e) {
            System.out.println("Error en carga de base de datos formularios");
            e.printStackTrace();
        }
    }

    private void enviarHTML(HttpServletRequest req, HttpServletResponse resp, String HTML) {
        try {
            PrintWriter writer = resp.getWriter();
            writer.println(HTML);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
