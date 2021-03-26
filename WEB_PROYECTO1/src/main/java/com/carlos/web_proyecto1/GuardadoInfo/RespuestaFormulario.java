package com.carlos.web_proyecto1.GuardadoInfo;

import java.util.List;

public class RespuestaFormulario {
    private List<Respuesta> respuestas;
    private String idForm;

    public RespuestaFormulario() {
    }

    public RespuestaFormulario(List<Respuesta> respuestas, String idForm) {
        this.respuestas = respuestas;
        this.idForm = idForm;
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

    @Override
    public String toString() {
        return "RespuestaFormulario{" + "respuestas=" + respuestas + ", idForm=" + idForm + '}';
    }
}
