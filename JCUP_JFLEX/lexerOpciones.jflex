//package de la clase
package com.carlos.app_cliente_proyecto1.Lexer;
//CODIGO DE IMPORTORTACIONES
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;

%%
/*segunda seccion, configuracion*/
%class lexerOpciones
%unicode
%line
%column
%public

%{
    

    private List<String> errorsList = new ArrayList<>();
    private List<String> opciones = new ArrayList<>();

%}

/*EXPRECIONES REGULARES*/

LineTerminator = [\r|\n|\r\n]+
WhiteSpace = [ \t\n]+

simbolos = [\]\[\{\}!@#$%&*'~`°¬¡¿¨()+=_<>?\\/.:;,\-\^]
numeros = [0-9]
letras = [a-zA-Z]
text  = ({simbolos}|{numeros}|{letras}|[ \t])+


%{
    public lexerOpciones(){

    }

    private void error(String lexeme) {
        System.out.printf("Error lexico: %s ,linea %d,  columna %d. \n", lexeme, yyline + 1, yycolumn + 1);
        errorsList.add(String.format("Error Lexico en el Texto: %s  linea %d, columna %d. Corrige e intenta de nuevo.", lexeme, yyline + 1, yycolumn + 1));
    }
    public List<String> getErrorsList() {
        return errorsList;
    }
    public List<String> getOpciones() {
        return opciones;
    }

    public void reinicioLex(){
        opciones.clear();
    }
%}

%%

/*LEXIX RULES*/
<YYINITIAL>{
    {text}
        {
            //System.out.println("Encontre una opcion: "+yytext());
            opciones.add(yytext());
        }
    {LineTerminator}
        {
            /*Do nothing*/
        }
    {WhiteSpace}
        {
            /*Do nothing*/
        }
}
[^]     {
            error(yytext());
        }