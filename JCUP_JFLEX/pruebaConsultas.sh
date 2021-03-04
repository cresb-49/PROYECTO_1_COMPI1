#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar jflex-full-1.8.2.jar lexerConsultad.jflex
javac lexerConsultad.java
java lexerConsultad consultas.txt