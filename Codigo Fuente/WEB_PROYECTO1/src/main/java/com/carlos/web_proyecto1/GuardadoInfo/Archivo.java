package com.carlos.web_proyecto1.GuardadoInfo;

import java.io.InputStream;

public class Archivo {
    private String nombre;
    private InputStream data;

    public Archivo() {
    }

    public Archivo(String nombre, InputStream data) {
        this.nombre = nombre;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Archivo{" + "nombre=" + nombre + ", data=" + data + '}';
    }
}
