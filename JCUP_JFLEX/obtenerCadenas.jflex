package com.carlos.app_cliente_proyecto1.Lexer;

import java.util.ArrayList;
import java.util.List;

%%
/*segunda seccion, configuracion*/
%class lexerInerText
/*%cup*/
/*%standalone*/
%unicode
%line
%column
%public

%{
    /*private Symbol after_symbl = new Symbol(0);*/
    /*private Symbol tmp_symbl = new Symbol(0);*/

    private List<String> errorsList = new ArrayList<>();
    private String currentText="";
    private int cantidadLexemas = 0;
    private int cantidadEspacios = 0;

%}

/*EXPRECIONES REGULARES*/

WhiteSpace = [ ]+
//atributes = [a-zA-Z_]+
simbolos = [\]\[\{\}!@#$%&*()+=_<>?/.:;,\|\-\^]
numeros = [0-9]
letras = [a-zA-Z]
text  = ({simbolos}|{numeros}|{letras})+

%{
    
    public lexerInerText(){

    }

    private void error(String lexeme) {
        //System.out.printf("Error lexico: %s ,linea %d,  columna %d. \n", lexeme, yyline + 1, yycolumn + 1);
        //errorsList.add(String.format("Error Lexico en el Texto: %s  linea %d, columna %d. Corrige e intenta de nuevo.", lexeme, yyline + 1, yycolumn + 1));
    }
    public String getCurrentText(){
        return currentText;
    }
    public int getCantidadLexemas(){
        return cantidadLexemas;
    }
    public int getCantidadEspacios() {
        return cantidadEspacios;
    }
    public void reinicioLex(){
        cantidadLexemas=0;
        cantidadEspacios=0;
        currentText="";
    }
    public List<String> getErrorsList() {
        return errorsList;
    }
%}

%%

/*LEXIX RULES*/
<YYINITIAL>{
    {text}
        {
            //System.out.println("Texto Encontrado: "+yytext());
            cantidadLexemas++;
            currentText = yytext();
        }
    {WhiteSpace}
        {
            cantidadEspacios++;
        }
}

[^]     {
            error(yytext());
        }