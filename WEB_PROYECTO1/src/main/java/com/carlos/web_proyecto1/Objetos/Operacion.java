package com.carlos.web_proyecto1.Objetos;

public class Operacion {
    private String logica;
    private String negacion;
    private String tipoBusqueda;
    private String nameID;
    private String operadorLogico;
    private String valorComparacion;

    public Operacion() {
    }

    public Operacion(String logica, String negacion, String tipoBusqueda, String nameID, String operadorLogico, String valorComparacion) {
        this.logica = logica;
        this.negacion = negacion;
        this.tipoBusqueda = tipoBusqueda;
        this.nameID = nameID;
        this.operadorLogico = operadorLogico;
        this.valorComparacion = valorComparacion;
    }

    public String getLogica() {
        return logica;
    }

    public void setLogica(String logica) {
        this.logica = logica;
    }

    public String getNegacion() {
        return negacion;
    }

    public void setNegacion(String negacion) {
        this.negacion = negacion;
    }

    public String getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(String tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    public String getOperadorLogico() {
        return operadorLogico;
    }

    public void setOperadorLogico(String operadorLogico) {
        this.operadorLogico = operadorLogico;
    }

    public String getValorComparacion() {
        return valorComparacion;
    }

    public void setValorComparacion(String valorComparacion) {
        this.valorComparacion = valorComparacion;
    }

    public String getNameID() {
        return nameID;
    }

    public void setNameID(String nameID) {
        this.nameID = nameID;
    }

    @Override
    public String toString() {
        return "Operacion{" + "logica=" + logica + ", negacion=" + negacion + ", tipoBusqueda=" + tipoBusqueda + ", nameID=" + nameID + ", operadorLogico=" + operadorLogico + ", valorComparacion=" + valorComparacion + '}';
    }
}
