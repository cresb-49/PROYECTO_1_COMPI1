package com.carlos.web_proyecto1.Acciones;

import com.carlos.web_proyecto1.EDD.Cola;
import com.carlos.web_proyecto1.GuardadoInfo.Respuesta;
import com.carlos.web_proyecto1.GuardadoInfo.RespuestaFormulario;
import com.carlos.web_proyecto1.Objetos.Operacion;
import java.util.ArrayList;
import java.util.List;

public class ProcesarConsulta {

    private List<RespuestaFormulario> respuestasForms;
    private Cola operaciones;

    public ProcesarConsulta(List<RespuestaFormulario> respuestas, Cola operaciones) {
        this.respuestasForms = respuestas;
        this.operaciones = operaciones;
    }

    public ProcesarConsulta() {

    }

    public List<RespuestaFormulario> procesar() {
        List<RespuestaFormulario> respuesta = new ArrayList<>();
        Operacion tmp = null;
        String unionLogica = null;
        for (RespuestaFormulario respuestasForm : this.respuestasForms) {
            respuesta.add(respuestasForm);
        }

        while (!operaciones.isEmpty()) {
            tmp = ((Operacion) operaciones.sacar());
            if (tmp.getTipoBusqueda().equals("NOMBRE")) {
                if (tmp.getNegacion().equals("SI")) {
                    if (unionLogica == null) {
                        respuesta = this.buscarResName_ContComponeteNegado(respuesta, tmp.getNameID(), tmp.getValorComparacion(), tmp.getOperadorLogico());
                    } else {
                        if (unionLogica.equals("AND")) {
                            respuesta = this.buscarResName_ContComponeteNegado(respuesta, tmp.getNameID(), tmp.getValorComparacion(), tmp.getOperadorLogico());
                        } else if (unionLogica.equals("OR")) {
                            respuesta = this.mergeResultado(respuesta,this.buscarResName_ContComponeteNegado(this.respuestasForms, tmp.getNameID(), tmp.getValorComparacion(), tmp.getOperadorLogico()));
                        }
                    }

                } else {
                    if (unionLogica == null) {
                        respuesta = this.buscarResName_ContComponete(respuesta, tmp.getNameID(), tmp.getValorComparacion(), tmp.getOperadorLogico());
                    } else {
                        if (unionLogica.equals("AND")) {
                            respuesta = this.buscarResName_ContComponete(respuesta, tmp.getNameID(), tmp.getValorComparacion(), tmp.getOperadorLogico());
                        } else if (unionLogica.equals("OR")) {
                            respuesta = this.mergeResultado(respuesta,this.buscarResName_ContComponete(this.respuestasForms, tmp.getNameID(), tmp.getValorComparacion(), tmp.getOperadorLogico()));
                        }
                    }

                }
            } else if (tmp.getTipoBusqueda().equals("ID")) {
                if (tmp.getNegacion().equals("SI")) {
                    if (unionLogica == null) {
                        respuesta = this.buscarResID_ContComponeteNegado(respuesta, tmp.getNameID(), tmp.getValorComparacion(), tmp.getOperadorLogico());
                    } else {
                        if (unionLogica.equals("AND")) {
                            respuesta = this.buscarResID_ContComponeteNegado(respuesta, tmp.getNameID(), tmp.getValorComparacion(), tmp.getOperadorLogico());
                        } else if (unionLogica.equals("OR")) {
                            respuesta = this.mergeResultado(respuesta,this.buscarResID_ContComponeteNegado(this.respuestasForms, tmp.getNameID(), tmp.getValorComparacion(), tmp.getOperadorLogico()));
                        }
                    }

                } else {
                    if (unionLogica == null) {
                        respuesta = this.buscarResID_ContComponete(respuesta, tmp.getNameID(), tmp.getValorComparacion(), tmp.getOperadorLogico());
                    } else {
                        if (unionLogica.equals("AND")) {
                            respuesta = this.buscarResID_ContComponete(respuesta, tmp.getNameID(), tmp.getValorComparacion(), tmp.getOperadorLogico());
                        } else if (unionLogica.equals("OR")) {
                            respuesta = this.mergeResultado(respuesta,this.buscarResID_ContComponete(this.respuestasForms, tmp.getNameID(), tmp.getValorComparacion(), tmp.getOperadorLogico()));
                        }
                    }
                }
            }
            unionLogica = tmp.getLogica();
        }

        /*System.out.println("\n-Lista de respuestas formularios");
        for (RespuestaFormulario respuestasForm : respuesta) {
            System.out.println(respuestasForm);
        }*/

        return respuesta;
    }

