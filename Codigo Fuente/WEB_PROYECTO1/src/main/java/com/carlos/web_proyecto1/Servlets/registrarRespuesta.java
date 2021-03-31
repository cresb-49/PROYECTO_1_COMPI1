package com.carlos.web_proyecto1.Servlets;

import com.carlos.web_proyecto1.Acciones.sobreEscribirArchivo;
import com.carlos.web_proyecto1.DataBases.DBFormularios;
import com.carlos.web_proyecto1.DataBases.DBRespuestas;
import com.carlos.web_proyecto1.GuardadoInfo.Respuesta;
import com.carlos.web_proyecto1.GuardadoInfo.Archivo;
import com.carlos.web_proyecto1.GuardadoInfo.RespuestaFormulario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.carlos.web_proyecto1.Objetos.*;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/registarRespuesta")
@MultipartConfig(maxFileSize = 16177215)
public class registrarRespuesta extends HttpServlet {

    private DBFormularios baseForms = new DBFormularios();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.cargarBaseDatos(req);
        List<Archivo> archivos = new ArrayList<>();
        List<Respuesta> respuestas = new ArrayList<>();
        Formulario form = baseForms.buscarFormulario(req.getParameter("idForm"));

        for (Componente componente : form.getComponentes()) {
            switch (componente.getClase()) {
                case "CAMPO_TEXTO":
                    recuperarInfo(req, respuestas, componente);
                    break;
                case "AREA_TEXTO":
                    recuperarInfo(req, respuestas, componente);
                    break;
                case "CHECKBOX":
                    recuperarInfo(req, respuestas, componente);
                    break;
                case "RADIO":
                    recuperarInfo(req, respuestas, componente);
                    break;
                case "FICHERO":
                    recuperarArchivo(req, archivos, respuestas, componente);
                    break;
                case "COMBO":
                    recuperarInfo(req, respuestas, componente);
                    break;
            }
        }

        RespuestaFormulario respuestasForm = new RespuestaFormulario(form.getId(), form.getNombre(), respuestas);

        registarRespuestas(req, respuestasForm);

        this.mensajefinalFormulario(req, resp);

    }

    private void recuperarArchivo(HttpServletRequest req, List<Archivo> archivos, List<Respuesta> respuestas, Componente componente) {
        try {
            Part filePart = req.getPart(componente.getNombre_campo());
            if (filePart.getSize() > 0) {
                archivos.add(new Archivo(filePart.getSubmittedFileName(), filePart.getInputStream()));
                respuestas.add(new Respuesta(componente.getNombre_campo(), componente.getId(), filePart.getSubmittedFileName()));
                FileOutputStream stream = null;
                try {
                    String original = req.getServletContext().getRealPath("");
                    String path = original.replaceAll("/WEB_PROYECTO1/target/WEB_PROYECTO1-1.0-SNAPSHOT/", "");
                    
                    if (path.equals(original)) {
                        System.out.println("SO: WINDOWS");
                        String busqueda = "\\\\WEB_PROYECTO1\\\\target\\\\WEB_PROYECTO1-1.0-SNAPSHOT\\\\";
                        path = original.replaceAll(busqueda, "");

                    } else {
                        System.out.println("SO: LINUX");
                    }

                    path = path + "/Almacenamiento/Archivos/";
                    path = path + filePart.getSubmittedFileName();

                    System.out.println("path nuevo: " + path);
                    stream = new FileOutputStream(new File(path));
                    byte[] bytes = filePart.getInputStream().readAllBytes();
                    stream.write(bytes);

                } catch (Exception e) {
                    System.out.println("Error en escritura de archivo");
                    e.printStackTrace();
                } finally {
                    if (stream != null) {
                        try {
                            stream.close();
                        } catch (IOException ignored) {
                        }
                    }
                }

            }
        } catch (Exception ex) {
            System.out.println("Error de fichero: " + ex.getMessage());
        }
    }

    private void recuperarInfo(HttpServletRequest req, List<Respuesta> respuestas, Componente componente) {
        respuestas.add(new Respuesta(componente.getNombre_campo(), componente.getId(), req.getParameter(componente.getNombre_campo())));
    }

    private void cargarBaseDatos(HttpServletRequest req) {
        Gson gson = new Gson();
        String original = req.getServletContext().getRealPath("");
        String path = original.replaceAll("/WEB_PROYECTO1/target/WEB_PROYECTO1-1.0-SNAPSHOT/", "");
        
        if (path.equals(original)) {
            System.out.println("SO: WINDOWS");
            String busqueda = "\\\\WEB_PROYECTO1\\\\target\\\\WEB_PROYECTO1-1.0-SNAPSHOT\\\\";
            path = original.replaceAll(busqueda, "");

        } else {
            System.out.println("SO: LINUX");
        }
        
        

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
            System.out.println("Error en carga de base de datos formularios en registro de respuestas");
            e.printStackTrace();
        }
    }

    private void registarRespuestas(HttpServletRequest req, RespuestaFormulario respuesta) {
        Gson gson = new Gson();
        String original = req.getServletContext().getRealPath("");
        String path = original.replaceAll("/WEB_PROYECTO1/target/WEB_PROYECTO1-1.0-SNAPSHOT/", "");
        
        if (path.equals(original)) {
            System.out.println("SO: WINDOWS");
            String busqueda = "\\\\WEB_PROYECTO1\\\\target\\\\WEB_PROYECTO1-1.0-SNAPSHOT\\\\";
            path = original.replaceAll(busqueda, "");

        } else {
            System.out.println("SO: LINUX");
        }
        
        
        DBRespuestas respuestasForms = new DBRespuestas();
        sobreEscribirArchivo escribir = new sobreEscribirArchivo();

        //Carga de la base de datos
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path + "/Almacenamiento/resForms.db")));
            String liena;
            String code = "";
            while ((liena = br.readLine()) != null) {
                code += liena;
            }
            br.close();
            respuestasForms = gson.fromJson(code, DBRespuestas.class);
        } catch (Exception e) {
            System.out.println("Error en carga de base de datos de respuestas de formularios");
            e.printStackTrace();
        }
        //se agrega la informacion nueva en la base de datos
        respuestasForms.agregarRespuesta(respuesta);
        //Escritura en la base de datos
        escribir.escritura(path + "/Almacenamiento/resForms.db", gson.toJson(respuestasForms));
    }

    private void mensajefinalFormulario(HttpServletRequest req, HttpServletResponse resp) {
        String HTML = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>Gracias por responder</title>\n"
                + "    <link rel='stylesheet' href='/WEB_PROYECTO1/Resourses/CSS/error.css'>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <form action=\"/WEB_PROYECTO1/index.jsp\">\n"
                + "        <h6>Se envio con exito la respuesta del formulario</h6>\n"
                + "        <h6>Gracias por usar nuestra plataforma ;)</h6>\n"
                + "        <button class=\"btn\">Regresar al inicio</button>\n"
                + "    </form>\n"
                + "</body>\n"
                + "</html>";
        try {
            PrintWriter writer = resp.getWriter();
            writer.println(HTML);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
