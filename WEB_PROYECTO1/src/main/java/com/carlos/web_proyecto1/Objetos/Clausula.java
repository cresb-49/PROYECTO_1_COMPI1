package com.carlos.web_proyecto1.Objetos;

import com.carlos.web_proyecto1.GuardadoInfo.Respuesta;
import com.carlos.web_proyecto1.GuardadoInfo.RespuestaFormulario;
import java.util.List;

public class Clausula {
    private List<RespuestaFormulario> resForms;
    private String operadorLogico;

    public Clausula(List<RespuestaFormulario> resForms, String operadorLogico) {
        this.resForms = resForms;
        this.operadorLogico = operadorLogico;
    }

    public Clausula() {
    }

    public List<RespuestaFormulario> getResForms() {
        return resForms;
    }

    public void setResForms(List<RespuestaFormulario> resForms) {
        this.resForms = resForms;
    }

    public String getOperadorLogico() {
        return operadorLogico;
    }

    public void setOperadorLogico(String operadorLogico) {
        this.operadorLogico = operadorLogico;
    }

    @Override
    public String toString() {
        return "Clausula{" + "resForms=" + resForms + ", operadorLogico=" + operadorLogico + '}';
    }
}