    private List<RespuestaFormulario> buscarResID_ContComponete(List<RespuestaFormulario> respuestas, String id, String valor, String operadorRelacional) {
        List<RespuestaFormulario> respuesta = new ArrayList<>();
        int var = 0;

        switch (operadorRelacional) {
            case "=":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        if (respuesta2.getIdComponente().equals(id) && respuesta2.getRespuesta().equals(valor)) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case "<":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (respuesta2.getIdComponente().equals(id) && var == -1) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case ">":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (respuesta2.getIdComponente().equals(id) && var == 1) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case ">=":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (respuesta2.getIdComponente().equals(id) && (var == 1 || var == 0)) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case "<=":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (respuesta2.getIdComponente().equals(id) && (var == -1 || var == 0)) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case "<>":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (respuesta2.getIdComponente().equals(id) && (var == 1 || var == -1)) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
        }
        return respuesta;
    }

    private List<RespuestaFormulario> buscarResID_ContComponeteNegado(List<RespuestaFormulario> respuestas, String id, String valor, String operadorRelacional) {
        List<RespuestaFormulario> respuesta = new ArrayList<>();
        int var = 0;

        switch (operadorRelacional) {
            case "=":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        if (!(respuesta2.getIdComponente().equals(id) && respuesta2.getRespuesta().equals(valor))) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case "<":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (!(respuesta2.getIdComponente().equals(id) && var == -1)) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case ">":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (!(respuesta2.getIdComponente().equals(id) && var == 1)) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case ">=":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (!(respuesta2.getIdComponente().equals(id) && (var == 1 || var == 0))) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case "<=":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (!(respuesta2.getIdComponente().equals(id) && (var == -1 || var == 0))) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case "<>":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (!(respuesta2.getIdComponente().equals(id) && (var == 1 || var == -1))) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
        }
        return respuesta;
    }

    private List<RespuestaFormulario> buscarResName_ContComponete(List<RespuestaFormulario> respuestas, String nombre, String valor, String operadorRelacional) {
        List<RespuestaFormulario> respuesta = new ArrayList<>();
        int var = 0;
        switch (operadorRelacional) {
            case "=":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        if (respuesta2.getNombre_campo().equals(nombre) && respuesta2.getRespuesta().equals(valor)) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case "<":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (respuesta2.getNombre_campo().equals(nombre) && var == -1) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case ">":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (respuesta2.getNombre_campo().equals(nombre) && var == 1) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case ">=":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (respuesta2.getNombre_campo().equals(nombre) && (var == 1 || var == 0)) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case "<=":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (respuesta2.getNombre_campo().equals(nombre) && (var == -1 || var == 0)) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case "<>":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (respuesta2.getNombre_campo().equals(nombre) && (var == 1 || var == -1)) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
        }

        return respuesta;
    }

    private List<RespuestaFormulario> buscarResName_ContComponeteNegado(List<RespuestaFormulario> respuestas, String nombre, String valor, String operadorRelacional) {
        List<RespuestaFormulario> respuesta = new ArrayList<>();
        int var = 0;
        switch (operadorRelacional) {
            case "=":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        if (!(respuesta2.getNombre_campo().equals(nombre) && respuesta2.getRespuesta().equals(valor))) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case "<":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (!(respuesta2.getNombre_campo().equals(nombre) && var == -1)) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case ">":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (!(respuesta2.getNombre_campo().equals(nombre) && var == 1)) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case ">=":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (!(respuesta2.getNombre_campo().equals(nombre) && (var == 1 || var == 0))) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case "<=":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (!(respuesta2.getNombre_campo().equals(nombre) && (var == -1 || var == 0))) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
            case "<>":
                for (RespuestaFormulario respuesta1 : respuestas) {
                    for (Respuesta respuesta2 : respuesta1.getRespuestas()) {
                        var = valor.compareTo(respuesta2.getRespuesta());
                        if (!(respuesta2.getNombre_campo().equals(nombre) && (var == 1 || var == -1))) {
                            respuesta.add(respuesta1);
                            break;
                        }
                    }
                }
                break;
        }
        return respuesta;
    }

    private List<RespuestaFormulario> mergeResultado(List<RespuestaFormulario> res1, List<RespuestaFormulario> res2) {
        List<RespuestaFormulario> resultado = new ArrayList<>();

        for (RespuestaFormulario respuesta1 : res1) {
            resultado.add(respuesta1);
        }

        for (RespuestaFormulario respuesta2 : res2) {
            if (!resultado.contains(respuesta2)) {
                resultado.add(respuesta2);
            }
        }
        return resultado;
    }

}
