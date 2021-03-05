//package de la clase
package com.carlos.app_cliente_proyecto1.Lexer;
//CODIGO DE IMPORTORTACIONES
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;

%%
/*segunda seccion, configuracion*/
%class lexerOpciones
%cup
/*%standalone*/
%unicode
%line
%column
%public

%{
    //Private Symbol after_symbl = new Symbol(0);
    //private Symbol tmp_symbl = new Symbol(0);

    private List<String> errorsList = new ArrayList<>();

%}
%eofval{
  //return new java_cup.runtime.Symbol(parserIndigoSym.EOF);
%eofval}

/*EXPRECIONES REGULARES*/

LineTerminator = [\r|\n|\r\n]+
WhiteSpace = [ \t\n]+




%{
    private void error(String lexeme) {
        System.out.printf("Error lexico: %s ,linea %d,  columna %d. \n", lexeme, yyline + 1, yycolumn + 1);
        errorsList.add(String.format("Error Lexico en el Texto: %s  linea %d, columna %d. Corrige e intenta de nuevo.", lexeme, yyline + 1, yycolumn + 1));
    }
    public List<String> getErrorsList() {
        return errorsList;
    }
%}

%%

/*LEXIX RULES*/
<YYINITIAL>{
    
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