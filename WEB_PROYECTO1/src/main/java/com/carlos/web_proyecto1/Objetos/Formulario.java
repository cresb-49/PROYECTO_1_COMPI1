/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.web_proyecto1.Objetos;

import java.util.List;

public class Formulario {

    private String id;
    private String titulo;
    private String nombre;
    private String tema;
    private String fecha;
    private List<Componente> componentes;

    public Formulario(formulariotmp base) {
        this.id = base.getId();
        this.titulo = base.getTitulo();
        this.nombre = base.getNombre();
        this.tema = base.getTema();
        this.fecha = base.getFecha();
    }

    public Formulario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    @Override
    public String toString() {
        return "Formulario{" + "id=" + id + ", titulo=" + titulo + ", nombre=" + nombre + ", tema=" + tema + ", fecha=" + fecha + ", componentes=" + componentes + '}';
    }
}
