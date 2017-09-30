/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.data;

import java.util.ArrayList;

/**
 *
 * @author fundacionsos
 * @param <T>
 * El generico tipo T sirve para implementar una lista enlazda de T objetos.
 */

public class Lista<T extends Comparable<T>> implements List<T>{
    private Nodo<T> first;
    private int size;
    private String identifier;

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    public Lista() {
        this.first = null;
    }
    /**
     * 
     * @return
     * Retorna true o false si la lista esta vacia.
     */
    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
    /**
     * 
     * @param valor
     * Parametro con el que se agrega un elemento a la lista tipo T.
     */
    @Override
    public void addLast(T valor) {
        if (this.first == null) {
            this.first = new Nodo<>(valor);
            this.size++;
        } else {
            Nodo<T> actual = this.first;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(new Nodo<>(valor));
            this.size++;
        }
    }
    /**
     * 
     * @param valor
     * Recibe un valor tipo T y lo agrega al inicio de la lista enlazada.
     */
    @Override
    public void addFirst(T valor) {
        if (this.first == null) {
            this.first = new Nodo<>(valor);
            this.size++;
        } else {
            Nodo<T> nuevo = new Nodo<>(valor);
            nuevo.setNext(this.first);
            this.first = nuevo;
            this.size++;
        }
    }
    /**
     * 
     * @return 
     * Devuelve los objetos de la lista.
     */
    @Override
    public ArrayList<T> print() {
        Nodo<T> actual = this.first;
        ArrayList<T> array = new ArrayList<>();
        
        while (actual != null) {
            array.add(actual.getValor());
            actual = actual.getNext();
        }
        return array;
    }
    /**
     * 
     * @param buscado
     * Recibe un valor T buscado en la lista enlazada.
     * @return
     * Devuelve el nodo con el que se encuentra.
     */
    @Override
    public Nodo<T> search(T buscado) {
        Nodo<T> actual = this.first;
        int pos = 0;
        while (actual != null) {
            if (actual.getValor() == buscado) {
//            if (actual.getValor().compareTo(buscado) == 0) {
                return actual;
            } else {
                actual = actual.getNext();
                pos++;
            }
        }
        return null;
    }
    /**
     * 
     * @param buscado 
     * Recibe un buscado tipo T y lo elimina de la lista.
     */
    @Override
    public void kickout(T buscado) {
        Nodo<T> actual = this.first;
        
        while (actual != null) {
            if (actual.getValor() == buscado) {
                this.first = actual.getNext();
                this.size--;
                return;
            } else if (actual.getNext().getValor() == buscado) {
//            } else if (actual.getNext().getValor().compareTo(buscado) == 0) {
                actual.setNext(actual.getNext().getNext());
                this.size--;
                return;
            } else {
                actual = actual.getNext();
            }
        }
    }
    /**
     * 
     * @param pos
     * Recibe un parametro entero pos para buscar en la lista enlazada e 
     * insertar en esa posicion.
     * @param valor 
     * El valor a ingresar en la pos.
     */
    @Override
    public void insertPos(int pos, T valor) {
        Nodo<T> actual = this.first;
        int count = 0;
        while (count < size) {
            if (pos == 0) {
                Nodo<T> nuevo = new Nodo<>(valor);
                nuevo.setNext(this.first);
                this.first = nuevo;
                this.size++;
                return;
            } else if (count == (pos - 1)) {
                Nodo<T> nuevo = new Nodo<>(valor);
                nuevo.setNext(actual.getNext());
                actual.setNext(nuevo);
                this.size++;
                return;
            } else {
                actual = actual.getNext();
                count++;
            }            
        }
        
    }
    /**
     * 
     * @param pos
     * El parametro pos busca en Nodo T con ese indice.
     * @return
     * Da el nodo de la poscion seleccionada.
     */
    @Override
    public Nodo<T> search(int pos) {
        Nodo<T> actual = this.first;
        int count = 0;
        while (count < size) {
            if (count == pos) {
                return actual;
            } else {
                actual = actual.getNext();
                count++;
            }
        }
        return null;
    }
    /**
     * 
     * @param pos 
     * Elimina el Nodo T de la lista con la int pos, este pos es el indice.
     */
    @Override
    public void kickout(int pos) {
        Nodo<T> actual = this.first;
        int count = 0;
        while (count < size) {
            if (pos == 0) {
                this.first = actual.getNext();
                return; 
            } else if (count == (pos - 1)) {
                actual.setNext(actual.getNext().getNext());
                this.size--;
                return;
            } else {
                actual = actual.getNext();
                count++;
            }            
        }
    }

}  