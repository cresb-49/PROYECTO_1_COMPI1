package com.carlos.web_proyecto1.Objetos;

public class contenedorResultado {
    private String parametro;
    private String asignacion;
    public contenedorResultado(){
        
    }
    
    public contenedorResultado(String parametro, String asignacion) {
        this.parametro = parametro;
        this.asignacion = asignacion;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    @Override
    public String toString() {
        return "contenedorResultado{" + "parametro=" + parametro + ", asignacion=" + asignacion + '}';
    } 
}
