//package de la clase
package com.carlos.app_cliente_proyecto1.Lexer;
//CODIGO DE IMPORTORTACIONES
import com.carlos.app_cliente_proyecto1.Parser.parserIndigoSym;
import com.carlos.app_cliente_proyecto1.Tokens.token;
import static com.carlos.app_cliente_proyecto1.Parser.parserIndigoSym.*;
import java.util.ArrayList;
import java.util.List;
import java.io.StringReader;
import com.carlos.app_cliente_proyecto1.solucionCadenas.obtenerAsignacion;
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

    private lexerInerText InerLex= new lexerInerText();

    private obtenerAsignacion getInerText = new obtenerAsignacion();

    private List<String> errorsList = new ArrayList<>();

%}
%eofval{
  return new java_cup.runtime.Symbol(parserIndigoSym.EOF);
%eofval}

/*EXPRECIONES REGULARES*/

LineTerminator = [\r|\n|\r\n]+
WhiteSpace = [ \t\n]+
atributes = [a-zA-Z_]+
reservadasConjunto = (ini_solicitud|fin_solicitud)

//conjuntoOperaciones = (<\!ini_solicitudes>|<\!fin_solicitudes>)

//conjuntoOperaciones = ((<)\!ini_solicitudes>|<\!fin_solicitudes>)
inicioConjunto = (<)([ \n\r\t])*(\!)([ \n\r\t])*([iI][nN][iI]_[sS][oO][lL][iI][cC][iI][tT][uU][dD][eE][sS])([ \n\r\t])*(>)
inicioConjuntoRes = (<)([ \n\r\t])*(\!)([ \n\r\t])*([iI][nN][iI]_[rR][eE][sS][pP][uU][eE][sS][tT][aA][sS])([ \n\r\t])*(>)
finConjunto = (<)([ \n\r\t])*(\!)([ \n\r\t])*([fF][iI][nN]_[sS][oO][lL][iI][cC][iI][tT][uU][dD][eE][sS])([ \n\r\t])*(>)
finConjuntoRes = (<)([ \n\r\t])*(\!)([ \n\r\t])*([fF][iI][nN]_[rR][eE][sS][pP][uU][eE][sS][tT][aA][sS])([ \n\r\t])*(>)

