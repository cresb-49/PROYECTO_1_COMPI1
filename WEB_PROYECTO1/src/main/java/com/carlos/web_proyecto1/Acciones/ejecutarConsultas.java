package com.carlos.web_proyecto1.Acciones;

import com.carlos.web_proyecto1.DataBases.DBFormularios;
import com.carlos.web_proyecto1.DataBases.DBRespuestas;
import com.carlos.web_proyecto1.DataBases.DBusuarios;
import com.carlos.web_proyecto1.Objetos.*;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ejecutarConsultas {

    private String path;
    private DBusuarios baseUsuarios;
    private DBFormularios baseForms;
    private DBRespuestas baseRes;
    private List<String> log = new ArrayList<>();
    private sobreEscribirArchivo escribir = new sobreEscribirArchivo();

    public ejecutarConsultas() {

    }

    /**
     * Este constructor recibe como parametro el path donde se encunetras las
     * bases de datos del sistema
     *
     * @param path
     */
    public ejecutarConsultas(String path) {
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
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path + "/Almacenamiento/users.db")));
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
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path + "/Almacenamiento/forms.db")));
            String liena;
            String code = "";

            while ((liena = br.readLine()) != null) {
                code += liena;
            }
            br.close();
            this.baseForms = gson.fromJson(code, DBFormularios.class);
        } catch (Exception e) {
            System.out.println("Error en carga de base de datos formularios");
            e.printStackTrace();
        }
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path + "/Almacenamiento/resForms.db")));
            String liena;
            String code = "";

            while ((liena = br.readLine()) != null) {
                code += liena;
            }
            br.close();
            this.baseRes = gson.fromJson(code, DBRespuestas.class);
        } catch (Exception e) {
            System.out.println("Error en carga de base de datos de respuestas");
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
                log.add("En este espacio no se realizan acciones para usuarios");
            }
            if (tmp instanceof userNew) {
                log.add("En este espacio no se realizan acciones para usuarios nuevos");
            }
            if (tmp instanceof formulariotmp) {
                log.add("En este espacio no se realizan acciones para fromularios");
            }
            if (tmp instanceof componentetmp) {
                log.add("En este espacio no se realizan acciones para componentes");
            }
            if(tmp instanceof consulta){
                
            }
        }
    }

}
