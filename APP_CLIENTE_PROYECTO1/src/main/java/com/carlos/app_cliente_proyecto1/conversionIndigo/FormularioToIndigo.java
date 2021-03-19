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
            code = code + "\"PARAMETROS_FORMULARIO\":[{";
            code = code + "\"ID\": \"" + formulario.getId() + "\",\n";
            code = code + "\"TITULO\": \"" + formulario.getTitulo() + "\",\n";
            code = code + "\"NOMBRE\": \"" + formulario.getNombre() + "\",\n";
            code = code + "\"TEMA\": \"" + formulario.getTema() + "\"\n";
            code = code + "}]\n";
            code = code + "}<fin_solicitud!>\n";

            for (Componente componente : formulario.getComponentes()) {

                code = code + "<!ini_solicitud:\"AGREGAR_COMPONENTE\">{\n";
                code = code + "\"PARAMETROS_COMPONENTE\":[{\n";

                code = code + "\"ID\": \"$_grupo_paises\",\n";
                code = code + "\"FORMULARIO\":\"$form2\",\n";
                code = code + "\"CLASE\":\"COMBO\",\n";
                code = code + "\"TEXTO_VISIBLE\":\"Pais de Origen: \"\n";

                switch (componente.getClase()) {
                    case "CAMPO_TEXTO":
                        code = code + ",";
                        code = code + "\"NOMBRE_CAMPO\": \"Pais\"";
                        break;
                    case "AREA_TEXTO":
                        code = code + ",";
                        code = code + "\"NOMBRE_CAMPO\": \"Pais\",";
                        code = code + "\"FILAS\":\"\",\n";
                        code = code + "\"COLUMNAS\":\"\"\n";
                        break;
                    case "CHECKBOX":
                        code = code + ",";
                        code = code + "\"NOMBRE_CAMPO\": \"Pais\",";
                        code = code + "\"OPCIONES\":\"Guatemala|El salvador|Honduras|otro\"\n";
                        break;
                    case "RADIO":
                        code = code + ",";
                        code = code + "\"NOMBRE_CAMPO\": \"Pais\",";
                        code = code + "\"OPCIONES\":\"Guatemala|El salvador|Honduras|otro\"\n";
                        break;
                    case "FICHERO":
                        /*do nothing*/
                        break;
                    case "IMAGEN":
                        code = code + ",\n";
                        code = code + "\"URL\": \"Pais\",\n";
                        break;
                    case "COMBO":
                        code = code + ",";
                        code = code + "\"NOMBRE_CAMPO\": \"Pais\",";
                        code = code + "\"OPCIONES\":\"Guatemala|El salvador|Honduras|otro\"\n";
                        break;
                    case "BOTON":
                        /*do nothing*/
                        break;
                }

                if (!(componente.getAlineacion() == null)) {
                    if (!(componente.getAlineacion().isEmpty())) {
                        code = code + ",";
                        code = code + "\"ALINEACION\":\"CENTRO\"";
                        if (!(componente.getRequerido() == null)) {
                            if (!(componente.getRequerido().isEmpty())) {
                                code = code + ",";
                                code = code + "\"REQUERIDO\":\"SI\"";
                            }
                        }
                    }
                } else {
                    if (!(componente.getRequerido() == null)) {
                        if (!(componente.getRequerido().isEmpty())) {
                            code = code + ",";
                            code = code + "\"REQUERIDO\":\"SI\"";
                        }
                    }
                }
                code = code + "}]\n";
                code = code + "}<fin_solicitud!>\n";
            }
        }

        code = code + "<!fin_solicitudes>\n";

        return code;
    }
}
