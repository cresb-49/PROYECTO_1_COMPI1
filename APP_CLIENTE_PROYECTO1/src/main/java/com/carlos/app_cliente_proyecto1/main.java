/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.app_cliente_proyecto1;

import com.carlos.app_cliente_proyecto1.EDD.Pila;
import com.carlos.app_cliente_proyecto1.Lexer.lexerIndigo;
import com.carlos.app_cliente_proyecto1.Lexer.lexerOpciones;
import com.carlos.app_cliente_proyecto1.Parser.parserIndigo;
import com.carlos.app_cliente_proyecto1.UI.PrincipalFrame;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static void main(String[] args) {
        PrincipalFrame principal = new PrincipalFrame();
        //pruebas();

    }

    private static void pruebas() {
        String code = "<!ini_solicitudes>\n"
                + "    <!ini_solicitud:\"CONSULTAR_DATOS\">\n"
                + "        { \"CONSULTAS\":[\n"
                + "            {\n"
                + "                \"CONSULTA-1\": \"SELECT TO FORM -> $form_encuesta_1 []\",\n"
                + "                \"CONSULTA-2\": \"SELECT TO FORM -> $form_encuesta_1 [Cliente,Edad] WHERE [Edad >= 10 AND Cliente = 'Julio Paz']\"\n"
                + "            },\n"
                + "            {\n"
                + "                \"CONSULTA-1\": \"SELECT TO FORM -> $form_encuesta_1 []\",\n"
                + "                \"CONSULTA-2\": \"SELECT TO FORM -> $form_encuesta_1 [Cliente,Edad] WHERE [Edad >= 10 AND Cliente = 'Julio Paz']\"\n"
                + "            }\n"
                + "        ]\n"
                + "        }\n"
                + "    <fin_solicitud!>\n"
                + "<!fin_solicitudes>";

        lexerIndigo lex = new lexerIndigo(new StringReader(code));
        parserIndigo parser = new parserIndigo(lex);

        try {
            parser.parse();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
