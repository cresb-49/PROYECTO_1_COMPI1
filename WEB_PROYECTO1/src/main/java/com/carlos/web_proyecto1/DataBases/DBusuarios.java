package com.carlos.web_proyecto1.DataBases;

import com.carlos.web_proyecto1.Objetos.usuario;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class DBusuarios {

    private List<usuario> usuarios;

    public DBusuarios() {
    }

    public DBusuarios(List<usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public usuario buscarUsuario(String usua) {
        for (usuario user : this.usuarios) {
            if (user.getUser().equals(usua)) {
                return user;
            }
        }
        return null;
    }

    public String crearUsuario(usuario nuevoUser) {
        String respuesta = "";
        nuevoUser.setAccion(null);
        if (buscarUsuario(nuevoUser.getUser()) == null) {
            if (nuevoUser.getFecha() == null || nuevoUser.getFecha().equals("")) {
                SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy-MM-dd");
                nuevoUser.setFecha(getYearFormat.format(new Date()));
            }
            usuarios.add(nuevoUser);
        } else {
            respuesta = "Ya existe un usuario: " + nuevoUser.getUser() + " en el sistema";
        }
        return respuesta;
    }

}
