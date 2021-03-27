package com.carlos.app_cliente_proyecto1.Objetos;

public class consulta {

    private String tag;
    private String query;
    private int linea;
    private int columna;

    public consulta(String tag, String query, int linea, int columna) {
        this.tag = tag;
        this.query = query;
        this.linea = linea;
        this.columna = columna;
    }

    public consulta() {
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "consulta{" + "tag=" + tag + ", query=" + query + '}';
    }

}
