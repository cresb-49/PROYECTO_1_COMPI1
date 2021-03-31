package com.carlos.web_proyecto1.GuardadoInfo;

import java.util.List;

public class RespuestaFormulario {

    private String idForm;
    private String nombreFormulario;
    
    private List<Respuesta> respuestas;

    public RespuestaFormulario() {
    }

    public RespuestaFormulario(String idForm, String nombreFormulario, List<Respuesta> respuestas) {
        this.idForm = idForm;
        this.nombreFormulario = nombreFormulario;
        this.respuestas = respuestas;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public String getIdForm() {
        return idForm;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
    }

    public String getNombreFormulario() {
        return nombreFormulario;
    }

    public void setNombreFormulario(String nombreFormulario) {
        this.nombreFormulario = nombreFormulario;
    }

    @Override
    public String toString() {
        return "RespuestaFormulario{" + "idForm=" + idForm + ", nombreFormulario=" + nombreFormulario + ", respuestas=" + respuestas + '}';
    }
    
    
}
