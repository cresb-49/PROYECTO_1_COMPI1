package com.carlos.web_proyecto1.Servlets;

import com.carlos.web_proyecto1.Acciones.sobreEscribirArchivo;
import com.carlos.web_proyecto1.DataBases.DBFormularios;
import com.carlos.web_proyecto1.Lexer.lexerImportar;
import com.carlos.web_proyecto1.Objetos.Componente;
import com.carlos.web_proyecto1.Objetos.Formulario;
import com.carlos.web_proyecto1.Objetos.usuario;
import com.carlos.web_proyecto1.Parser.parserImportar;
import com.carlos.web_proyecto1.escribirRespuestaIndigo.resIndigo;
import com.google.gson.Gson;
import com.sun.tools.doclint.Entity;
import java.io.BufferedReader;
import java.io.FileInputStream;
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

@WebServlet("/importForm")
public class ImportarFormulario extends HttpServlet {

    private DBFormularios baseForms = new DBFormularios();
    private resIndigo respuesta = new resIndigo();
    private sobreEscribirArchivo escribir = new sobreEscribirArchivo();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String original = req.getServletContext().getRealPath("");
        String path = original.replaceAll("/WEB_PROYECTO1/target/WEB_PROYECTO1-1.0-SNAPSHOT/", "");
        if (path.equals(original)) {
            System.out.println("SO: WINDOWS");
            String busqueda = "\\\\WEB_PROYECTO1\\\\target\\\\WEB_PROYECTO1-1.0-SNAPSHOT\\\\";
            path = original.replaceAll(busqueda, "");

        } else {
            System.out.println("SO: LINUX");
        }

        this.cargarBaseDatos(path);

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
            lexerImportar lex = new lexerImportar(new StringReader(resultado.toString()));
            parserImportar parser = new parserImportar(lex);

            parser.parse();

            errLex = lex.getErrorsList();
            errSin = parser.getErrorsList();

            List<String> mensajes = new ArrayList<>();

            if (!errLex.isEmpty() || !errSin.isEmpty()) {
                this.envioRespuesta(req, resp, errSin, errLex);
            } else {

                List<Formulario> forms = parser.getFormularios();

                for (Formulario form : forms) {
                    if (this.baseForms.buscarFormulario(form.getId()) == null) {

                        List<Componente> componentes = form.getComponentes();
                        for (int i = 0; i < componentes.size(); i++) {
                            for (int j = i + 1; j < componentes.size(); j++) {

                                if (!(componentes.get(i).equals(componentes.get(j)))) {
                                    try {
                                        if (componentes.get(i).getId().equals(componentes.get(j).getId())) {
                                            mensajes.add("El componente de clase: " + componentes.get(j).getClase() + " comparte el mismo id con el componente clase: " + componentes.get(i).getClase() + " en el formulario id: " + form.getId());
                                        } else if (componentes.get(i).getNombre_campo().equals(componentes.get(j).getNombre_campo())) {
                                            mensajes.add("El componente de clase: " + componentes.get(j).getClase() + " comparte el mismo nombre con el componente clase: " + componentes.get(i).getClase() + " en el fomularios id: " + form.getId());

                                        }
                                    } catch (Exception e) {
                                    }

                                }

                            }
                        }
                        if (mensajes.isEmpty()) {
                            int cont = 1;
                            for (Componente componente : form.getComponentes()) {
                                componente.setFormulario(form.getId());
                                componente.setIndice(String.valueOf(cont));
                            }
                            System.out.println("Agrege el formulario");
                            if (this.baseForms.getFormularios() == null) {
                                this.baseForms.setFormularios(new ArrayList<Formulario>());
                            }
                            this.baseForms.getFormularios().add(form);
                            this.escribirDatos(path, baseForms);
                            mensajes.add("Se agrego con exito el formulario: " + form.getId());

                        }

                    } else {
                        mensajes.add("Ya existe un formulario con el id: " + form.getId());
                    }
                }
            }

            if (!mensajes.isEmpty()) {
                this.envioRespuestas(req, resp, mensajes);
            }

        } catch (Exception e) {
            System.out.println("Error en lex y parser de importacion de formulario");
            e.printStackTrace();
        }
    }

    private void escribirDatos(String path, DBFormularios formularios) {
        try {
            Gson gson = new Gson();
            escribir.escritura(path + "/Almacenamiento/forms.db", gson.toJson(formularios));
        } catch (Exception e) {
            System.out.println("Error es escribir archivo");
            e.printStackTrace();
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

    private void envioRespuesta(HttpServletRequest req, HttpServletResponse resp, List<String> errSin, List<String> errLex) throws ServletException, IOException {
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

    private void envioRespuestas(HttpServletRequest req, HttpServletResponse resp, List<String> mensajes) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            writer.println(respuesta.escribirMensajes(mensajes));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
