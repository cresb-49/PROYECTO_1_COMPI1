package com.carlos.app_cliente_proyecto1.Objetos;

public class mensaje {
    private String mensaje;

    public mensaje() {
    }

    public mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "mensaje{" + "mensaje=" + mensaje + '}';
    }
    
}
