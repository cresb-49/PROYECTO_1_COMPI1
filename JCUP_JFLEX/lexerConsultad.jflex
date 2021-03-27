package com.carlos.web_proyecto1.Lexer;
//CODIGO DE IMPORTORTACIONES
import com.carlos.web_proyecto1.Parser.parserSQFORMSym;
import static com.carlos.web_proyecto1.Parser.parserSQFORMSym.*;
import com.carlos.web_proyecto1.Tokens.token;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;

%%
/*segunda seccion, configuracion*/
%class lexerSQFORM
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
  return new java_cup.runtime.Symbol(parserSQFORMSym.EOF);
%eofval}

/*EXPRECIONES REGULARES*/

LineTerminator = [\r|\n|\r\n]+
WhiteSpace = [ \t\n]+
simbolos = [!@#$%&*()+=_<>?/.:;,\|]
numeros = [0-9]
letras = [a-zA-Z]
espacio = [ ]
valor  = [\']({simbolos}|{numeros}|{letras}|{espacio})+[\']
text = ({simbolos}|{letras})+({numeros})*
valorNumerico = (({numeros})+|({numeros})+(.)({numeros})+)
palabrasRecerbadas = (SELECT|TO|FORM|WHERE)
operadorLogico=(AND|OR|NOT)



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
    {palabrasRecerbadas}
        {
            System.out.println("Palabra recervada: "+yytext());
            if(yytext().equals("SELECT")){
                tmp_symbl = new Symbol(SELECT, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            }
            else if(yytext().equals("TO")){
                tmp_symbl = new Symbol(TO, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            }
            else if(yytext().equals("FORM")){
                tmp_symbl = new Symbol(FORM, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            }
            else if(yytext().equals("WHERE")){
                tmp_symbl = new Symbol(WHERE, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            }
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    {operadorLogico}
        {
            System.out.println("Operador Logico: "+yytext());
            if(yytext().equals("AND")){
                tmp_symbl = new Symbol(AND, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            }
            else if(yytext().equals("OR")){
                tmp_symbl = new Symbol(OR, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            }
            else if(yytext().equals("NOT")){
                tmp_symbl = new Symbol(NOT, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            }
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    ","
        {
            System.out.println("Coma: "+yytext());
            tmp_symbl = new Symbol(COMA, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "->"
        {
            System.out.println("Direccion : "+yytext());
            tmp_symbl = new Symbol(DIR, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "<"
        {
            System.out.println("Menor que: "+yytext());
            tmp_symbl = new Symbol(ME_Q, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    ">"
        {
            System.out.println("Mayor apertura: "+yytext());
            tmp_symbl = new Symbol(MA_Q, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "<>"
        {
            System.out.println("Llave cierre: "+yytext());
            tmp_symbl = new Symbol(ME_Q_MA_Q, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "["
        {
            System.out.println("Corchete apertura: "+yytext());
            tmp_symbl = new Symbol(C_A, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "]"
        {
            System.out.println("Corchete cierre: "+yytext());
            tmp_symbl = new Symbol(C_C, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "="
        {
            System.out.println("Signo igual: "+yytext());
            tmp_symbl = new Symbol(EQ, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    ">="
        {
            System.out.println("Mayor igual que: "+yytext());
            tmp_symbl = new Symbol(MA_EQ, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "<="
        {
            System.out.println("Menor igual que: "+yytext());
            tmp_symbl = new Symbol(ME_Q, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    {valorNumerico}
        {
            System.out.println("Numero encontrado: "+yytext());
            tmp_symbl = new Symbol(NUM, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    {valor}
        {
            System.out.println("Valor: "+yytext());
            tmp_symbl = new Symbol(VALUE, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    {text}
        {   
            System.out.println("Parametro encontrado: "+yytext());
            tmp_symbl = new Symbol(PARAM, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
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