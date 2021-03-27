package com.carlos.web_proyecto1.Servlets;

import com.carlos.web_proyecto1.Acciones.FormularioToJson.FormToJson;
import com.carlos.web_proyecto1.DataBases.DBFormularios;
import com.carlos.web_proyecto1.Objetos.Formulario;
import com.carlos.web_proyecto1.escribirRespuestaIndigo.resIndigo;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exportForm")
public class exportarFormulario extends HttpServlet {

    private resIndigo respuesta = new resIndigo();
    private FormToJson conv = new FormToJson();
    private DBFormularios baseForms = new DBFormularios();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String original = req.getServletContext().getRealPath("");
        String path = original.replaceAll("/WEB_PROYECTO1/target/WEB_PROYECTO1-1.0-SNAPSHOT/", "");
        this.cargarBaseDatos(path);

        String idForm = req.getParameter("idForm");
        System.out.println("peticion de formulario");
        
        if (idForm != null) {
            
            Formulario tmp = this.baseForms.buscarFormulario(idForm);
            
            if(tmp==null){
                envioMensaje(req, resp, "No existe un formulario con el id: "+idForm);
            }else{
                envioFormulario(req, resp, conv.toJsonString(tmp));
            }
            
        } else {
            envioMensaje(req, resp, "No se recibio ningun id de formulario");
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

    private void envioMensaje(HttpServletRequest req, HttpServletResponse resp, String mensaje) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            writer.println(respuesta.escribirMensaje(mensaje));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void envioFormulario(HttpServletRequest req, HttpServletResponse resp, String code) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            writer.println(code);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
