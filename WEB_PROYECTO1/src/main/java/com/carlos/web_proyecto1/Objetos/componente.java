package com.carlos.web_proyecto1.Objetos;

public class componente {
    private String id;
    private String nombre;
    private String form;
    private String clase;
    private String indice;
    private String ali;
    private String requerido;
    private String opciones;
    private String filas;
    private String columnas;
    private String url;

    public componente() {
    }

    public componente(String id, String nombre, String form, String clase, String indice, String ali, String requerido, String opciones, String filas, String columnas, String url) {
        this.id = id;
        this.nombre = nombre;
        this.form = form;
        this.clase = clase;
        this.indice = indice;
        this.ali = ali;
        this.requerido = requerido;
        this.opciones = opciones;
        this.filas = filas;
        this.columnas = columnas;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getAli() {
        return ali;
    }

    public void setAli(String ali) {
        this.ali = ali;
    }

    public String getRequerido() {
        return requerido;
    }

    public void setRequerido(String requerido) {
        this.requerido = requerido;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }

    public String getFilas() {
        return filas;
    }

    public void setFilas(String filas) {
        this.filas = filas;
    }

    public String getColumnas() {
        return columnas;
    }

    public void setColumnas(String columnas) {
        this.columnas = columnas;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "componente{" + "id=" + id + ", nombre=" + nombre + ", form=" + form + ", clase=" + clase + ", indice=" + indice + ", ali=" + ali + ", requerido=" + requerido + ", opciones=" + opciones + ", filas=" + filas + ", columnas=" + columnas + ", url=" + url + '}';
    }
    
}