simbolos = [\]\[\{\}!@#$%&*()+=_<>?/.:;,\|\-]
numeros = [0-9]
letras = [a-zA-Z]
espacio = [ ]
text  = [\"]({simbolos}|{numeros}|{letras}|{espacio})*[\"]
fecha = [\"]([1-9][0-9][0-9][0-9])(\-)([0][1-9]|[1][0-2])(\-)([0][1-9]|[1-2][0-9]|[3][0-1])[\"]
asigId= [\"](\$|\_|\-)([0-9]|[a-zA-Z]|[$\-_])+[\"]
numConsult = (CONSULTA)(\-)([0-9]+)


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
    {inicioConjuntoRes}
        {
            System.out.println("Palabra de conjunto de respuestas: "+yytext());
            tmp_symbl = new Symbol (SCR,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    {inicioConjunto}
        {
            System.out.println("Palabra de conjunto de operaciones: "+yytext());
            tmp_symbl = new Symbol (SSS,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    {finConjunto}
        {
            System.out.println("Palabra de conjunto de operaciones: "+yytext());
            tmp_symbl = new Symbol (FSS,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    {finConjuntoRes}
        {
            System.out.println("Palabra de conjunto de respuestas: "+yytext());
            tmp_symbl = new Symbol (FCR,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "<"
        {
            //System.out.println("Menor que: "+yytext());
            tmp_symbl = new Symbol (ME_Q,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
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
    "["
        {
            //System.out.println("Corchete apertura: "+yytext());
            tmp_symbl = new Symbol (C_A,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "]"
        {
            //System.out.println("Corchete cierre: "+yytext());
            tmp_symbl = new Symbol (C_C,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    ">"
        {
            //System.out.println("Mayor que: "+yytext());
            tmp_symbl = new Symbol (MA_Q,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    "!"
        {
            //System.out.println("Admiracion: "+yytext());
            tmp_symbl = new Symbol (ADM,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
            after_symbl = tmp_symbl;
            return tmp_symbl;
        }
    ":"
        {
            //System.out.println("Dos puntos: "+yytext());
            tmp_symbl = new Symbol (D_DOT,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
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
                case "ini_respuesta":
                    tmp_symbl = new Symbol(SR, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
                    after_symbl = tmp_symbl;
                    return tmp_symbl;
                case "fin_respuesta":
                    tmp_symbl = new Symbol(FR, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
                    after_symbl = tmp_symbl;
                    return tmp_symbl;
            }
        }
    {fecha}
        {
            String text = getInerText.getAsignacion(yytext());
            System.out.println("Fecha encontrada:" + text);
            tmp_symbl = new Symbol(DATE, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
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
    {numConsult}
        {
            String text = getInerText.getAsignacion(yytext());
            InerLex.yyreset(new StringReader(text));
            try {
                InerLex.yylex();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (InerLex.getCantidadLexemas() == 1) {
                text = InerLex.getCurrentText();
                InerLex.reinicioLex();
                tmp_symbl = new Symbol(NUM_CONSULT, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                after_symbl = tmp_symbl;
                return tmp_symbl;
            }else{
                tmp_symbl = new Symbol(ASIGNACION_ESP, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                after_symbl = tmp_symbl;
                return tmp_symbl;
            }
            
        }
    {text}
        {   
            //System.out.println("Texto encontrado:" + yytext());
            String text = getInerText.getAsignacion(yytext());
            int espacios = 0;
            InerLex.yyreset(new StringReader(text));
            try {
                InerLex.yylex();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (InerLex.getCantidadLexemas() == 1) {
                espacios = InerLex.getCantidadEspacios();
                text = InerLex.getCurrentText();
                InerLex.reinicioLex();
                switch (text) {
                    case "CREAR_USUARIO":
                        tmp_symbl = new Symbol(CR_U, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "MODIFICAR_USUARIO":
                        tmp_symbl = new Symbol(MO_U, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "ELIMINAR_USUARIO":
                        tmp_symbl = new Symbol(DEL_U, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "LOGIN_USUARIO":
                        tmp_symbl = new Symbol(LOG_U, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "NUEVO_FORMULARIO":
                        tmp_symbl = new Symbol(NEW_F, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "ELIMINAR_FORMULARIO":
                        tmp_symbl = new Symbol(DEL_F, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "MODIFICAR_FORMULARIO":
                        tmp_symbl = new Symbol(MO_F, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "AGREGAR_COMPONENTE":
                        tmp_symbl = new Symbol(ADD_C, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "ELIMINAR_COMPONENTE":
                        tmp_symbl = new Symbol(DEL_C, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "MODIFICAR_COMPONENTE":
                        tmp_symbl = new Symbol(MO_C, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "CREDENCIALES_USUARIO":
                        tmp_symbl = new Symbol(CREDEN_USER, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "PARAMETROS_FORMULARIO":
                        tmp_symbl = new Symbol(PARAMS_FORM, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "PARAMETROS_COMPONENTE":
                        tmp_symbl = new Symbol(PARAMS_COMP, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "USUARIO":
                        tmp_symbl = new Symbol(USER, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "PASSWORD":
                        tmp_symbl = new Symbol(PASS, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "FECHA_CREACION":
                        tmp_symbl = new Symbol(FECHA, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "USUARIO_ANTIGUO":
                        tmp_symbl = new Symbol(USER_ANT, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "USUARIO_NUEVO":
                        tmp_symbl = new Symbol(USER_NEW, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "NUEVO_PASSWORD":
                        tmp_symbl = new Symbol(PASS_NEW, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "FECHA_MODIFICACION":
                        tmp_symbl = new Symbol(FECHA_MOD, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
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
                    case "USUARIO_CREACION":
                        tmp_symbl = new Symbol(USER_CRE, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "NOMBRE_CAMPO":
                        tmp_symbl = new Symbol(NAME_CAMP, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "FORMULARIO":
                        tmp_symbl = new Symbol(FORM, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
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
                    case "URL​":
                        tmp_symbl = new Symbol(URL, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "CAMPO_TEXTO​":
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
                    case "CENTRAR":
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
                    case "DESCRIPCION":
                        tmp_symbl = new Symbol(DES, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "MENSAJE":
                        tmp_symbl = new Symbol(MJS, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "ERRORES_LEXICOS":
                        tmp_symbl = new Symbol(ERL, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "ERRORES_SINTACTICOS":
                        tmp_symbl = new Symbol(ERS, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "MENSAJE_USUARIO":
                        tmp_symbl = new Symbol(MJSU, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "CONSULTAR_DATOS":
                        tmp_symbl = new Symbol(CONSULT_DATA, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "CONSULTA":
                        tmp_symbl = new Symbol(CONSULT, after_symbl.sym, 0, new token(text, yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    default:
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

            } else {
                espacios = InerLex.getCantidadEspacios();
                InerLex.reinicioLex();
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
    {atributes}
        {
            //System.out.println("Atributo encontrado: "+yytext());
            String compare = yytext().toLowerCase();
                switch (compare) {
                    case "ini_solicitud":
                        System.out.println("Palabra recerbada etiqueta: "+yytext());
                        tmp_symbl = new Symbol(SS, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "fin_solicitud":
                        System.out.println("Palabra recerbada etiqueta: "+yytext());
                        tmp_symbl = new Symbol(FS, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "ini_respuesta":
                        System.out.println("Palabra recerbada etiqueta: "+yytext());
                        tmp_symbl = new Symbol(SR, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    case "fin_respuesta":
                        System.out.println("Palabra recerbada etiqueta: "+yytext());
                        tmp_symbl = new Symbol(FR, after_symbl.sym, 0, new token(yytext(), yycolumn + 1, yyline + 1));
                        after_symbl = tmp_symbl;
                        return tmp_symbl;
                    default:
                        System.out.println("Default case: "+yytext());
                        error(yytext());
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

