/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.proyecto1_compi1.Lexer;

/**
 *
 * @author benjamin
 */
class Yytoken {
    
    private String lexema;
    private int line;
    private int column;
    
    public Yytoken(){
        
    }
    public Yytoken(String lexema,int line,int column){
        this.lexema=lexema;
        this.line=line;
        this.column=column;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Yytoken{" + "lexema=" + lexema + ", line=" + line + ", column=" + column + '}';
    }
}
