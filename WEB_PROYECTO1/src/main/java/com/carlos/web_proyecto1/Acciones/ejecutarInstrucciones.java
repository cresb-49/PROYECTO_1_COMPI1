package com.carlos.web_proyecto1.Acciones;

import com.carlos.web_proyecto1.DataBases.DBusuarios;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ejecutarInstrucciones {

    private String path;
    private DBusuarios baseUsuarios = null;

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

    }

    public String getPath() {
        return path;
    }
    
    private void iniciarDBs() {

        Gson gson = new Gson();
        
        try {
            FileInputStream input = new FileInputStream(path + "/users.db");
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String linea;
            String code = "";
            
            while ((linea = br.readLine()) != null) {
                code += linea;
            }
            
            br.close();
            DBusuarios baseBusuarios = gson.fromJson(code, DBusuarios.class);
            
        } catch (Exception e) {
            System.out.println("Error en carga de base de datos usuarios");
        }

    }

}
