package com.carlos.web_proyecto1.EDD;

public class Cola {
    private Nodo primero;

    public Cola() {
    }

    public Cola(Nodo primero) {
        this.primero = primero;
    }
    
    public void agregar(Object obj, String tag) {
        Nodo nuevo = new Nodo(obj, tag);

        if (this.primero == null) {
            this.primero = nuevo;
        } else {
            Nodo tmp = this.primero;
            while (tmp.getSiguiente() != null) {
                tmp = tmp.getSiguiente();
            }
            tmp.setSiguiente(nuevo);
        }

    }

    public void agregar(Object obj) {
        Nodo nuevo = new Nodo(obj);

        if (this.primero == null) {
            this.primero = nuevo;
        } else {
            Nodo tmp = this.primero;
            while (tmp.getSiguiente() != null) {
                tmp = tmp.getSiguiente();
            }
            tmp.setSiguiente(nuevo);
        }
    }

    public Object sacar() {
        if (this.primero != null) {
            Nodo tmp = this.primero;
            this.primero = tmp.getSiguiente();
            return tmp.getContenido();
        } else {
            return null;
        }

    }

    public Object ver() {
        if (this.primero != null) {
            return this.primero.getContenido();
        } else {
            return null;
        }

    }

    public boolean isEmpty() {
        if (this.primero != null) {
            return false;
        } else {
            return true;
        }
    }

    public void imprimirCola() {
        if (this.primero != null) {
            System.out.println("---------------------");
            Nodo tmp = this.primero;
            do {
                System.out.println(tmp.getContenido());
                tmp = tmp.getSiguiente();
            } while (tmp != null);

            System.out.println("---------------------");
        }
    }

    public boolean buscarTag(String tag) {
        if (this.primero != null) {
            Nodo tmp = this.primero;
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
        return "Pila{" + "primero=" + ((primero==null)?"vacio":primero.getContenido().toString()) + '}';
    }
}
