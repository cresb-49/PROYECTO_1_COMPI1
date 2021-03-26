package com.carlos.web_proyecto1.Servlets;

import com.carlos.web_proyecto1.DataBases.DBFormularios;
import com.carlos.web_proyecto1.GuardadoInfo.Respuesta;
import com.carlos.web_proyecto1.GuardadoInfo.Archivo;
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
import java.io.FileInputStream;
import java.io.InputStreamReader;
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

    }

    private void recuperarArchivo(HttpServletRequest req, List<Archivo> archivos, List<Respuesta> respuestas, Componente componente) {
        try {
            Part filePart = req.getPart(componente.getNombre_campo());
            if (filePart.getSize() > 0) {
                archivos.add(new Archivo(filePart.getName(), filePart.getInputStream()));
                respuestas.add(new Respuesta(componente.getNombre_campo(), componente.getId(), filePart.getName()));
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

}
