package com.carlos.web_proyecto1.Tokens;

public class token {
    private String lexeme;
    private int column;
    private int line;
    public token(){

    }
    public token(String lexeme, int col,int lin){
        this.lexeme = lexeme;
        this.column=col;
        this.line=lin;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    public String getLexeme() {
        return lexeme;
    }
    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }
    public int getLine() {
        return line;
    }
    public void setLine(int line) {
        this.line = line;
    }
}
