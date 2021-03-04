#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar jflex-full-1.8.2.jar lexer.jflex
javac lexer.java
java lexer entrada.txt