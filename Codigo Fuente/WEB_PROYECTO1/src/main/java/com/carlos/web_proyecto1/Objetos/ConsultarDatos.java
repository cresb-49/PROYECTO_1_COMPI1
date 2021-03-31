package com.carlos.web_proyecto1.Objetos;

import java.util.List;

public class ConsultarDatos {
    List<consulta> consultas;

    public ConsultarDatos() {
    }

    public List<consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "ConsultarDatos{" + "consultas=" + consultas + '}';
    }
}
