#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar jflex-full-1.8.2.jar lexerImpor_Expor.jflex
echo "STARTING JAVA CUP COMPILING"
java -jar java-cup-11b.jar parserImport_Expor.cup
#javac lexerIndigo.java
#java lexerIndigo entrada.txt
echo "COPY FILES"
cp lexerImportar.java ../APP_CLIENTE_PROYECTO1/src/main/java/com/carlos/app_cliente_proyecto1/Lexer


cp parserImportar.java ../APP_CLIENTE_PROYECTO1/src/main/java/com/carlos/app_cliente_proyecto1/Parser
cp parserImportarSym.java ../APP_CLIENTE_PROYECTO1/src/main/java/com/carlos/app_cliente_proyecto1/Parser

echo "DELETE TEMP FILES"
rm lexerImportar.java 
rm parserImportar.java 
rm parserImportarSym.java 
