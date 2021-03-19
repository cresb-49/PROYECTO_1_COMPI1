
package com.carlos.app_cliente_proyecto1.Lexer;

import com.carlos.app_cliente_proyecto1.Parser.parserImportarSym;
import static com.carlos.app_cliente_proyecto1.Parser.parserImportarSym.*;
import com.carlos.app_cliente_proyecto1.Tokens.token;
import com.carlos.app_cliente_proyecto1.solucionCadenas.obtenerAsignacion;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;

%%
/*segunda seccion, configuracion*/
%class lexerImportar
%cup
/*%standalone*/
%unicode
%line
%column
%public

LineTerminator = [\r|\n|\r\n]+
WhiteSpace = [ \t\n]+
simbolos = [\]\[\{\}!@#$%&*'~`°¬¡¿¨()+=_<>?/.:;,\|\-\^]
numeros = [0-9]
letras = [a-zA-Z]
text  = [\"]({simbolos}|{numeros}|{letras}|[ \t\n])*[\"]
fecha = [\"]([1-9][0-9][0-9][0-9])(\-)([0][1-9]|[1][0-2])(\-)([0][1-9]|[1-2][0-9]|[3][0-1])[\"]
asigId= [\"](\$|\_|\-)([0-9]|[a-zA-Z]|[$\-_])*[\"]
numConsult = (CONSULTA)(\-)([0-9]+)
newForm = (new.formulario)


%{
    private Symbol after_symbl = new Symbol(0);
    private Symbol tmp_symbl = new Symbol(0);

    private lexerInerText InerLex= new lexerInerText();

    private obtenerAsignacion getInerText = new obtenerAsignacion();

    private List<String> errorsList = new ArrayList<>();

%}
%eofval{
  return new java_cup.runtime.Symbol(parserImportarSym.EOF);
%eofval}

%{
    private void error(String lexeme) {

        System.out.printf("Error lexico: %s ,linea %d,  columna %d. \n", ((lexeme.equals("\""))?"comilla":lexeme), yyline + 1, yycolumn + 1);
        errorsList.add(String.format("Error Lexico en el Texto: %s  linea %d, columna %d. Corrige e intenta de nuevo.", ((lexeme.equals("\""))?"comilla":lexeme), yyline + 1, yycolumn + 1));
    }
    public List<String> getErrorsList() {
        return errorsList;
    }
%}
%%

/*LEXIX RULES*/
<YYINITIAL>{
    ":"
        {
            tmp_symbl = new Symbol (D_DOT,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "{"
        {
            //System.out.println("Llave apertura: "+yytext());
            tmp_symbl = new Symbol (L_A,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "}"
        {
            //System.out.println("Llave cierre: "+yytext());
            tmp_symbl = new Symbol (L_C,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "("
        {
            //System.out.println("Llave cierre: "+yytext());
            tmp_symbl = new Symbol (P_A,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    ")"
        {
            //System.out.println("Llave cierre: "+yytext());
            tmp_symbl = new Symbol (P_C,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    ","
        {
            //System.out.println("Coma: "+yytext());
            tmp_symbl = new Symbol (COM,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    {newForm}
        {
            tmp_symbl = new Symbol (NEW_FORM,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    {asigId}
        {
            String text = getInerText.getAsignacion(yytext());
            //System.out.println("Formato de ID:" + text);
            tmp_symbl = new Symbol(ASIG_ID, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    {text}
        {   
            //System.out.println("Texto encontrado:" + yytext());
            String text = getInerText.getAsignacion(yytext());
            int espacios = 0;
            boolean num = false;
            InerLex.yyreset(new StringReader(text));
            try {
                InerLex.yylex();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (InerLex.getCantidadLexemas() == 1) {
                espacios = InerLex.getCantidadEspacios();
                text = InerLex.getCurrentText();
                num = InerLex.isNumero();
                InerLex.reinicioLex();
                switch (text) {
                    case "ID_FORMULARIO":
                        tmp_symbl = new Symbol(ID_FORM, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "ID":
                        tmp_symbl = new Symbol(ID, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "TITULO":
                        tmp_symbl = new Symbol(TITLE, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "NOMBRE":
                        tmp_symbl = new Symbol(NAME, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "TEMA":
                        tmp_symbl = new Symbol(THEME, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "ESTRUCTURA":
                        tmp_symbl = new Symbol(ESTRUCT, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "NOMBRE_CAMPO":
                        tmp_symbl = new Symbol(NAME_CAMP, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "CLASE":
                        tmp_symbl = new Symbol(CLASS, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "INDICE":
                        tmp_symbl = new Symbol(IND, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "TEXTO_VISIBLE":
                        tmp_symbl = new Symbol(TEXT_VIEW, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "ALINEACION":
                        tmp_symbl = new Symbol(ALI, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "REQUERIDO":
                        tmp_symbl = new Symbol(REQUE, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "OPCIONES":
                        tmp_symbl = new Symbol(OPTION, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "FILAS":
                        tmp_symbl = new Symbol(FILAS, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "COLUMNAS":
                        tmp_symbl = new Symbol(COLM, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "URL":
                        tmp_symbl = new Symbol(URL, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "CAMPO_TEXTO":
                        tmp_symbl = new Symbol(CAMP_TEXT, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "AREA_TEXTO":
                        tmp_symbl = new Symbol(TEXT_AREA, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "CHECKBOX":
                        tmp_symbl = new Symbol(CHECK, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "RADIO":
                        tmp_symbl = new Symbol(RADIO, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "FICHERO":
                        tmp_symbl = new Symbol(FILE, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "IMAGEN":
                        tmp_symbl = new Symbol(IMG, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "COMBO":
                        tmp_symbl = new Symbol(COMBO, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "BOTON":
                        tmp_symbl = new Symbol(BOTON, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "CENTRO":
                        tmp_symbl = new Symbol(CENT, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "IZQUIERDA":
                        tmp_symbl = new Symbol(IZQ, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "DERECHA":
                        tmp_symbl = new Symbol(DER, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "JUSTIFICAR":
                        tmp_symbl = new Symbol(JUST, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "SI":
                        tmp_symbl = new Symbol(YES, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "NO":
                        tmp_symbl = new Symbol(NOT, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    default:
                        if(num){
                            tmp_symbl = new Symbol(ASIGNACION_NUM, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                            after_symbl = tmp_symbl;
                            return tmp_symbl;
                        }else{
                            if (espacios == 0) {
                                tmp_symbl = new Symbol(ASIGNACION, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                                after_symbl = tmp_symbl;
                                return tmp_symbl;
                            } else {
                                text = getInerText.getAsignacion(yytext());
                                tmp_symbl = new Symbol(ASIGNACION_ESP, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                                after_symbl = tmp_symbl;
                                return tmp_symbl;
                            }
                        }
                    }

            } else {
                espacios = InerLex.getCantidadEspacios();
                num = InerLex.isNumero();
                InerLex.reinicioLex();
                if(num){
                    tmp_symbl = new Symbol(ASIGNACION_NUM, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                    after_symbl = tmp_symbl;
                    return tmp_symbl;
                }else{
                    if (espacios == 0) {
                        tmp_symbl = new Symbol(ASIGNACION, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    } else {
                        text = getInerText.getAsignacion(yytext());
                        tmp_symbl = new Symbol(ASIGNACION_ESP, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    }
                }
            }
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