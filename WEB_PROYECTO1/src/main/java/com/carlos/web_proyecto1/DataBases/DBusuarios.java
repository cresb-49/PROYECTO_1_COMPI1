package com.carlos.web_proyecto1.DataBases;

import com.carlos.web_proyecto1.Objetos.usuario;
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
    
    public usuario buscarUsuario(String usua){
        for (usuario user : this.usuarios) {
            if(user.getUser().equals(usua)){
                return user;
            }
        }
        return null;
    }
    
}
