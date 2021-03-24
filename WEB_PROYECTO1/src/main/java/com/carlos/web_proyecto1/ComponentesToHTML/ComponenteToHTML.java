package com.carlos.web_proyecto1.ComponentesToHTML;

import java.util.List;
import com.carlos.web_proyecto1.Objetos.*;

public class ComponenteToHTML {

    public ComponenteToHTML() {
    }

    public String convertir(List<Componente> componentes) {
        String HTML = "";

        Componente[] array = new Componente[componentes.size()];
        
        if (!componentes.isEmpty()) {
            componentes.toArray(array);
            array = this.metodoBurbujaAsc(array);
            for (Componente componente : array) {
                HTML = HTML + this.eleccion(componente);
            }
        }
        
        return HTML;
    }

    private String eleccion(Componente comp) {
        switch (comp.getClase()) {
            case "CAMPO_TEXTO":
                return this.campo_texto(comp);
            case "AREA_TEXTO":
                return this.area_texto(comp);
            case "CHECKBOX":
                return this.checkbox(comp);
            case "RADIO":
                return this.radio(comp);
            case "FICHERO":
                return this.fichero(comp);
            case "IMAGEN":
                return this.imagen(comp);
            case "COMBO":
                return this.combo(comp);
            case "BOTON":
                return this.boton(comp);
        }
        return "\n";
    }

    private String campo_texto(Componente comp) {
        String html = "\n"
                + "<div>\n"
                + "<label for=\"" + comp.getId() + "\" >" + comp.getTexto_visible() + "</label>\n"
                + "<input type=\"text\" id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\"/>"
                + "</div>\n";
        return html;
    }

    private String area_texto(Componente comp) {
        String html = "\n"
                + "<div>\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<textarea id=\"" + comp.getId() + "\" rows=\"" + comp.getFilas() + "\" cols=\"" + comp.getColumnas() + "\" name=\"" + comp.getNombre_campo() + "\"></textarea>"
                + "</div>\n";
        return html;
    }

    private String checkbox(Componente comp) {
        String html = "\n"
                + "<div>\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<input type=\"checkbox\" id=\""+comp.getId()+"\" name=\""+comp.getNombre_campo()+"\" value=\""+comp.getOpciones()+"\"/>"+comp.getOpciones()+""
                + "</div>\n";
        return html;
    }

    private String radio(Componente comp) {
        String html = "\n"
                + "<div>\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<input type=\"radio\" id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\" value=\"" + comp.getOpciones() + "\"/>"+comp.getOpciones()+""
                + "</div>\n";
        return html;
    }

    private String combo(Componente comp) {
        String html = "\n"
                + "<div>\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<select id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\">\n"
                + "<option>" + comp.getOpciones() + "</option>\n"
                + "</select>"
                + "</div>\n";
        return html;
    }

    private String fichero(Componente comp) {
        String html = "\n"
                + "<div>\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<input type=\"file\" id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\"/>"
                + "</div>\n";
        return html;
    }

    private String imagen(Componente comp) {
        String html = "\n"
                + "<div>\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<input type=\"image\" id=\"" + comp.getId() + "\" src=\"" + comp.getUrl() + "\"/>"
                + "</div>\n";
        return html;
    }

    private String boton(Componente comp) {
        String html = "\n"
                + "<div>\n"
                + "<input type=\"submit\" value=\"" + comp.getTexto_visible() + "\"/>"
                + "</div>\n";
        return html;
    }

    private Componente[] metodoBurbujaAsc(Componente[] comp) {
        int i;
        boolean flag = true;
        Componente temp;

        while (flag) {
            flag = false;
            for (i = 0; i < comp.length - 1; i++) {
                if ((comp[i].getIndice().compareTo(comp[i + 1].getIndice())) > 0) {
                    temp = comp[i];
                    comp[i] = comp[i + 1];
                    comp[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return comp;
    }

}
