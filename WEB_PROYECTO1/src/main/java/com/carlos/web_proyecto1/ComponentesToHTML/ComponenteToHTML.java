package com.carlos.web_proyecto1.ComponentesToHTML;

import com.carlos.web_proyecto1.Lexer.lexerOpciones;
import java.util.List;
import com.carlos.web_proyecto1.Objetos.*;
import java.io.StringReader;
import java.util.ArrayList;

public class ComponenteToHTML {

    private lexerOpciones opciones = new lexerOpciones();
    private boolean botonEnviar = false;

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
        if (!botonEnviar) {
            HTML = HTML + ""
                    + "<div>\n"
                    + "<input type=\"submit\" value=\"enviar\" required />"
                    + "</div>\n";
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
                + "<input type=\"text\" id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\"" + ((comp.getRequerido() == null) ? "" : ((comp.getRequerido().equals("SI") ? "required" : ""))) + "/>"
                + "</div>\n";
        return html;
    }

    private String area_texto(Componente comp) {
        String html = "\n"
                + "<div>\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<textarea id=\"" + comp.getId() + "\" rows=\"" + comp.getFilas() + "\" cols=\"" + comp.getColumnas() + "\" name=\"" + comp.getNombre_campo() + "\"" + ((comp.getRequerido() == null) ? "" : ((comp.getRequerido().equals("SI") ? "required = \"\"" : ""))) + "style=\" width: 990px; height: 539px;\"></textarea>"
                + "</div>\n";
        return html;
    }

    private String checkbox(Componente comp) {
        opciones.yyreset(new StringReader(comp.getOpciones()));
        List<String> ops = new ArrayList<>();
        try {
            opciones.yylex();
            ops = opciones.getOpciones();
        } catch (Exception e) {
            System.out.println("Error de recuperacion de opciones");
            e.printStackTrace();
        }

        String html = "\n"
                + "<div>\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n";
        for (String op : ops) {
            html = html + "<input type=\"checkbox\" id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\" value=\"" + op + "\"" + ((comp.getRequerido() == null) ? "" : ((comp.getRequerido().equals("SI") ? "required" : ""))) + "/>" + op + "\n";
        }
        opciones.reinicioLex();
        html = html + "</div>\n";
        return html;
    }

    private String radio(Componente comp) {

        opciones.yyreset(new StringReader(comp.getOpciones()));
        List<String> ops = new ArrayList<>();
        try {
            opciones.yylex();
            ops = opciones.getOpciones();
        } catch (Exception e) {
            System.out.println("Error de recuperacion de opciones");
            e.printStackTrace();
        }

        String html = "\n"
                + "<div>\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n";
        for (String op : ops) {
            html = html + "<input type=\"radio\" id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\" value=\"" + op + "\"" + ((comp.getRequerido() == null) ? "" : ((comp.getRequerido().equals("SI") ? "required" : ""))) + "/>" + op + "\n";
        }
        opciones.reinicioLex();
        html = html + "</div>\n";
        return html;
    }

    private String combo(Componente comp) {
        opciones.yyreset(new StringReader(comp.getOpciones()));
        List<String> ops = new ArrayList<>();
        try {
            opciones.yylex();
            ops = opciones.getOpciones();
        } catch (Exception e) {
            System.out.println("Error de recuperacion de opciones");
            e.printStackTrace();
        }
        String html = "\n"
                + "<div>\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<select id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\"" + ((comp.getRequerido() == null) ? "" : ((comp.getRequerido().equals("SI") ? "required" : ""))) + ">\n";
        for (String op : ops) {
            html = html + "<option>" + op + "</option>\n";
        }
        opciones.reinicioLex();
        html = html + "</select>"
                + "</div>\n";
        return html;
    }

    private String fichero(Componente comp) {
        String html = "\n"
                + "<div>\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<input type=\"file\" id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\"" + ((comp.getRequerido() == null) ? "" : ((comp.getRequerido().equals("SI") ? "required" : ""))) + "/>"
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
                + "<input type=\"submit\" value=\"" + comp.getTexto_visible() + "\"" + ((comp.getRequerido() == null) ? "" : ((comp.getRequerido().equals("SI") ? "required" : ""))) + "/>"
                + "</div>\n";
        botonEnviar = true;
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
