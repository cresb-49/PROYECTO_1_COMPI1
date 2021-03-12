/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.app_cliente_proyecto1;

import com.carlos.app_cliente_proyecto1.UI.PrincipalFrame;
import com.carlos.app_cliente_proyecto1.Lexer.lexerIndigo;
import com.carlos.app_cliente_proyecto1.Objetos.*;
import com.carlos.app_cliente_proyecto1.Parser.parserIndigo;
import java.io.StringReader;

public class main {

    public static void main(String[] args) {
        //PrincipalFrame principal = new PrincipalFrame();
        pruebas2();
    }

    private static void pruebas2() {
       
    }

    private static void pruebas() {

        String var = "<!ini_solicitud:\"MODIFICAR_COMPONENTE\">\n"
                + "	{\"PARAMETROS_COMPONENTE\":[{\n"
                + "		\"ID\": \"$_grupo_paises\",\n"
                + "		\"FORMULARIO\": \"$form1\",\n"
                + "		\"CLASE\": \"CHECKBOX\",\n"
                + "		\"INDICE\": \"1\",\n"
                + "		\"ALINEACION\": \"DERECHA\",\n"
                + "		\"OPCIONES\":\"Guatemala|El Salvador|Honduras|OTRO\"\n"
                + "	}]\n"
                + "	}\n"
                + "<fin_solicitud!>";

        lexerIndigo lex = new lexerIndigo(new StringReader(var));
        parserIndigo parser = new parserIndigo(lex);
        try {
            parser.parse();

            System.out.println("Log User: " + parser.getLogUser().toString());

            for (usuario user : parser.getDelUser()) {
                System.out.println(user.toString());
            }

            for (usuario user : parser.getCreateUser()) {
                System.out.println(user.toString());
            }

            for (userNew user : parser.getModUser()) {
                System.out.println(user.toString());
            }
            for (formulario form : parser.getNewForms()) {
                System.out.println(form.toString());
            }

            for (formulario form : parser.getDelForm()) {
                System.out.println(form.toString());
            }

            for (formulario form : parser.getModForm()) {
                System.out.println(form.toString());
            }

            for (componente comp : parser.getDelComp()) {
                System.out.println(comp.toString());
            }

            for (componente comp : parser.getAddComp()) {
                System.out.println(comp.toString());
            }

            for (componente comp : parser.getModComp()) {
                System.out.println(comp.toString());
            }

            for (mensaje mnj : parser.getErrLex()) {
                System.out.println(mnj.toString());
            }

            for (mensaje mnj : parser.getErrSin()) {
                System.out.println(mnj.toString());
            }

            for (mensaje mnj : parser.getMsjUser()) {
                System.out.println(mnj.toString());
            }

        } catch (Exception ex) {
            System.err.println("Error irrcuperable indigo");
            ex.printStackTrace();
        }

    }
}
