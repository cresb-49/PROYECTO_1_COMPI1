/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.app_cliente_proyecto1.Objetos;

import java.util.List;

public class Componente {

    private String id;
    private String nombre_campo;
    private String formulario;
    private String clase;
    private String indice;
    private String texto_visible;
    private String alineacion;
    private String requerido;
    private String opciones;
    private String filas;
    private String columnas;
    private String url;

    public Componente(componentetmp base) {
        this.id = base.getId();
        this.nombre_campo = base.getNombre();
        this.formulario = base.getForm();
        this.clase = base.getClase();
        this.indice = base.getIndice();
        this.texto_visible = base.getTexto();
        this.alineacion = base.getAli();
        this.requerido = base.getRequerido();
        this.opciones = base.getOpciones();
        this.filas = base.getFilas();
        this.columnas = base.getColumnas();
        this.url = base.getUrl();
    }

    public Componente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre_campo() {
        return nombre_campo;
    }

    public void setNombre_campo(String nombre_campo) {
        this.nombre_campo = nombre_campo;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getTexto_visible() {
        return texto_visible;
    }

    public void setTexto_visible(String texto_visible) {
        this.texto_visible = texto_visible;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public String getRequerido() {
        return requerido;
    }

    public void setRequerido(String requerido) {
        this.requerido = requerido;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }

    public String getFilas() {
        return filas;
    }

    public void setFilas(String filas) {
        this.filas = filas;
    }

    public String getColumnas() {
        return columnas;
    }

    public void setColumnas(String columnas) {
        this.columnas = columnas;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void modificarComponete(componentetmp comp) {
        if (!(comp.getNombre() == null || comp.getNombre().isEmpty())) {
            this.nombre_campo = comp.getNombre();
        }
        if (!(comp.getClase() == null || comp.getClase().isEmpty())) {
            this.clase = comp.getClase();
        }
        if (!(comp.getIndice() == null || comp.getIndice().isEmpty())) {
            this.indice = comp.getIndice();
        }
        if (!(comp.getTexto() == null || comp.getTexto().isEmpty())) {
            this.texto_visible = comp.getTexto();
        }
        if (!(comp.getAli() == null || comp.getAli().isEmpty())) {
            this.alineacion = comp.getAli();
        }
        if (!(comp.getRequerido() == null || comp.getRequerido().isEmpty())) {
            this.requerido = comp.getRequerido();
        }
        if (!(comp.getOpciones() == null || comp.getOpciones().isEmpty())) {
            this.opciones = comp.getOpciones();
        }
        if (!(comp.getFilas() == null || comp.getFilas().isEmpty())) {
            this.filas = comp.getFilas();
        }
        if (!(comp.getColumnas() == null || comp.getColumnas().isEmpty())) {
            this.columnas = comp.getColumnas();
        }
        if (!(comp.getUrl() == null || comp.getUrl().isEmpty())) {
            this.url = comp.getUrl();
        }
    }

    public String validarComponete() {
        String res = "";
        if (this.id == null) {
            res = res + "El componente no tiene id definido\n";
        }
        if (this.texto_visible == null) {
            res = res + "El componente no tiene texto visible asignado\n";
        }
        if (this.clase != null) {
            switch (this.clase) {
                case "CAMPO_TEXTO":
                    if (this.nombre_campo == null) {
                        res = res + "- El componente no tiene un nombre asignado\n";
                    }
                    if (this.url != null) {
                        res = res + "- Este componente no debe tener una URL asignada\n";
                    }
                    if (this.filas != null) {
                        res = res + "- Este componente no necesita filas\n";
                    }
                    if (this.columnas != null) {
                        res = res + "- Esto componente no necesita columnas\n";
                    }
                    if (this.opciones != null) {
                        res = res + "- El componente no debe disponer de opciones\n";
                    }
                    break;
                case "AREA_TEXTO":
                    if (this.nombre_campo == null) {
                        res = res + "- El componente no tiene un nombre asignado\n";
                    }
                    if (this.filas == null) {
                        res = res + "- El area de texto necesita la cantidad de filas\n";
                    }
                    if (this.columnas == null) {
                        res = res + "- El area de texto necesita la cantidad de columnas\n";
                    }
                    if (this.url != null) {
                        res = res + "- Este componente no debe tener una URL asignada\n";
                    }
                    if (this.opciones != null) {
                        res = res + "- El componente no debe disponer de opciones\n";
                    }
                    break;
                case "CHECKBOX":
                    if (this.nombre_campo == null) {
                        res = res + "- El componente no tiene un nombre asignado\n";
                    }
                    if (this.opciones == null) {
                        res = res + "- El componente no tiene opciones para elegir\n";
                    }
                    if (this.url != null) {
                        res = res + "- Este componente no debe tener una URL asignada\n";
                    }
                    if (this.filas != null) {
                        res = res + "- Este componente no necesita filas\n";
                    }
                    if (this.columnas != null) {
                        res = res + "- Esto componente no necesita columnas\n";
                    }
                    break;
                case "RADIO":
                    if (this.nombre_campo == null) {
                        res = res + "- El componente no tiene un nombre asignado\n";
                    }
                    if (this.opciones == null) {
                        res = res + "- El componente no tiene opciones para elegir\n";
                    }
                    if (this.url != null) {
                        res = res + "- Este componente no debe tener una URL asignada\n";
                    }
                    if (this.filas != null) {
                        res = res + "- Este componente no necesita filas\n";
                    }
                    if (this.columnas != null) {
                        res = res + "- Esto componente no necesita columnas\n";
                    }
                    break;
                case "FICHERO":
                    if (this.nombre_campo == null) {
                        res = res + "- El componente no tiene un nombre asignado\n";
                    }
                    if (this.url != null) {
                        res = res + "- Este componente no debe tener una URL asignada\n";
                    }
                    if (this.filas != null) {
                        res = res + "- Este componente no necesita filas\n";
                    }
                    if (this.columnas != null) {
                        res = res + "- Esto componente no necesita columnas\n";
                    }
                    if (this.opciones != null) {
                        res = res + "- El componente no debe disponer de opciones\n";
                    }
                    break;
                case "IMAGEN":
                    if (this.url == null) {
                        res = res + "- El componente no tiene un url asignada\n";
                    }
                    if (this.filas != null) {
                        res = res + "- Este componente no necesita filas\n";
                    }
                    if (this.columnas != null) {
                        res = res + "- Esto componente no necesita columnas\n";
                    }
                    if (this.opciones != null) {
                        res = res + "- El componente no debe disponer de opciones\n";
                    }
                    break;
                case "COMBO":
                    if (this.nombre_campo == null) {
                        res = res + "- El componente no tiene un nombre asignado\n";
                    }
                    if (this.opciones == null) {
                        res = res + "- El componente no tiene opciones para elegir\n";
                    }
                    if (this.url != null) {
                        res = res + "- Este componente no debe tener una URL asignada\n";
                    }
                    if (this.filas != null) {
                        res = res + "- Este componente no necesita filas\n";
                    }
                    if (this.columnas != null) {
                        res = res + "- Esto componente no necesita columnas\n";
                    }
                    break;
                case "BOTON":
                    if (this.nombre_campo != null) {
                        res = res + "- El componente no debe de tener un nombre asignado\n";
                    }
                    if (this.url != null) {
                        res = res + "- Este componente no debe tener una URL asignada\n";
                    }
                    if (this.filas != null) {
                        res = res + "- Este componente no necesita filas\n";
                    }
                    if (this.columnas != null) {
                        res = res + "- Esto componente no necesita columnas\n";
                    }
                    if (this.opciones != null) {
                        res = res + "- El componente no debe disponer de opciones\n";
                    }
                    break;
                default:
                    if (this.clase == null) {
                        res = res + "- El componente no tiene una clase correcta definida\n";
                    }
            }
        } else {
            res = res + "El componente no tiene una clase definida\n";
        }

        return res;
    }

    @Override
    public String toString() {
        return "Componente{" + "id=" + id + ", nombre_campo=" + nombre_campo + ", formulario=" + formulario + ", clase=" + clase + ", indice=" + indice + ", texto_visible=" + texto_visible + ", alineacion=" + alineacion + ", requerido=" + requerido + ", opciones=" + opciones + ", filas=" + filas + ", columnas=" + columnas + ", url=" + url + '}';
    }
}
