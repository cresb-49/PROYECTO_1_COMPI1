
package com.carlos.web_proyecto1.Servlets;

import com.carlos.web_proyecto1.escribirRespuestaIndigo.resIndigo;
import java.io.IOException;
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
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idForm = req.getParameter("idForm");
        System.out.println("peticion de formulario");
        if(idForm!=null){
            envioMensaje(req, resp, "Se recibio con exito el id del formulario");
        }else{
            envioMensaje(req, resp, "No se recibio ningun id de formulario");
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
}
