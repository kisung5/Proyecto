/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.cb.data;

/**
 *
 * @author fundacionsos
 * @param <T>
 */


public class Lista<T extends Comparable<T>> {
    private Nodo<T> primero;

    public Lista() {
        this.primero = null;
    }

    public boolean isEmpty() {
        return this.primero == null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    public void insertarFinal(T valor) {
        if (this.primero == null) {
            this.primero = new Nodo<T>(valor);
        } else {
            Nodo<T> actual = this.primero;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(new Nodo<T>(valor));
        }

    }

    public void imprimir() {
        Nodo<T> actual = this.primero;
        while (actual != null) {
            System.out.println(actual.getValor());
            actual = actual.getNext();
        }		
    }

    public void insertarInicio(T valor) {
        if (this.primero == null) {
            this.primero = new Nodo<T>(valor);
        } else {
            Nodo<T> nuevo = new Nodo<T>(valor);
            nuevo.setNext(this.primero);
            this.primero = nuevo;
        }
    }

    public Nodo<T> buscar(T buscado) {
        Nodo<T> actual = this.primero;
        while (actual != null) {
            if (actual.getValor().compareTo(buscado) == 0) {
                return actual;
            } else {
                actual = actual.getNext();
            }
        }
        return null;
    }

    public Nodo<T> eliminar(T buscado) {
        Nodo<T> actual = this.primero;
        
        if (actual.getValor() == buscado) {
            this.primero = actual.getNext();
        }
        while (actual != null) {
            if (actual.getNext().getValor().compareTo(buscado) == 0) {
                actual.setNext(actual.getNext().getNext());
                return null;
            } else {
                actual = actual.getNext();
            }
        }
        return null;
    }
    
//    public Nodo<T> eliminar(T buscado) {
//        Nodo<T> actual = this.primero;
//        
//            if (actual.getValor().equals(buscado)) {
//                this.primero = actual.getNext();
//            }
//     
//            else {
//                while(actual.getNext().getValor()!=buscado) 
//                actual = actual.getNext();  
//            } 
//            actual.setNext(actual.getNext().getNext());
//        //size--;
//        return actual;
//    }
}    
