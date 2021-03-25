package com.carlos.app_cliente_proyecto1.Lexer;

import java.util.ArrayList;
import java.util.List;

%%
/*segunda seccion, configuracion*/
%class lexerInerText
%unicode
%line
%column
%public

%{
    private List<String> errorsList = new ArrayList<>();
    private String currentText="";
    private int cantidadLexemas = 0;
    private int cantidadEspacios = 0;
    private boolean numero = false;

%}

/*EXPRECIONES REGULARES*/

WhiteSpace = [ \t\n]+
simbolos = [\]\[\{\}!@#$%&*'~`°¬¡¿¨()+=_<>?/.:;,\|\-\^]
numeros = [0-9]
letras = [a-zA-Z]
text  = ({simbolos}|{numeros}|{letras})+
nums = ({numeros})+

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
        numero = false;
        currentText="";
    }
    public List<String> getErrorsList() {
        return errorsList;
    }

    public boolean isNumero(){
        return numero;
    }    

%}

%%

/*LEXIX RULES*/
<YYINITIAL>{
    {nums}
        {
            //System.out.println("Numero encontrado: "+yytext());
            currentText = yytext();
            numero=true;
        }
    {text}
        {
            //System.out.println("Texto Encontrado: "+yytext());
            cantidadLexemas++;
            currentText = yytext();
            numero = false;
        }
    {WhiteSpace}
        {
            cantidadEspacios++;
        }
}

[^]     {
            error(yytext());
        }