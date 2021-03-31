package com.carlos.web_proyecto1.Acciones;

import com.carlos.web_proyecto1.DataBases.DBFormularios;
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

public class ejecutarInstrucciones {

    private String path;
    private DBusuarios baseUsuarios;
    private DBFormularios baseForms;
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
                        res = baseUsuarios.modificarUsuario(((userNew) tmp));
                        log.add(res);
                        break;
                    default:
                    //System.out.println("Accion no registrada new usuario: " + ((usuario) tmp).getAccion());
                }
            }
            if (tmp instanceof formulariotmp) {
                switch (((formulariotmp) tmp).getAccion()) {
                    case "NUEVO_FORMULARIO":
                        res = baseForms.agregarFormulario((formulariotmp) tmp);
                        log.add(res);
                        break;
                    case "ELIMINAR_FORMULARIO":
                        res = baseForms.eliminarFormulario((formulariotmp) tmp);
                        log.add(res);
                        break;
                    case "MODIFICAR_FORMULARIO":
                        res = baseForms.modificarFormulario((formulariotmp) tmp);
                        log.add(res);
                        break;
                    default:
                        System.out.println("Accion no registrada formulario: " + ((formulariotmp) tmp).getAccion());
                }
            }
            if (tmp instanceof componentetmp) {
                switch (((componentetmp) tmp).getAccion()) {
                    case "AGREGAR_COMPONENTE":
                        res = baseForms.agregarComponente(((componentetmp)tmp));
                        log.add(res);
                        break;
                    case "ELIMINAR_COMPONENTE":
                        res = baseForms.eliminarComponente((componentetmp)tmp);
                        log.add(res);
                        break;
                    case "MODIFICAR_COMPONENTE":
                        res = baseForms.modificarComponente((componentetmp)tmp);
                        log.add(res);
                        break;
                    default:
                        System.out.println("Accion no registrada componente: " + ((componentetmp) tmp).getAccion());
                }
            }
            if(tmp instanceof consulta){
                log.add("Linea: "+((consulta)tmp).getLinea()+", Columna: "+((consulta)tmp).getColumna()+" en este espacio no se procesan consultas, realicelo en el espacio correspondiente de la app cliente");
            }
            escribir.escritura(path + "/Almacenamiento/users.db", gson.toJson(baseUsuarios));
            escribir.escritura(path + "/Almacenamiento/forms.db", gson.toJson(baseForms));
        }
    }

}
