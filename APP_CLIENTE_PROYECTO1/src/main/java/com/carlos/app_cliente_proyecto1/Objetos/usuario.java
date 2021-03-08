package com.carlos.app_cliente_proyecto1.Objetos;

public class usuario {
    private String user;
    private String pass;
    private String fecha;

    public usuario() {
    }

    public usuario(String user, String pass, String fecha) {
        this.user = user;
        this.pass = pass;
        this.fecha = fecha;
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

    @Override
    public String toString() {
        return "usuario{" + "user=" + user + ", pass=" + pass + ", fecha=" + fecha + '}';
    }
}
