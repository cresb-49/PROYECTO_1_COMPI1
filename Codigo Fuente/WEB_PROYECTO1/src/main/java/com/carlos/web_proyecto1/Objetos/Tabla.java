package com.carlos.web_proyecto1.Objetos;

import java.util.List;

public class Tabla {

    private List<List<String>> filas;
    private String nombreTabla;
    
    public Tabla() {
    }

    public Tabla(List<List<String>> filas) {
        this.filas = filas;
    }
    
    
    public List<List<String>> getFilas() {
        return filas;
    }

    public void setFilas(List<List<String>> filas) {
        this.filas = filas;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    @Override
    public String toString() {
        return "Tabla{" + "nombreTabla=" + nombreTabla + '}';
    }
}
