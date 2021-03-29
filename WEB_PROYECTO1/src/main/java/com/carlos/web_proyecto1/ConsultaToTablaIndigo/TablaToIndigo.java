package com.carlos.web_proyecto1.ConsultaToTablaIndigo;

import com.carlos.web_proyecto1.DataBases.DBFormularios;
import com.carlos.web_proyecto1.GuardadoInfo.Respuesta;
import com.carlos.web_proyecto1.GuardadoInfo.RespuestaFormulario;
import com.carlos.web_proyecto1.Objetos.Componente;
import com.carlos.web_proyecto1.Objetos.Formulario;
import com.carlos.web_proyecto1.Objetos.PaqueteConsultas;
import java.util.ArrayList;
import java.util.List;

public class TablaToIndigo {

    private DBFormularios baseForms;

    public TablaToIndigo(DBFormularios froms) {
        this.baseForms = froms;
    }

    public String convertir(List<PaqueteConsultas> paqConsultas) {
        String code = "<!ini_respuestas>\n";

        String tmpCode = "";
        String tmpCode2 = "";

        for (PaqueteConsultas paqConsulta : paqConsultas) {

            tmpCode = "<!ini_respuesta: \"" + paqConsulta.getNombreConsulta() + "\">\n";

            tmpCode = tmpCode + "{ \"TABLA_CONSULTA\" :[\n";

            if (paqConsulta.getResultado() == null) {
                if (paqConsulta.getCamposProyectar() == null) {
                    tmpCode = tmpCode + this.obtenerHeader(this.obtenerHeaderForm(((paqConsulta.getIdForm() == null) ? paqConsulta.getNombre() : paqConsulta.getIdForm())));
                } else {
                    if (paqConsulta.getCamposProyectar().isEmpty()) {
                        tmpCode = tmpCode + this.obtenerHeader(this.obtenerHeaderForm(((paqConsulta.getIdForm() == null) ? paqConsulta.getNombre() : paqConsulta.getIdForm())));
                    } else {
                        tmpCode = tmpCode + this.obtenerHeader(paqConsulta.getCamposProyectar());
                    }
                }
                tmpCode = tmpCode + "\n";
            } else {
                if (paqConsulta.getResultado().isEmpty()) {
                    if (paqConsulta.getCamposProyectar() == null) {
                        tmpCode = tmpCode + this.obtenerHeader(this.obtenerHeaderForm(((paqConsulta.getIdForm() == null) ? paqConsulta.getNombre() : paqConsulta.getIdForm())));
                    } else {
                        if (paqConsulta.getCamposProyectar().isEmpty()) {
                            tmpCode = tmpCode + this.obtenerHeader(this.obtenerHeaderForm(((paqConsulta.getIdForm() == null) ? paqConsulta.getNombre() : paqConsulta.getIdForm())));
                        } else {
                            tmpCode = tmpCode + this.obtenerHeader(paqConsulta.getCamposProyectar());
                        }
                    }
                    tmpCode = tmpCode + "\n";
                } else {

                    if (paqConsulta.getCamposProyectar() == null) {
                        tmpCode = tmpCode + this.obtenerHeader(this.obtenerHeaderForm(((paqConsulta.getIdForm() == null) ? paqConsulta.getNombre() : paqConsulta.getIdForm())));
                    } else {
                        if (paqConsulta.getCamposProyectar().isEmpty()) {
                            tmpCode = tmpCode + this.obtenerHeader(this.obtenerHeaderForm(((paqConsulta.getIdForm() == null) ? paqConsulta.getNombre() : paqConsulta.getIdForm())));
                        } else {
                            tmpCode = tmpCode + this.obtenerHeader(paqConsulta.getCamposProyectar());
                        }
                    }
                    tmpCode = tmpCode + ",\n";

                    for (int i = 0; i < paqConsulta.getResultado().size(); i++) {
                        
                        
                        if(paqConsulta.getCamposProyectar()==null){
                            tmpCode = tmpCode + this.obtenerParametros(this.obtenerHeaderForm(((paqConsulta.getIdForm() == null) ? paqConsulta.getNombre() : paqConsulta.getIdForm())), paqConsulta.getResultado().get(i));
                        }else{
                            if(paqConsulta.getCamposProyectar().isEmpty()){
                                tmpCode = tmpCode + this.obtenerParametros(this.obtenerHeaderForm(((paqConsulta.getIdForm() == null) ? paqConsulta.getNombre() : paqConsulta.getIdForm())), paqConsulta.getResultado().get(i));
                            }else{
                                tmpCode = tmpCode + this.obtenerParametros(paqConsulta.getCamposProyectar(), paqConsulta.getResultado().get(i));
                            }
                        }
                        
                        if (i == (paqConsulta.getResultado().size() - 1)) {
                            tmpCode = tmpCode + "\n";
                        } else {
                            tmpCode = tmpCode + ",\n";
                        }
                    }
                }
            }

            tmpCode = tmpCode + "]}\n";
            tmpCode = tmpCode + "<fin_respuesta!>\n";
            code = code + tmpCode;
            tmpCode = "";
        }

        code = code + "<!fin_respuestas>";

        return code;
    }

    private String obtenerParametros(List<String> camposProyectar, RespuestaFormulario resultado) {
        String tmp = null;
        String code = "{\n";

        for (int i = 0; i < camposProyectar.size(); i++) {
            tmp = camposProyectar.get(i);

            code = code + "\"COLUMNAS\": \"" + this.obtenerRespuesta(resultado.getRespuestas(), tmp) + "\"";
            if (i == (camposProyectar.size() - 1)) {
                code = code + "\n";
            } else {
                code = code + ",\n";
            }
        }
        code = code + "}";
        return code;
    }

    private String obtenerRespuesta(List<Respuesta> respuestas, String campo) {

        for (Respuesta respuesta : respuestas) {
            if (respuesta.getNombre_campo().equals(campo)) {
                return respuesta.getRespuesta();
            }
        }

        return "null";
    }

    private String obtenerHeader(List<String> camposProyectar) {
        String code = "{\n";

        for (int i = 0; i < camposProyectar.size(); i++) {
            code = code + "\"COLUMNAS\": \"" + camposProyectar.get(i) + "\"";
            if (i == (camposProyectar.size() - 1)) {
                code = code + "\n";
            } else {
                code = code + ",\n";
            }
        }
        code = code + "}";
        return code;
    }

    private List<String> obtenerHeaderForm(String id) {
        List<String> campos = new ArrayList<>();
        Formulario form = this.baseForms.buscarFormulario(id);
        for (Componente componente : form.getComponentes()) {
            switch (componente.getClase()) {
                case "CAMPO_TEXTO":
                    campos.add(componente.getNombre_campo());
                    break;
                case "AREA_TEXTO":
                    campos.add(componente.getNombre_campo());
                    break;
                case "CHECKBOX":
                    campos.add(componente.getNombre_campo());
                    break;
                case "RADIO":
                    campos.add(componente.getNombre_campo());
                    break;
                case "FICHERO":
                    campos.add(componente.getNombre_campo());
                    break;
                case "COMBO":
                    campos.add(componente.getNombre_campo());
                    break;
            }
        }
        return campos;
    }
}
