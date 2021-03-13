package com.carlos.app_cliente_proyecto1.Objetos;

public class consulta {
    private String tag;
    private String query;
    public consulta(String tag, String query) {
        this.tag = tag;
        this.query = query;
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

    @Override
    public String toString() {
        return "consulta{" + "tag=" + tag + ", query=" + query + '}';
    }
        
}
