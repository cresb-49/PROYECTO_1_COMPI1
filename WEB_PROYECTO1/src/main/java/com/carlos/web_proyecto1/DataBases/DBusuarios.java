package com.carlos.web_proyecto1.DataBases;

import com.carlos.web_proyecto1.Objetos.userNew;
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
            respuesta = "El usuario " + nuevoUser.getUser() + " fue creado exitosamente";
        } else {
            respuesta = "Ya existe un usuario: " + nuevoUser.getUser() + " en el sistema";
        }
        return respuesta;
    }
    
    public String eliminarUsuario(usuario user){
        String respuesta = "";
        boolean bandera = false;
        
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getUser().equals(user.getUser())){
                usuarios.remove(i);
                bandera=true;
                break;
            }
        }
        
        if(bandera){
            respuesta = "El usuario "+user.getUser()+" fue eliminado con exito";
        }else{
            respuesta = "No existe un usuario "+user.getUser()+" en el sistema";
        }
        
        return respuesta;
    }
    
    public String modificarUsuario(userNew user){
        String respuesta = "";
        usuario tmp = buscarUsuario(user.getUser());
        
        if(tmp==null){
            respuesta = "No existe un usuario "+user.getUser()+" para modificar";
        }else{
            if(user.getUser().equals("Admin")){
                if(user.getNewUser().equals("Admin")){
                    tmp.setPass(user.getNewPass());
                }else{
                    respuesta = "No puede modificar el nombre de Admin solo su password\nSi desea cambiar el password escriba como nuevo usuario Admin nuevamente";
                }
            }else{
                respuesta = "Se modifico exitosamente el usuario "+tmp.getUser();
                
                SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy-MM-dd");
                tmp.setUser(user.getNewUser());
                tmp.setPass(user.getNewPass());
                tmp.setFechaMod(getYearFormat.format(new Date()));
                
            }
        }
        return respuesta;
    }

}
