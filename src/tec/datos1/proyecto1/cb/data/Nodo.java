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


public class Nodo<T extends Comparable<T>> {
    private Nodo<T> next;
    private Nodo<T> prev;
    private T valor;
    
    public Nodo(T valor) {
        this.valor = valor;
        next = null;
        prev = null;
    }

    public Nodo(T valor, Nodo<T> next) {
        this(valor);
        this.next = next;
    }
    
    public Nodo(Nodo<T> prev, T valor, Nodo<T> next) {
        this(valor);
        this.next = next;
        this.prev = prev;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
    
    public Nodo<T> getPrev() {
        return prev;
    }
    
    public void setPrev(Nodo<T> prev) {
        this.prev = prev;
    }
}


