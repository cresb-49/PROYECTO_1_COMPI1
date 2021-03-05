//package de la clase
package com.carlos.app_cliente_proyecto1.Lexer;
//CODIGO DE IMPORTORTACIONES
import com.carlos.app_cliente_proyecto1.Parser.parserIndigoSym;
import com.carlos.app_cliente_proyecto1.Tokens.token;
import static com.carlos.app_cliente_proyecto1.Parser.parserIndigoSym.*;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;

%%
/*segunda seccion, configuracion*/
%class lexerIndigo
%cup
/*%standalone*/
%unicode
%line
%column
%public

%{
    private Symbol after_symbl = new Symbol(0);
    private Symbol tmp_symbl = new Symbol(0);

    private List<String> errorsList = new ArrayList<>();

%}
%eofval{
  return new java_cup.runtime.Symbol(parserIndigoSym.EOF);
%eofval}

/*EXPRECIONES REGULARES*/

LineTerminator = [\r|\n|\r\n]+
WhiteSpace = [ \t\n]+
atributes = [a-zA-Z_]+
reservadasConjunto = (ini_solicitud|fin_solicitud|ini_solicitudes|fin_solicitudes)
simbolos = [\[\[\{\}!@#$%&*()+=_<>?/.:;,\|]
numeros = [0-9]
letras = [a-zA-Z]
espacio = [ ]
//text  = [\"]([a-zA-Z_$0-9: ])+[\"]
//optionText  = [\"]([a-zA-Z0-9\| ])+[\"]
text  = [\"]({simbolos}|{numeros}|{letras}|{espacio})+[\"]



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
    "<"
        {
            System.out.println("Menor que: "+yytext());
            tmp_symbl = new Symbol (ME_Q,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "{"
        {
            System.out.println("Llave apertura: "+yytext());
            tmp_symbl = new Symbol (L_A,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "}"
        {
            System.out.println("Llave cierre: "+yytext());
            tmp_symbl = new Symbol (L_C,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "["
        {
            System.out.println("Corchete apertura: "+yytext());
            tmp_symbl = new Symbol (C_A,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "]"
        {
            System.out.println("Corchete cierre: "+yytext());
            tmp_symbl = new Symbol (C_C,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    ">"
        {
            System.out.println("Mayor que: "+yytext());
            tmp_symbl = new Symbol (MA_Q,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "!"
        {
            System.out.println("Admiracion: "+yytext());
            tmp_symbl = new Symbol (ADM,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    ":"
        {
            System.out.println("Dos puntos: "+yytext());
            tmp_symbl = new Symbol (D_DOT,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    ","
        {
            System.out.println("Coma: "+yytext());
            tmp_symbl = new Symbol (COM,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    {reservadasConjunto}
        {
            System.out.println("Palabra recerbada etiqueta: "+yytext());
            switch (yytext()) {
                case "ini_solicitud":
                    tmp_symbl = new Symbol (SS,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
                    after_symbl = tmp_symbl;
                    return tmp_symbl;
                case "fin_solicitud":
                    tmp_symbl = new Symbol (FS,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
                    after_symbl = tmp_symbl;
                    return tmp_symbl;
                case "ini_solicitudes":
                    tmp_symbl = new Symbol (SSS,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
                    after_symbl = tmp_symbl;
                    return tmp_symbl;
                case "fin_solicitudes":
                    tmp_symbl = new Symbol (FSS,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
                    after_symbl = tmp_symbl;
                    return tmp_symbl;
            }
        }
    {text}
        {   
            System.out.println("Texto encontrado: "+yytext());
        }
    {atributes}
        {
            System.out.println("Atributo encontrado: "+yytext());
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

