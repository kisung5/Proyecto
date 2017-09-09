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
    private Nodo<T> siguiente;
    private T valor;
    
    public Nodo(T valor) {
        this.valor = valor;
        siguiente = null;
    }

    public Nodo(T valor, Nodo<T> siguiente) {
        this(valor);
        this.siguiente = siguiente;
    }

    public Nodo<T> getNext() {
        return siguiente;
    }

    public void setNext(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}


