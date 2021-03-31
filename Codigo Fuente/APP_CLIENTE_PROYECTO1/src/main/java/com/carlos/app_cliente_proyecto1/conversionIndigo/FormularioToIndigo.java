package com.carlos.app_cliente_proyecto1.conversionIndigo;

import com.carlos.app_cliente_proyecto1.Objetos.*;
import java.util.List;

public class FormularioToIndigo {

    public FormularioToIndigo() {

    }

    public String convertir(List<Formulario> form) {
        String code = "";

        code = code + "<!ini_solicitudes>\n";

        for (Formulario formulario : form) {

            code = code + "<!ini_solicitud:\"NUEVO_FORMULARIO\">{\n";
            code = code + "\"PARAMETROS_FORMULARIO\":[{\n";
            code = code + "\"ID\": \"" + formulario.getId() + "\",\n";
            code = code + "\"TITULO\": \"" + formulario.getTitulo() + "\",\n";
            code = code + "\"NOMBRE\": \"" + formulario.getNombre() + "\",\n";
            code = code + "\"TEMA\": \"" + formulario.getTema() + "\"\n";
            code = code + "}]\n";
            code = code + "}<fin_solicitud!>\n";

            for (Componente componente : formulario.getComponentes()) {

                code = code + "<!ini_solicitud:\"AGREGAR_COMPONENTE\">{\n";
                code = code + "\"PARAMETROS_COMPONENTE\":[{\n";

                code = code + "\"ID\": \""+componente.getId()+"\",\n";
                code = code + "\"FORMULARIO\":\""+formulario.getId()+"\",\n";
                code = code + "\"CLASE\":\""+componente.getClase()+"\",\n";
                code = code + "\"TEXTO_VISIBLE\":\""+componente.getTexto_visible()+"\"";

                switch (componente.getClase()) {
                    case "CAMPO_TEXTO":
                        code = code + ",\n";
                        code = code + "\"NOMBRE_CAMPO\": \""+componente.getNombre_campo()+"\"";
                        break;
                    case "AREA_TEXTO":
                        code = code + ",\n";
                        code = code + "\"NOMBRE_CAMPO\": \""+componente.getNombre_campo()+"\",\n";
                        code = code + "\"FILAS\":\""+componente.getFilas()+"\",\n";
                        code = code + "\"COLUMNAS\":\""+componente.getColumnas()+"\"";
                        break;
                    case "CHECKBOX":
                        code = code + ",\n";
                        code = code + "\"NOMBRE_CAMPO\": \""+componente.getNombre_campo()+"\",\n";
                        code = code + "\"OPCIONES\":\""+componente.getOpciones()+"\"";
                        break;
                    case "RADIO":
                        code = code + ",\n";
                        code = code + "\"NOMBRE_CAMPO\": \""+componente.getNombre_campo()+"\",\n";
                        code = code + "\"OPCIONES\":\""+componente.getOpciones()+"\"";
                        break;
                    case "FICHERO":
                        /*do nothing*/
                        break;
                    case "IMAGEN":
                        code = code + ",\n";
                        code = code + "\"URL\": \""+componente.getUrl()+"\"\n";
                        break;
                    case "COMBO":
                        code = code + ",\n";
                        code = code + "\"NOMBRE_CAMPO\": \""+componente.getNombre_campo()+"\",\n";
                        code = code + "\"OPCIONES\":\""+componente.getOpciones()+"\"";
                        break;
                    case "BOTON":
                        /*do nothing*/
                        break;
                }

                if (!(componente.getAlineacion() == null)) {
                    if (!(componente.getAlineacion().isEmpty())) {
                        code = code + ",\n";
                        code = code + "\"ALINEACION\":\""+componente.getAlineacion()+"\"";
                        if (!(componente.getRequerido() == null)) {
                            if (!(componente.getRequerido().isEmpty())) {
                                code = code + ",\n";
                                code = code + "\"REQUERIDO\":\""+componente.getRequerido()+"\"";
                            }
                        }
                    }
                } else {
                    if (!(componente.getRequerido() == null)) {
                        if (!(componente.getRequerido().isEmpty())) {
                            code = code + ",\n";
                            code = code + "\"REQUERIDO\":\""+componente.getRequerido()+"\"";
                        }
                    }
                }
                code = code + "\n}]\n";
                code = code + "}<fin_solicitud!>\n";
            }
        }

        code = code + "<!fin_solicitudes>\n";

        return code;
    }
}
