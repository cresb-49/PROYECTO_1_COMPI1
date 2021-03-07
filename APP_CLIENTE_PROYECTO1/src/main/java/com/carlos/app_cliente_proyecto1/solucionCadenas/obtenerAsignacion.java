package com.carlos.app_cliente_proyecto1.solucionCadenas;

public class obtenerAsignacion {
    public obtenerAsignacion(){
        
    }
    public String getAsignacion(String asignacion){
        if(asignacion.length()!=0){
            return asignacion.substring(1, asignacion.length()-1);
        }
        else{
            return "";
        }
    }
}
