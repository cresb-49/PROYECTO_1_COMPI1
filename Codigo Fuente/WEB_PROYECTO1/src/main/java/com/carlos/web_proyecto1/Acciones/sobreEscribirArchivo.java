package com.carlos.web_proyecto1.Acciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class sobreEscribirArchivo {

    public sobreEscribirArchivo() {
    }
    
    public void escritura(String path, String text){
        
        try(FileWriter fw = new FileWriter(path, false)) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
        } catch (Exception e) {
            System.out.println("Error en la escritura de archivos");
            e.printStackTrace();
        }
    }
}
