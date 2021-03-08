#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar jflex-full-1.8.2.jar obtenerCadenas.jflex
echo "ARCHIVOS COPIADOS"
cp lexerInerText.java ../APP_CLIENTE_PROYECTO1/src/main/java/com/carlos/app_cliente_proyecto1/Lexer
cp lexerInerText.java ../WEB_PROYECTO1/src/main/java/com/carlos/web_proyecto1/Lexer
echo "ELIMINAR ARCHIVOS TEMPORALES"
rm lexerInerText.java 