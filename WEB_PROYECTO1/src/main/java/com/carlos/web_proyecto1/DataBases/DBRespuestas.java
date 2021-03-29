package com.carlos.web_proyecto1.DataBases;

import java.util.List;
import com.carlos.web_proyecto1.GuardadoInfo.*;
import java.util.ArrayList;

public class DBRespuestas {
    private List<RespuestaFormulario> respuestas;

    public DBRespuestas() {
    }

    public DBRespuestas(List<RespuestaFormulario> respuestas) {
        this.respuestas = respuestas;
    }

    public List<RespuestaFormulario> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaFormulario> respuestas) {
        this.respuestas = respuestas;
    }
    public void agregarRespuesta(RespuestaFormulario respuesta){
        if(this.respuestas == null){
            this.respuestas = new ArrayList<>();
        }
        this.respuestas.add(respuesta);
    }
    
    
    public List<RespuestaFormulario> respuestasIDForm(String id){
        List<RespuestaFormulario> respuesta = new ArrayList<>();
        
        for (RespuestaFormulario respuestaFormulario : this.respuestas) {
            if(respuestaFormulario.getIdForm().equals(id)){
                respuesta.add(respuestaFormulario);
            }
        }
        
        return respuesta;
    }
    
    public List<RespuestaFormulario> respuestasNameForm(String name){
        List<RespuestaFormulario> respuesta = new ArrayList<>();
        
        for (RespuestaFormulario respuestaFormulario : this.respuestas) {
            if(respuestaFormulario.getNombreFormulario().equals(name)){
                respuesta.add(respuestaFormulario);
            }
        }
        return respuesta;
    }
    
}
