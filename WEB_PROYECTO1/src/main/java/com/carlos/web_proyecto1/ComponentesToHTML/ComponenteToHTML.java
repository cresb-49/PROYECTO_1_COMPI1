package com.carlos.web_proyecto1.ComponentesToHTML;

import java.util.List;
import com.carlos.web_proyecto1.Objetos.*;

public class ComponenteToHTML {

    public ComponenteToHTML() {
    }

    public String convertir(List<Componente> componentes) {
        String HTML = "";
        
        Componente[] array = new Componente[componentes.size()];
        componentes.toArray(array);
        
        array = this.metodoBurbujaAsc(array);
        
        for (Componente componente : array) {
            System.out.println("Indice: "+componente.getIndice());
        }
        return HTML;
    }

    private String campo_texto(Componente comp) {
        String html = "\n"
                + "<label for=\"" + comp.getId() + "\" >" + comp.getTexto_visible() + "</label>\n"
                + "<input type=\"text\" id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\"/>";
        return html;
    }

    private String area_texto(Componente comp) {
        String html = "\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<textarea id=\"" + comp.getId() + "\" rows=\"" + comp.getFilas() + "\" cols=\"" + comp.getColumnas() + "\" name=\"" + comp.getNombre_campo() + "\"></textarea>";
        return html;
    }

    private String checkbox(Componente comp) {
        String html = "\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<input type=\"checkbox\" id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\" value=\"" + comp.getOpciones() + "\"/>";
        return html;
    }

    private String radio(Componente comp) {
        String html = "\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<input type=\"checkbox\" id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\" value=\"" + comp.getOpciones() + "\"/>";
        return html;
    }

    private String combo(Componente comp) {
        String html = "\n"
                + "<label for=\"" + comp.getId() + "\">" + comp.getTexto_visible() + "</label>\n"
                + "<select id=\"" + comp.getId() + "\" name=\"" + comp.getNombre_campo() + "\">\n"
                + "<option>" + comp.getOpciones() + "</option>\n"
                + "</select>";
        return html;
    }

    private String fichero(Componente comp) {
        String html = "\n"
                + "<label for=\""+comp.getId()+"\">"+comp.getTexto_visible()+"</label>\n"
                + "<input type=\"file\" id=\""+comp.getId()+"\" name=\""+comp.getNombre_campo()+"\"/>";
        return html;
    }

    private String imagen(Componente comp) {
        String html = "\n"
                + "<label for=\""+comp.getId()+"\">"+comp.getTexto_visible()+"</label>\n"
                + "<input type=\"image\" id=\""+comp.getId()+"\" src=\""+comp.getUrl()+"\"/>";
        return html;
    }
    
    private Componente[] metodoBurbujaAsc( Componente [ ] comp )
    {
         int i;
         boolean flag = true;
         Componente temp;
 
         while ( flag )
         {
                flag = false;   
                for( i=0;  i < comp.length -1;  i++ )
                {
                       if (( comp[ i ].getIndice().compareTo(comp[i+1].getIndice())) > 0 )  
                       {
                               temp = comp[ i ];
                               comp[ i ] = comp[ i+1 ];
                               comp[ i+1 ] = temp;
                              flag = true; 
                      } 
                } 
          } 
         return comp;
    }

}
