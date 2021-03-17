package com.carlos.web_proyecto1.DataBases;

import com.carlos.web_proyecto1.Objetos.Formulario;
import com.carlos.web_proyecto1.Objetos.formulario;
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
    
    public Formulario buscarFormulario(formulario form){
        for(Formulario forms:this.formularios){
            if(forms.getId().equals(form.getId())){
                return forms;
            }
        }
        return null;
    }
    
    public String agregarFormulario(formulario form){
        String respuesta ="";
        if(this.formularios==null){
            this.formularios = new ArrayList<>();
        }
        Formulario tmp = buscarFormulario(form);
        if(tmp==null){
            tmp = new Formulario(form);
            if(tmp.getFecha()==null||tmp.getFecha().isEmpty()){
                SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy-MM-dd");
                tmp.setFecha(getYearFormat.format(new Date()));
            }
            this.formularios.add(tmp);
            respuesta = "El formulario con el id "+form.getId()+" se agrego con exito";
            
        }else{
            respuesta = "El formulario con el id "+form.getId()+" ya existe";
        }
        return respuesta;
    }
    
    public String modificarFormulario(formulario form){
        String respuesta = "";
        
        Formulario tmp = this.buscarFormulario(form);
        
        if(tmp==null){
            respuesta = "El formulario a modificar con id "+form.getId()+" no existe";
        }else{
            if(!(form.getNombre()==null||form.getNombre().isEmpty())){
                tmp.setNombre(form.getNombre());
            }
            if(!(form.getTitulo()==null||form.getTitulo().isEmpty())){
                tmp.setTitulo(form.getTitulo());
            }
            if(!(form.getTema()==null||form.getTema().isEmpty())){
                tmp.setTema(form.getTema());
            }
            respuesta = "El formulario con id "+form.getId()+" se modifico exitosamente";
        }
        return respuesta;
    }
    
    public String eliminarFormulario(formulario form){
        String respuesta = "";
        boolean bandera = false;
        
        for (int i = 0; i < formularios.size(); i++) {
            if(formularios.get(i).getId().equals(form.getId())){
                formularios.remove(i);
                bandera = true;
                break;
            }
        }
        if(bandera){
            respuesta = "Se elimino con exito el formulario con id "+form.getId();
        }else{
            respuesta = "No existe un formulario con id "+form.getId();
        }
        return respuesta;
    }
    
    
    
}
