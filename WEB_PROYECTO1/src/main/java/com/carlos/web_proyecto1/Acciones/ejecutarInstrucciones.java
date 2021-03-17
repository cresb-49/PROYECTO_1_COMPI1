package com.carlos.web_proyecto1.Acciones;

import com.carlos.web_proyecto1.DataBases.DBusuarios;
import com.carlos.web_proyecto1.Objetos.userNew;
import com.carlos.web_proyecto1.Objetos.usuario;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ejecutarInstrucciones {

    private String path;
    private DBusuarios baseUsuarios;
    private List<String> log = new ArrayList<>();
    private sobreEscribirArchivo escribir = new sobreEscribirArchivo();

    public ejecutarInstrucciones() {

    }

    /**
     * Este constructor recibe como parametro el path donde se encunetras las
     * bases de datos del sistema
     *
     * @param path
     */
    public ejecutarInstrucciones(String path) {
        this.path = path;
        this.iniciarDBs();
    }

    public List<String> getLog() {
        return log;
    }

    public String getPath() {
        return path;
    }

    private void iniciarDBs() {

        Gson gson = new Gson();

        try {
            FileInputStream input = new FileInputStream(path + "/Almacenamiento/users.db");
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String linea;
            String code = "";

            while ((linea = br.readLine()) != null) {
                code += linea;
            }

            br.close();
            this.baseUsuarios = gson.fromJson(code, DBusuarios.class);

        } catch (Exception e) {
            System.out.println("Error en carga de base de datos usuarios");
            e.printStackTrace();
        }

    }

    public void ejecutarIntrucciones(List<Object> instrucciones) {
        Gson gson = new Gson();
        Object tmp;
        String res;
        for (int i = (instrucciones.size() - 1); i >= 0; i--) {
            tmp = instrucciones.get(i);
            if (tmp instanceof usuario) {
                switch (((usuario) tmp).getAccion()) {
                    case "CREAR_USUARIO":
                        res = baseUsuarios.crearUsuario(((usuario) tmp));
                        log.add(res);
                        break;
                    case "ELIMINAR_USUARIO":
                        res = baseUsuarios.eliminarUsuario((usuario) tmp);
                        log.add(res);
                        break;
                    default:
                        //System.out.println("Accion no registrada usuario: " + ((usuario) tmp).getAccion());
                }
            }
            if (tmp instanceof userNew) {
                switch (((userNew) tmp).getAccion()) {
                    case "MODIFICAR_USUARIO":
                        res=baseUsuarios.modificarUsuario(((userNew)tmp));
                        log.add(res);
                        break;
                    default:
                        //System.out.println("Accion no registrada new usuario: " + ((usuario) tmp).getAccion());
                }
            }

        }
        escribir.escritura(path + "/Almacenamiento/users.db", gson.toJson(baseUsuarios));

    }

}
