package com.carlos.web_proyecto1.Objetos;

public class formulariotmp {
    private String id;
    private String titulo;
    private String nombre;
    private String tema;
    private String user;
    private String fecha;
    
    private String accion;
    
    public formulariotmp() {
    }

    public formulariotmp(String id, String titulo, String nombre, String tema, String user, String fecha) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.tema = tema;
        this.user = user;
        this.fecha = fecha;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    @Override
    public String toString() {
        return "formulario{" + "id=" + id + ", titulo=" + titulo + ", nombre=" + nombre + ", tema=" + tema + ", user=" + user + ", fecha=" + fecha + ", accion=" + accion + '}';
    }
}
