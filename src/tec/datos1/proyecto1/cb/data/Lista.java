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
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(new Nodo<T>(valor));
        }

    }

    public void imprimir() {
        Nodo<T> actual = this.primero;
        while (actual != null) {
            System.out.println(actual.getValor());
            actual = actual.getSiguiente();
        }		
    }

    public void insertarInicio(T valor) {
        if (this.primero == null) {
            this.primero = new Nodo<T>(valor);
        } else {
            Nodo<T> nuevo = new Nodo<T>(valor);
            nuevo.setSiguiente(this.primero);
            this.primero = nuevo;
        }
    }

    public Nodo<T> buscar(T buscado) {
        Nodo<T> actual = this.primero;
        while (actual != null) {
            if (actual.getValor().compareTo(buscado) == 0) {
                return actual;
            } else {
                actual = actual.getSiguiente();
            }
        }
        return null;
    }

    public Nodo<T> eliminar1(T buscado) {
        Nodo<T> actual = this.primero;
        
        if (actual.getValor() == buscado) {
            this.primero = actual.getSiguiente();
        }
        while (actual != null) {
            if (actual.getValor().compareTo(buscado) == 0) {
                
            } else {
                actual = actual.getSiguiente();
            }
        }
        return null;
    }
    
    public Nodo<T> eliminar(T buscado) {
        Nodo<T> actual = this.primero;
        
            if (actual.getValor().equals(buscado)) {
                this.primero = actual.getSiguiente();
            }
     
            else {
                while(actual.getSiguiente().getValor()!=buscado) 
                actual = actual.getSiguiente();  
            } 
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
        //size--;
        return actual;
    }
}    
