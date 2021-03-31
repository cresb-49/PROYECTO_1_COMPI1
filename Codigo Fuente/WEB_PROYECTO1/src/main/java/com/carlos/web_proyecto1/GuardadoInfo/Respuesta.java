package com.carlos.web_proyecto1.GuardadoInfo;

public class Respuesta {
    private String nombre_campo;
    private String idComponente;
    private String respuesta;

    public Respuesta(String nombre_campo, String idComponente, String respuesta) {
        this.nombre_campo = nombre_campo;
        this.idComponente = idComponente;
        this.respuesta = respuesta;
    }

    public Respuesta() {
    }

    public String getNombre_campo() {
        return nombre_campo;
    }

    public void setNombre_campo(String nombre_campo) {
        this.nombre_campo = nombre_campo;
    }

    public String getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(String idComponente) {
        this.idComponente = idComponente;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Respuesta{" + "nombre_campo=" + nombre_campo + ", idComponente=" + idComponente + ", respuesta=" + respuesta + '}';
    }
}
