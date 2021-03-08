#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar jflex-full-1.8.2.jar lexerIndigo.jflex
echo "STARTING JAVA CUP COMPILING"
java -jar java-cup-11b.jar parserIndigo.cup
#javac lexerIndigo.java
#java lexerIndigo entrada.txt
echo "COPY FILES"
cp lexerIndigo.java ../APP_CLIENTE_PROYECTO1/src/main/java/com/carlos/app_cliente_proyecto1/Lexer
cp lexerIndigo.java ../PROYECTO1_COMPI1/src/main/java/com/carlos/proyecto1_compi1/Lexer

cp parserIndigo.java ../APP_CLIENTE_PROYECTO1/src/main/java/com/carlos/app_cliente_proyecto1/Parser
cp parserIndigoSym.java ../APP_CLIENTE_PROYECTO1/src/main/java/com/carlos/app_cliente_proyecto1/Parser

cp parserIndigo.java ../PROYECTO1_COMPI1/src/main/java/com/carlos/proyecto1_compi1/Parser
cp parserIndigoSym.java ../PROYECTO1_COMPI1/src/main/java/com/carlos/proyecto1_compi1/Parser

echo "DELETE TEMP FILES"
rm lexerIndigo.java 
rm parserIndigo.java 
rm parserIndigoSym.java 

