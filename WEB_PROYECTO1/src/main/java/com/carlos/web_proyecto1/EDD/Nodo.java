package com.carlos.web_proyecto1.EDD;

public class Nodo {
    private Nodo siguiente;
    private Object contenido;
    private String tag;

    public Nodo(Nodo siguiente, Object contenido, String tag) {
        this.siguiente = siguiente;
        this.contenido = contenido;
        this.tag = tag;
    }

    public Nodo(Object contenido, String tag) {
        this.contenido = contenido;
        this.tag = tag;
    }

    public Nodo(Object contenido) {
        this.contenido = contenido;
    }
    

    public Nodo() {
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Nodo{" + "siguiente=" + siguiente + ", contenido=" + contenido + ", tag=" + tag + '}';
    }
    
}
