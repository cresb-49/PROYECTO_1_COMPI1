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
            this.sima = nuevo;
            nuevo.setSiguiente(tmp);
        }

    }

    public void push(Object obj) {
        Nodo nuevo = new Nodo(obj);

        if (this.sima == null) {
            this.sima = nuevo;
        } else {
            Nodo tmp = this.sima;
            this.sima = nuevo;
            nuevo.setSiguiente(tmp);
        }
    }

    public Object pop() {
        if (this.sima != null) {
            Nodo tmp = this.sima;
            this.sima = tmp.getSiguiente();
            return tmp.getContenido();
        } else {
            return null;
        }

    }

    public Object peek() {
        if (this.sima != null) {
            return this.sima.getContenido();
        } else {
            return null;
        }

    }

    public boolean isEmpty() {
        if (this.sima != null) {
            return false;
        } else {
            return true;
        }
    }

    public void imprimirPila() {
        if (this.sima != null) {
            System.out.println("---------------------");
            Nodo tmp = this.sima;
            do {
                System.out.println(tmp.getContenido());
                tmp = tmp.getSiguiente();
            } while (tmp != null);

            System.out.println("---------------------");
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
            } while (tmp != null);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pila{" + "sima=" + ((sima==null)?"vacio":sima.getContenido().toString()) + '}';
    }
    
}
