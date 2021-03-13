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

        String var = "<!ini_solicitudes>\n"
                + "<!ini_solicitud:\"MODIFICAR_FORMULARIO\">\n"
                + "{\n"
                + "    \"PARAMETROS_FORMULARIO\":[\n"
                + "        {\n"
                + "            \"ID\": \"$form1\",\n"
                + "            \"TITULO\": \"Formulario para encuesta 1\",\n"
                + "            \"NOMBRE\": \"formulario_encuesta_1\"\n"
                + "        }\n"
                + "    ]\n"
                + "}\n"
                + "<fin_solicitud!>\n"
                + "<!ini_solicitud:\"ELIMINAR_FORMULARIO\">\n"
                + "{\n"
                + "    \"PARAMETROS_FORMULARIO\":[\n"
                + "        {\n"
                + "            \"ID\": \"$form1\"\n"
                + "        },\n"
                + "        {\n"
                + "            \"ID\": \"$form1\"\n"
                + "        },\n"
                + "        {\n"
                + "            \"ID\": \"$form1\"\n"
                + "        }\n"
                + "    ]\n"
                + "}\n"
                + "<fin_solicitud!>\n"
                + "<!ini_solicitud: \"MODIFICAR_USUARIO\" >\n"
                + "{\n"
                + "\"CREDENCIALES_USUARIO\":\n"
                + "[\n"
                + "    {\n"
                + "        \"USUARIO_ANTIGUO\": \"juanito619\",\n"
                + "        \"USUARIO_NUEVO\": \"juanito619lopez\",\n"
                + "        \"NUEVO_PASSWORD\": \"12345678910\"\n"
                + "    }\n"
                + "]\n"
                + "}\n"
                + "<fin_solicitud!>\n"
                + "<!ini_solicitud: \"CREAR_USUARIO\" >\n"
                + "{\n"
                + "\"CREDENCIALES_USUARIO\":\n"
                + "[\n"
                + "    {\n"
                + "        \"USUARIO\": \"juanito619\",\n"
                + "        \"PASSWORD\": \"12345678\"\n"
                + "    },\n"
                + "    {\n"
                + "        \"USUARIO\": \"juanito200\",\n"
                + "        \"PASSWORD\": \"12345\"\n"
                + "    }\n"
                + "]\n"
                + "}\n"
                + "<fin_solicitud!>\n"
                + "<!fin_solicitudes>";

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
