#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar /home/jesfrin/Documentos/LibreriasJava/jflex-1.7.0/lib/jflex-full-1.7.0.jar -d /home/jesfrin/NetBeansProjects/ProyectoFinalCompi1/src/backend/generacionHtml generacionDocumento.flex

echo "STARTING CUP COMPILING"
java -jar /home/jesfrin/Documentos/LibreriasJava/cup/java-cup-11b.jar generacionDocumento.cup 
mv parser.java /home/jesfrin/NetBeansProjects/ProyectoFinalCompi1/src/backend/generacionHtml/parser.java
mv sym.java /home/jesfrin/NetBeansProjects/ProyectoFinalCompi1/src/backend/generacionHtml/sym.java



