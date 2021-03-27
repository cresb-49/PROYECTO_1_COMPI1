package com.carlos.web_proyecto1.Acciones.FormularioToJson;

import com.carlos.web_proyecto1.Objetos.Componente;
import com.carlos.web_proyecto1.Objetos.Formulario;

public class FormToJson {
    
    public FormToJson() {
    }
    
    public String toJsonString(Formulario form) {
        String code = null;
        
        code = "new.formulario({\n"
                + "\"ID_FORMULARIO\": \"" + form.getId() + "\" ,\n"
                + "\"TITULO\": \"" + form.getTitulo() + "\" ,\n"
                + "\"NOMBRE\": \"" + form.getNombre() + "\" ,\n"
                + "\"TEMA\": \"" + form.getTema() + "\" ,\n"
                + "\"ESTRUCTURA\":(";
        Componente tmp = null;
        for (int i = 0; i < form.getComponentes().size(); i++) {
            tmp = form.getComponentes().get(i);
            
            
            
            
        }
        code = code + ")\n"
                + "})";
        
        return code;
    }
}
