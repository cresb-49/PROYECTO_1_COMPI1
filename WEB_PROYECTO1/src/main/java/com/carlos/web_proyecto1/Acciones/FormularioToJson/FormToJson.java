package com.carlos.web_proyecto1.Acciones.FormularioToJson;

import com.carlos.web_proyecto1.Objetos.Componente;
import com.carlos.web_proyecto1.Objetos.Formulario;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

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
                + "\"ESTRUCTURA\":(\n";
        Componente tmp = null;
        String tmpCode = null;
        try {
            for (int i = 0; i < form.getComponentes().size(); i++) {
                tmp = form.getComponentes().get(i);

                switch (tmp.getClase()) {
                    case "CAMPO_TEXTO":
                        tmpCode = this.campo_texto(tmp);
                        break;
                    case "AREA_TEXTO":
                        tmpCode = this.area_texto(tmp);
                        break;
                    case "CHECKBOX":
                        tmpCode = this.checkbox(tmp);
                        break;
                    case "RADIO":
                        tmpCode = this.radio(tmp);
                        break;
                    case "FICHERO":
                        tmpCode = this.fichero(tmp);
                        break;
                    case "IMAGEN":
                        tmpCode = this.imagen(tmp);
                        break;
                    case "COMBO":
                        tmpCode = this.combo(tmp);
                        break;
                    case "BOTON":
                        tmpCode = this.boton(tmp);
                        break;
                }
                code = code + "{\n" + tmpCode + "}";

                if (i == ((form.getComponentes().size()) - 1)) {
                    code = code + "\n";
                } else {
                    code = code + ",\n";
                }
            }
        } catch (Exception e) {
        }
        code = code + ")\n"
                + "})";

        return code;
    }

    private String campo_texto(Componente comp) {
        String code = "\"ID\": \"" + comp.getId() + "\",\n"
                + "\"NOMBRE_CAMPO\": \"" + comp.getNombre_campo() + "\",\n"
                + "\"CLASE\": \"" + comp.getClase() + "\",\n"
                + ((comp.getAlineacion() == null) ? "" : "\"ALINEACION\": \"" + comp.getAlineacion() + "\",\n")
                + ((comp.getRequerido() == null) ? "" : "\"REQUERIDO\": \"" + comp.getRequerido() + "\",\n")
                + "\"TEXTO_VISIBLE\": \"" + comp.getTexto_visible() + "\"\n";
        return code;
    }

    private String area_texto(Componente comp) {
        String code = "\"ID\": \"" + comp.getId() + "\",\n"
                + "\"NOMBRE_CAMPO\": \"" + comp.getNombre_campo() + "\",\n"
                + "\"CLASE\": \"" + comp.getClase() + "\",\n"
                + ((comp.getAlineacion() == null) ? "" : "\"ALINEACION\": \"" + comp.getAlineacion() + "\",\n")
                + ((comp.getRequerido() == null) ? "" : "\"REQUERIDO\": \"" + comp.getRequerido() + "\",\n")
                + "\"FILAS\": \"" + comp.getFilas() + "\",\n"
                + "\"COLUMNAS\": \"" + comp.getColumnas() + "\",\n"
                + "\"TEXTO_VISIBLE\": \"" + comp.getTexto_visible() + "\"\n";
        return code;
    }

    private String checkbox(Componente comp) {
        String code = "\"ID\": \"" + comp.getId() + "\",\n"
                + "\"NOMBRE_CAMPO\": \"" + comp.getNombre_campo() + "\",\n"
                + "\"CLASE\": \"" + comp.getClase() + "\",\n"
                + ((comp.getAlineacion() == null) ? "" : "\"ALINEACION\": \"" + comp.getAlineacion() + "\",\n")
                + ((comp.getRequerido() == null) ? "" : "\"REQUERIDO\": \"" + comp.getRequerido() + "\",\n")
                + "\"OPCIONES\": \"" + comp.getOpciones() + "\",\n"
                + "\"TEXTO_VISIBLE\": \"" + comp.getTexto_visible() + "\"\n";
        return code;
    }

    private String radio(Componente comp) {
        String code = "\"ID\": \"" + comp.getId() + "\",\n"
                + "\"NOMBRE_CAMPO\": \"" + comp.getNombre_campo() + "\",\n"
                + "\"CLASE\": \"" + comp.getClase() + "\",\n"
                + ((comp.getAlineacion() == null) ? "" : "\"ALINEACION\": \"" + comp.getAlineacion() + "\",\n")
                + ((comp.getRequerido() == null) ? "" : "\"REQUERIDO\": \"" + comp.getRequerido() + "\",\n")
                + "\"OPCIONES\": \"" + comp.getOpciones() + "\",\n"
                + "\"TEXTO_VISIBLE\": \"" + comp.getTexto_visible() + "\"\n";
        return code;
    }

    private String combo(Componente comp) {
        String code = "\"ID\": \"" + comp.getId() + "\",\n"
                + "\"NOMBRE_CAMPO\": \"" + comp.getNombre_campo() + "\",\n"
                + "\"CLASE\": \"" + comp.getClase() + "\",\n"
                + ((comp.getAlineacion() == null) ? "" : "\"ALINEACION\": \"" + comp.getAlineacion() + "\",\n")
                + ((comp.getRequerido() == null) ? "" : "\"REQUERIDO\": \"" + comp.getRequerido() + "\",\n")
                + "\"OPCIONES\": \"" + comp.getOpciones() + "\",\n"
                + "\"TEXTO_VISIBLE\": \"" + comp.getTexto_visible() + "\"\n";
        return code;
    }

    private String fichero(Componente comp) {
        String code = "\"ID\": \"" + comp.getId() + "\",\n"
                + "\"NOMBRE_CAMPO\": \"" + comp.getNombre_campo() + "\",\n"
                + "\"CLASE\": \"" + comp.getClase() + "\",\n"
                + ((comp.getAlineacion() == null) ? "" : "\"ALINEACION\": \"" + comp.getAlineacion() + "\",\n")
                + ((comp.getRequerido() == null) ? "" : "\"REQUERIDO\": \"" + comp.getRequerido() + "\",\n")
                + "\"TEXTO_VISIBLE\": \"" + comp.getTexto_visible() + "\"\n";
        return code;
    }

    private String imagen(Componente comp) {
        String code = "\"ID\": \"" + comp.getId() + "\",\n"
                + "\"CLASE\": \"" + comp.getClase() + "\",\n"
                + ((comp.getAlineacion() == null) ? "" : "\"ALINEACION\": \"" + comp.getAlineacion() + "\",\n")
                + ((comp.getRequerido() == null) ? "" : "\"REQUERIDO\": \"" + comp.getRequerido() + "\",\n")
                + "\"URL\": \"" + comp.getUrl() + "\",\n"
                + "\"TEXTO_VISIBLE\": \"" + comp.getTexto_visible() + "\"\n";
        return code;
    }

    private String boton(Componente comp) {
        String code = "\"ID\": \"" + comp.getId() + "\",\n"
                + "\"CLASE\": \"" + comp.getClase() + "\","
                + ((comp.getAlineacion() == null) ? "" : "\"ALINEACION\": \"" + comp.getAlineacion() + "\",")
                + ((comp.getRequerido() == null) ? "" : "\"REQUERIDO\": \"" + comp.getRequerido() + "\",")
                + "\"TEXTO_VISIBLE\": \"" + comp.getTexto_visible() + "\"";
        return code;
    }
}
