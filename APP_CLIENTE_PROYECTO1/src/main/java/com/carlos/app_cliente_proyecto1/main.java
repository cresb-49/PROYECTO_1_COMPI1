/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.app_cliente_proyecto1;

import com.carlos.app_cliente_proyecto1.UI.PrincipalFrame;
import com.carlos.app_cliente_proyecto1.HttpMethods.peticionLogin;
import com.carlos.app_cliente_proyecto1.Lexer.lexerIndigo;
import com.carlos.app_cliente_proyecto1.Lexer.lexerInerText;
import com.carlos.app_cliente_proyecto1.Parser.parserIndigo;
import com.carlos.app_cliente_proyecto1.Tokens.token;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benjamin
 */
public class main {

    public static void main(String[] args) {
        //PrincipalFrame principal = new PrincipalFrame();
        /*peticionLogin log = new peticionLogin();
        try {
            String res = log.peticionHttpGet("https://jsonplaceholder.typicode.com/todos/1");
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
 /*
        String dato = "\"NUEVO_FORMULARIO nuevo\"";
        String dato2 = dato.substring(1, dato.length() - 1);

        lexerInerText lexInner = new lexerInerText(new StringReader(dato2));
        try {
            lexInner.yylex();
            System.out.println("Cantidad de cadenas encontradas: " + lexInner.getCantidadLexemas());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        lexInner.reinicioLex();
         */

        pruebas();
    }

    private static void pruebas() {

        String var = "<!ini_solicitudes>\n"
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
                + "\n"
                + "<!ini_solicitud: \"CREAR_USUARIO\" >\n"
                + "{\n"
                + "\"CREDENCIALES_USUARIO\":\n"
                + "[\n"
                + "    {\n"
                + "        \"USUARIO\": \"juan\",\n"
                + "        \"PASSWORD\": \"18\"\n"
                + "    }\n"
                + "]\n"
                + "}\n"
                + "<fin_solicitud!>\n"
                + "\n"
                + "<!fin_solicitudes>";

        lexerIndigo lex = new lexerIndigo(new StringReader(var));
        parserIndigo parser = new parserIndigo(lex);
        try {
            parser.parse();
        } catch (Exception ex) {
            System.err.println("Error irrcuperable indigo");
            ex.printStackTrace();
        }

    }
}
