package com.carlos.web_proyecto1.EDD;

public class Pila {

    private Nodo sima;

    public Pila() {
    }

    public Pila(Nodo sima) {
        this.sima = sima;
    }

    public void push(Object obj, String tag) {
        Nodo nuevo = new Nodo(obj, tag);

        if (this.sima == null) {
            this.sima = nuevo;
        } else {
            Nodo tmp = this.sima;
            while (tmp.getSiguiente() != null) {
                tmp = tmp.getSiguiente();
            }
            tmp.setSiguiente(nuevo);
        }

    }
    
    public void push(Object obj) {
        Nodo nuevo = new Nodo(obj);
        
        if (this.sima == null) {
            this.sima = nuevo;
        } else {
            Nodo tmp = this.sima;
            while (tmp.getSiguiente() != null) {
                tmp = tmp.getSiguiente();
            }
            tmp.setSiguiente(nuevo);
        }
    }

    public Object pop() {
        Nodo tmp = this.sima;
        if (tmp != null) {
            this.sima = tmp.getSiguiente();
        }
        return tmp;
    }

    public Object peek() {
        if(this.sima!=null){
            return this.sima.getContenido();
        }else{
            return null;
        }
        
    }
    
    public boolean isEmpty(){
        if(this.sima!=null){
            return false;
        }else{
            return true;
        }
    }

    public boolean buscarTag(String tag) {
        if (this.sima != null) {
            Nodo tmp = this.sima;
            do {
                if (tmp.getTag().equals(tag)) {
                    return true;
                }
                tmp = tmp.getSiguiente();
            } while (tmp!= null);
        }
        return false;
    }

}
