#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar jflex-full-1.8.2.jar lexerIndigo.jflex
javac lexerIndigo.java
java lexerIndigo entrada.txt
