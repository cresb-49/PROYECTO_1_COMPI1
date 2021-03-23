package com.carlos.web_proyecto1.Objetos;

import java.util.List;

public class Componente {
    private String id;
    private String nombre_campo;
    private String formulario;
    private String clase;
    private String indice;
    private String texto_visible;
    private String alineacion;
    private String requerido;
    private String opciones;
    private String filas;
    private String columnas;
    private String url;

    public Componente(componente base) {
        this.id = base.getId();
        this.nombre_campo = base.getNombre();
        this.formulario = base.getForm();
        this.clase = base.getClase();
        this.indice = base.getIndice();
        this.texto_visible = base.getTexto();
        this.alineacion = base.getAli();
        this.requerido = base.getRequerido();
        this.opciones = base.getOpciones();
        this.filas = base.getFilas();
        this.columnas = base.getColumnas();
        this.url = base.getUrl();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre_campo() {
        return nombre_campo;
    }

    public void setNombre_campo(String nombre_campo) {
        this.nombre_campo = nombre_campo;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
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

    public String getTexto_visible() {
        return texto_visible;
    }

    public void setTexto_visible(String texto_visible) {
        this.texto_visible = texto_visible;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
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
    
    public void modificarComponete(componente comp){
        if(!(comp.getNombre()==null || comp.getNombre().isEmpty())){
            this.nombre_campo = comp.getNombre();
        }
        if(!(comp.getClase()==null || comp.getClase().isEmpty())){
            this.clase = comp.getClase();
        }
        if(!(comp.getIndice()==null || comp.getIndice().isEmpty())){
            this.indice = comp.getIndice();
        }
        if(!(comp.getTexto()==null || comp.getTexto().isEmpty())){
            this.texto_visible = comp.getTexto();
        }
        if(!(comp.getAli()==null || comp.getAli().isEmpty())){
            this.alineacion = comp.getAli();
        }
        if(!(comp.getRequerido()==null || comp.getRequerido().isEmpty())){
            this.requerido = comp.getRequerido();
        }
        if(!(comp.getOpciones()==null || comp.getOpciones().isEmpty())){
            this.opciones = comp.getOpciones();
        }
        if(!(comp.getFilas()==null || comp.getFilas().isEmpty())){
            this.filas = comp.getFilas();
        }
        if(!(comp.getColumnas()==null || comp.getColumnas().isEmpty())){
            this.columnas = comp.getColumnas();
        }
        if(!(comp.getUrl()==null || comp.getUrl().isEmpty())){
            this.url = comp.getUrl();
        }
    }

    @Override
    public String toString() {
        return "Componente{" + "id=" + id + ", nombre_campo=" + nombre_campo + ", formulario=" + formulario + ", clase=" + clase + ", indice=" + indice + ", texto_visible=" + texto_visible + ", alineacion=" + alineacion + ", requerido=" + requerido + ", opciones=" + opciones + ", filas=" + filas + ", columnas=" + columnas + ", url=" + url + '}';
    }
}
