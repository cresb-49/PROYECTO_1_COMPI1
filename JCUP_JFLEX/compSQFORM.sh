#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar jflex-full-1.8.2.jar lexerConsultad.jflex
java -jar java-cup-11b.jar parserConsultas.cup
echo "ARCHIVOS COPIADOS"
cp lexerSQFORM.java ../WEB_PROYECTO1/src/main/java/com/carlos/web_proyecto1/Lexer
cp parserSQFORM.java ../WEB_PROYECTO1/src/main/java/com/carlos/web_proyecto1/Parser
cp parserSQFORMSym.java ../WEB_PROYECTO1/src/main/java/com/carlos/web_proyecto1/Parser
echo "ELIMINAR ARCHIVOS TEMPORALES"
rm lexerSQFORM.java 
rm parserSQFORM.java 
rm parserSQFORMSym.java 