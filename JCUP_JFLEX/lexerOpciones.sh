#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar jflex-full-1.8.2.jar lexerOpciones.jflex
cp lexerOpciones.java ../APP_CLIENTE_PROYECTO1/src/main/java/com/carlos/app_cliente_proyecto1/Lexer
