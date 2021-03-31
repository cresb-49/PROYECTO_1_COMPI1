package com.carlos.web_proyecto1.Objetos;

import com.carlos.web_proyecto1.GuardadoInfo.RespuestaFormulario;
import java.util.List;

public class PaqueteConsultas {
    private String nombreConsulta;
    private String idForm;
    private String nombre;
    private List<RespuestaFormulario> resultado;
    private List<String> camposProyectar;

    public PaqueteConsultas() {
    }

    public PaqueteConsultas(String idForm,String nombre,String nombreConsulta, List<RespuestaFormulario> resultado, List<String> camposProyectar) {
        this.idForm = idForm;
        this.nombre = nombre;
        this.nombreConsulta = nombreConsulta;
        this.resultado = resultado;
        this.camposProyectar = camposProyectar;
    }

    public String getNombreConsulta() {
        return nombreConsulta;
    }

    public void setNombreConsulta(String nombreConsulta) {
        this.nombreConsulta = nombreConsulta;
    }

    public List<RespuestaFormulario> getResultado() {
        return resultado;
    }

    public void setResultado(List<RespuestaFormulario> resultado) {
        this.resultado = resultado;
    }

    public List<String> getCamposProyectar() {
        return camposProyectar;
    }

    public void setCamposProyectar(List<String> camposProyectar) {
        this.camposProyectar = camposProyectar;
    }

    public String getIdForm() {
        return idForm;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    @Override
    public String toString() {
        return "PaqueteConsultas{" + "nombreConsulta=" + nombreConsulta + ", camposProyectar=" + camposProyectar + '}';
    }
    
    
}
