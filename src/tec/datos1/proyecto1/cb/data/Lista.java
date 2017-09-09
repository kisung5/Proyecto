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

import java.util.ArrayList;

public class Lista<T extends Comparable<T>> implements List<T>{
    private Nodo<T> first;
    private ArrayList<T> array;

    public Lista() {
        this.first = null;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void addLast(T valor) {
        if (this.first == null) {
            this.first = new Nodo<>(valor);
        } else {
            Nodo<T> actual = this.first;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(new Nodo<>(valor));
        }

    }

    @Override
    public ArrayList printList() {
        Nodo<T> actual = this.first;
        while (actual != null) {
            array.add(actual.getValor());
            actual = actual.getNext();
        }
        return array;
    }

    @Override
    public void addFirst(T valor) {
        if (this.first == null) {
            this.first = new Nodo<>(valor);
        } else {
            Nodo<T> nuevo = new Nodo<>(valor);
            nuevo.setNext(this.first);
            this.first = nuevo;
        }
    }

    @Override
    public Nodo<T> search(T buscado) {
        Nodo<T> actual = this.first;
        int pos = 0;
        while (actual != null) {
            if (actual.getValor().compareTo(buscado) == 0) {
                return actual;
            } else {
                actual = actual.getNext();
                pos++;
            }
        }
        return null;
    }

    @Override
    public void kickout(T buscado) {
        Nodo<T> actual = this.first;
        
        while (actual != null) {
            if (actual.getValor() == buscado) {
                this.first = actual.getNext();
                return;
            } else if (actual.getNext().getValor().compareTo(buscado) == 0) {
                actual.setNext(actual.getNext().getNext());
                return;
            } else {
                actual = actual.getNext();
            }
        }
    }
    
    @Override
    public void insertPos(int pos) {
        Nodo<T> actual = this.first;
        int count = 0;
        while (count != pos) {
            
        }
    }
    
    @Override
    public Nodo<T> searchPos(int pos) {
        Nodo<T> actual = this.first;
        while (actual != null) {
            if (actual.getValor().compareTo(buscado) == 0) {
                return actual;
            } else {
                actual = actual.getNext();
            }
        }
        return null;
    }

}  