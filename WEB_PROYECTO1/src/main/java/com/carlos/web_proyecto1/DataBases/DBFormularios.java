package com.carlos.web_proyecto1.DataBases;

import com.carlos.web_proyecto1.Objetos.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBFormularios {

    private List<Formulario> formularios;

    public DBFormularios() {

    }

    public DBFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
    }

    public List<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
    }

    public Formulario buscarFormulario(String formId) {
        try {
            for (Formulario forms : this.formularios) {
            if (forms.getId().equals(formId)) {
                return forms;
            }
        }
        } catch (Exception e) {
        }
        return null;
    }

    public String agregarFormulario(formulariotmp form) {
        String respuesta = "";
        if (this.formularios == null) {
            this.formularios = new ArrayList<>();
        }
        Formulario tmp = buscarFormulario(form.getId());
        if (tmp == null) {
            tmp = new Formulario(form);
            if (tmp.getFecha() == null || tmp.getFecha().isEmpty()) {
                SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy-MM-dd");
                tmp.setFecha(getYearFormat.format(new Date()));
            }
            this.formularios.add(tmp);
            respuesta = "El formulario con el id " + form.getId() + " se agrego con exito";

        } else {
            respuesta = "El formulario con el id " + form.getId() + " ya existe";
        }
        return respuesta;
    }

    public String modificarFormulario(formulariotmp form) {
        String respuesta = "";

        Formulario tmp = this.buscarFormulario(form.getId());

        if (tmp == null) {
            respuesta = "El formulario a modificar con id " + form.getId() + " no existe";
        } else {
            if (!(form.getNombre() == null || form.getNombre().isEmpty())) {
                tmp.setNombre(form.getNombre());
            }
            if (!(form.getTitulo() == null || form.getTitulo().isEmpty())) {
                tmp.setTitulo(form.getTitulo());
            }
            if (!(form.getTema() == null || form.getTema().isEmpty())) {
                tmp.setTema(form.getTema());
            }
            respuesta = "El formulario con id " + form.getId() + " se modifico exitosamente";
        }
        return respuesta;
    }

    public String eliminarFormulario(formulariotmp form) {
        String respuesta = "";
        boolean bandera = false;

        for (int i = 0; i < formularios.size(); i++) {
            if (formularios.get(i).getId().equals(form.getId())) {
                formularios.remove(i);
                bandera = true;
                break;
            }
        }
        if (bandera) {
            respuesta = "Se elimino con exito el formulario con id " + form.getId();
        } else {
            respuesta = "No existe un formulario con id " + form.getId();
        }
        return respuesta;
    }

    public Componente buscarComponente(String formId, String compId) {

        Formulario form = this.buscarFormulario(formId);

        if (form != null) {
            for (Componente comp : form.getComponentes()) {
                if (comp.getId().equals(compId)) {
                    return comp;
                }
            }
        }

        return null;
    }

    public Componente buscarComponeteNombre(String idFormulario, String nombreComponente) {
        Formulario form = this.buscarFormulario(idFormulario);

        if (form != null) {
            for (Componente comp : form.getComponentes()) {
                if (comp.getNombre_campo().equals(nombreComponente)) {
                    return comp;
                }
            }
        }
        return null;
    }

    public String agregarComponente(componentetmp comp) {
        String respuesta = "";

        Formulario form = buscarFormulario(comp.getForm());

        if (form == null) {
            respuesta = "No existe un formulario con id " + comp.getForm() + " para agregar el componente";
        } else {

            if (form.getComponentes() == null || form.getComponentes().isEmpty()) {
                form.setComponentes(new ArrayList<Componente>());
            }

            if (this.buscarComponente(comp.getForm(), comp.getId()) == null) {

                if (this.buscarComponeteNombre(comp.getForm(), comp.getNombre()) == null) {
                    Componente newComp = new Componente(comp);
                    newComp.setIndice(String.valueOf((form.getComponentes().size()) + 1));

                    form.getComponentes().add(newComp);
                    respuesta = "El componente " + comp.getId() + " se agrego con exito al formulario " + form.getId();
                }else{
                    respuesta = "Ya existe un componente con el nombre: " + comp.getNombre()+ " ,en el formulario con id " + form.getId()+", la existenacia de nombres iguales daria el error de no recuperar la informacion correctamente";
                }

            } else {
                respuesta = "Ya existe un componente con id " + comp.getId() + " en el formulario con id " + form.getId();
            }
        }

        return respuesta;
    }

    public String eliminarComponente(componentetmp comp) {
        String respuesta = "";
        boolean bandera = false;

        Formulario form = buscarFormulario(comp.getForm());

        if (form == null) {
            respuesta = "No existe un formulario con id " + comp.getForm();
        } else {
            for (int i = 0; i < form.getComponentes().size(); i++) {
                if (form.getComponentes().get(i).getId().equals(comp.getId())) {
                    form.getComponentes().remove(i);
                    bandera = true;
                    break;
                }
            }

            if (bandera) {
                respuesta = "Se elimino con exito el componente con id " + comp.getId() + " del formulario con id " + comp.getForm();
            } else {
                respuesta = "No existe un componente con id " + comp.getId() + " en el formulario con id " + comp.getForm();
            }
        }

        return respuesta;
    }

    public String modificarComponente(componentetmp comp) {
        String respuesta = "";

        Componente mod = this.buscarComponente(comp.getForm(), comp.getId());

        if (mod == null) {
            respuesta = "No existe en un componente con id " + comp.getId() + " en el formulario " + comp.getForm();
        } else {

            comp.merge(mod);
            String resMod = comp.validarModComponete();

            if (resMod.isEmpty()) {
                mod.modificarComponete(comp);
                respuesta = "El componente con id " + comp.getId() + " del formulario id " + comp.getForm() + " se modifico exitosamente";
            } else {
                respuesta = "El componente con id " + comp.getId() + " del formulario id " + comp.getForm() + " no se puede modificar por los siguientes problemas\n" + resMod;
            }
        }
        return respuesta;
    }

}
