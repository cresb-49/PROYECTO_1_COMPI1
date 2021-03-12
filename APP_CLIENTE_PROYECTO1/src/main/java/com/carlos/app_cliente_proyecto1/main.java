/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.app_cliente_proyecto1;

import com.carlos.app_cliente_proyecto1.HttpMethods.peticionLogin;
import com.carlos.app_cliente_proyecto1.UI.PrincipalFrame;
import com.carlos.app_cliente_proyecto1.Lexer.lexerIndigo;
import com.carlos.app_cliente_proyecto1.Objetos.*;
import com.carlos.app_cliente_proyecto1.Parser.parserIndigo;
import java.io.StringReader;

public class main {

    public static void main(String[] args) {
        //PrincipalFrame principal = new PrincipalFrame();
        pruebas();
    }

    private static void pruebas2() {
        peticionLogin log = new peticionLogin();
        log.geHelloAge();
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

            for (Object ins : parser.getInstrucciones()) {
                System.out.println(ins.toString());
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
