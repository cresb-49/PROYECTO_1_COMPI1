/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.app_cliente_proyecto1;

import com.carlos.app_cliente_proyecto1.UI.PrincipalFrame;
import com.carlos.app_cliente_proyecto1.HttpMethods.peticionLogin;

/**
 *
 * @author benjamin
 */
public class main {
    public static void main(String[] args) {
        //PrincipalFrame principal = new PrincipalFrame();
        /*peticionLogin log = new peticionLogin();
        try {
            String res = log.peticionHttpGet("https://jsonplaceholder.typicode.com/todos/1");
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        
        
        String dato = "\"12345\"";
        
        System.out.println(dato);
        
        String dato2 = dato.substring(1, dato.length()-1);
        
        System.out.println(dato2);
    }
}
