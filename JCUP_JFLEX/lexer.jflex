//CODIGO DE IMPORTORTACIONES
import java.util.ArrayList;
import java.util.List;
//import java_cup.runtime.Symbol;

%%
/*segunda seccion, configuracion*/
%class lexer
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
atributes = [a-zA-Z_]+
//text  = [\"][a-zA-Z_$0-9]+[\"]
text  = [\"][^]+[\"]


%{
    private void error(String lexeme) {
        System.out.printf("Error lexico \"%s\" linea %d,  columna %d. \n", lexeme, yyline + 1, yycolumn + 1);
        errorsList.add(String.format("Error Lexico en el Texto: %s  linea %d, columna %d. Corrige e intenta de nuevo.", lexeme, yyline + 1, yycolumn + 1));
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
            System.out.println("Texto encontrado: "+yytext());
        }
    {atributes}
        {
            System.out.println("Atributo encontrado: "+yytext());
        }
    "<"
        {
            System.out.println("Menor que: "+yytext());
        }
    "{"
        {
            System.out.println("Llave apertura: "+yytext());
        }
    "}"
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
    ">"
        {
            System.out.println("Mayor que: "+yytext());
        }
    "!"
        {
            System.out.println("Admiracion: "+yytext());
        }
    ":"
        {
            System.out.println("Dos puntos: "+yytext());
        }
    ","
        {
            System.out.println("Coma: "+yytext());
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