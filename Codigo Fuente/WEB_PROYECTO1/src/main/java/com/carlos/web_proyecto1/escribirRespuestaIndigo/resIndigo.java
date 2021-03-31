package com.carlos.web_proyecto1.escribirRespuestaIndigo;

import java.util.List;

public class resIndigo {

    public resIndigo() {
        
    }
    public String escribirMensajeError(List<String> errSin,List<String> errLex){
        String respuesta="<!ini_respuestas>\n";
        
        if(!errLex.isEmpty()){
            respuesta = respuesta + "<!ini_respuesta:\"ERRORES_LEXICOS\">\n";
            respuesta = respuesta + "{\"DESCRIPCION\":[\n";
            
            for (int i = 0; i < errLex.size(); i++) {
                respuesta = respuesta + "{\n \"MENSAJE\": \""+errLex.get(i)+"\"}";
                if(!(i == (errLex.size()-1))){
                    respuesta = respuesta +",\n";
                }
            }
            respuesta = respuesta + "\n]}\n";
            respuesta = respuesta + "<fin_respuesta!>\n";
        }
        
        if(!errSin.isEmpty()){
            respuesta = respuesta + "<!ini_respuesta:\"ERRORES_SINTACTICOS\">\n";
            respuesta = respuesta + "{\"DESCRIPCION\":[\n";
            
            
            for (int i = 0; i < errSin.size(); i++) {
                respuesta = respuesta + "{\n \"MENSAJE\": \""+errSin.get(i)+"\"}";
                if(!(i == (errSin.size()-1))){
                    respuesta = respuesta +",\n";
                }
            }
            respuesta = respuesta + "\n]}\n";
            respuesta = respuesta + "<fin_respuesta!>\n";
        }
        respuesta = respuesta + "<!fin_respuestas>\n";
        
        return respuesta;
    }
    
    public String escribirMensaje(String mensaje){
        String respuesta="<!ini_respuesta:\"MENSAJE_USUARIO\">\n";
        respuesta = respuesta + "{\"DESCRIPCION\":[\n";
        respuesta = respuesta + "{\n \"MENSAJE\": \""+mensaje+"\"\n}";
        respuesta = respuesta + "\n]}\n";
        respuesta = respuesta + "<fin_respuesta!>\n";
        
        return respuesta;
    }
    
    public String escribirMensajes(List<String> mensajes){
        String respuesta="<!ini_respuestas>\n";
        
        if(!mensajes.isEmpty()){
            respuesta = respuesta + "<!ini_respuesta:\"MENSAJE_USUARIO\">\n";
            respuesta = respuesta + "{\"DESCRIPCION\":[\n";
            
            for (int i = 0; i < mensajes.size(); i++) {
                respuesta = respuesta + "{\n \"MENSAJE\": \""+mensajes.get(i)+"\"}";
                if(!(i == (mensajes.size()-1))){
                    respuesta = respuesta +",\n";
                }
            }
            respuesta = respuesta + "\n]}\n";
            respuesta = respuesta + "<fin_respuesta!>\n";
        }
        
        respuesta = respuesta + "<!fin_respuestas>\n";    
        return respuesta;
    }
}
