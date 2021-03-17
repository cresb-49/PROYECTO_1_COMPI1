package com.carlos.app_cliente_proyecto1.Objetos;

public class usuario {
    private String user;
    private String pass;
    private String fecha;
    private String fechaMod;
    
    private String accion;

    public usuario() {
        this.fechaMod="";
    }

    public usuario(String user, String pass, String fecha) {
        this.user = user;
        this.pass = pass;
        this.fecha = fecha;
        this.fechaMod="";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
    
    public String getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(String fecha) {
        this.fechaMod = fecha;
    }

    @Override
    public String toString() {
        return "usuario{" + "user=" + user + ", pass=" + pass + ", fecha=" + fecha + ", fechaMod=" + fechaMod + ", accion=" + accion + '}';
    }

    
}
