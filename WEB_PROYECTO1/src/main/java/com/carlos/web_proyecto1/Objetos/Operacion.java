package com.carlos.web_proyecto1.Objetos;

public class Operacion {
    private String referenceType;
    private String referencia;
    private String operadorRelacional;
    private String valorComparacion;
    
    private String relacionLogica;

    public Operacion() {
    }

    public Operacion(String referenceType, String referencia, String operadorRelacional, String valorComparacion) {
        this.referenceType = referenceType;
        this.referencia = referencia;
        this.operadorRelacional = operadorRelacional;
        this.valorComparacion = valorComparacion;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getOperadorRelacional() {
        return operadorRelacional;
    }

    public void setOperadorRelacional(String operadorRelacional) {
        this.operadorRelacional = operadorRelacional;
    }

    public String getValorComparacion() {
        return valorComparacion;
    }

    public void setValorComparacion(String valorComparacion) {
        this.valorComparacion = valorComparacion;
    }

    public String getRelacionLogica() {
        return relacionLogica;
    }

    public void setRelacionLogica(String relacionLogica) {
        this.relacionLogica = relacionLogica;
    }

    @Override
    public String toString() {
        return "Operacion{" + "referenceType=" + referenceType + ", referencia=" + referencia + ", operadorRelacional=" + operadorRelacional + ", valorComparacion=" + valorComparacion + ", relacionLogica=" + relacionLogica + '}';
    }
    
}
