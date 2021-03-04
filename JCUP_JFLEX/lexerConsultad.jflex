//CODIGO DE IMPORTORTACIONES
import java.util.ArrayList;
import java.util.List;
//import java_cup.runtime.Symbol;

%%
/*segunda seccion, configuracion*/
%class lexerConsultad
/*%cup*/
%standalone
%unicode
%line
%column
%public

%{
    //Private Symbol after_symbl = new Symbol(0);
    //private Symbol tmp_symbl = new Symbol(0);

    private List<String> errorsList = new ArrayList<>();

%}

/*EXPRECIONES REGULARES*/

LineTerminator = [\r|\n|\r\n]+
WhiteSpace = [ \t\n]+
simbolos = [!@#$%&*()+=_<>?/.:;,\|]
numeros = [0-9]
letras = [a-zA-Z]
espacio = [ ]
valor  = [\"]({simbolos}|{numeros}|{letras}|{espacio})+[\"]
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
        }
    {operadorLogico}
        {
            System.out.println("Operador Logico: "+yytext());
        }
    ","
        {
            System.out.println("Coma: "+yytext());
        }
    "->"
        {
            System.out.println("Direccion : "+yytext());
        }
    "<"
        {
            System.out.println("Menor que: "+yytext());
        }
    ">"
        {
            System.out.println("Mayor apertura: "+yytext());
        }
    "<>"
        {
            System.out.println("Llave cierre: "+yytext());
        }
    "["
        {
            System.out.println("Corchete apertura: "+yytext());
        }
    "]"
        {
            System.out.println("Corchete cierre: "+yytext());
        }
    "="
        {
            System.out.println("Signo igual: "+yytext());
        }
    ">="
        {
            System.out.println("Mayor igual que: "+yytext());
        }
    "<="
        {
            System.out.println("Menor igual que: "+yytext());
        }
    {valorNumerico}
        {
            System.out.println("Numero encontrado: "+yytext());
        }
    {valor}
        {
            System.out.println("Valor: "+yytext());
        }
    {text}
        {   
            System.out.println("Parametro encontrado: "+yytext());
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