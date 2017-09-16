/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.data;

/**
 *
 * @author fundacionsos
 * @param <T>
 */

public class ListaCircularDoble<T extends Comparable <T>> implements List<T> {
    private Nodo<T> last;
    private int size;
    
    public ListaCircularDoble(){
        last = null;
    }
    
    @Override
    public boolean isEmpty() {
        return this.last == null;
    }

    @Override
    public void addLast(T valor) {
        if (this.last == null) {
            this.last = new Nodo<>(valor);
            this.last.setNext(last);
            this.last.setPrev(last);
            this.size++;
        } else {
            Nodo<T> actual = new Nodo<>(valor);
            actual.setNext(last.getNext());
            actual.setPrev(last);
            actual.getNext().setPrev(actual);
            this.last.setNext(actual);
            last = last.getNext();
            this.size++;
        }

    }

    @Override
    public T print() {
        Nodo<T> actual = this.last;
        if (this.last != null) {
            System.out.println(actual.getValor());
        }
        while (actual.getNext().getValor() != last.getValor()) {
            System.out.println(actual.getValor());
            actual = actual.getNext();
        }
        return null;
    }

    @Override
    public void addFirst(T valor) {
        if (this.last == null) {
            this.last = new Nodo<>(valor);
            this.last.setNext(last);
            this.last.setPrev(last);
            this.size++;
        } else {
            Nodo<T> nuevo = new Nodo<>(valor);
            nuevo.setPrev(last);
            last.setNext(nuevo);
            this.size++;
        }
    }

    @Override
    public Nodo<T> search(T buscado) {
        Nodo<T> actual = this.last;
        while (actual.getNext().getValor() != last.getValor()) {
            if (actual.getValor().compareTo(buscado) == 0) {
                return actual;
            } else {
                actual = actual.getNext();
            }
        }
        return actual;
    }

    @Override
    public void kickout(T buscado) {
        Nodo<T> actual = this.last;
        
        while (actual.getNext().getValor() != last.getValor()) {
            if (actual.getNext().getValor().compareTo(buscado) == 0) {
                actual.setNext(actual.getNext().getNext());
                actual.getNext().setPrev(actual);
                this.size--;
                return;
            } else {
                actual = actual.getNext();
                actual.getNext().setPrev(actual);
            }
        }
    }
    
    @Override
    public void insertPos(int pos, T valor) {
        Nodo<T> actual = this.last;
        int count = 0;
        while (count < size) {
            if (pos == 0) {
                Nodo<T> nuevo = new Nodo<>(valor);
                nuevo.setNext(last.getNext());
                last.setNext(nuevo);
                this.last = last.getNext();
                this.size++;
                return;
            } else if (count == (pos - 1)) {
                Nodo<T> nuevo = new Nodo<>(valor);
                nuevo.setNext(last.getNext());
                last.setNext(nuevo);
                this.last = last.getNext();
                this.size++;
                return;
            } else {
                actual = actual.getNext();
                count++;
            }            
        }
        
    }
    
    @Override
    public Nodo<T> search(int pos) {
        Nodo<T> actual = this.last;
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
    
    @Override
    public void kickout(int pos) {
        Nodo<T> actual = this.last;
        int count = 0;
        while (count < size) {
            if (count == (pos - 1)) {
                actual.setNext(actual.getNext().getNext());
                actual.getNext().setPrev(actual);
                this.size--;
                return;
            } else {
                actual = actual.getNext();
                actual.getNext().setPrev(actual);
                count++;
            }            
        }
    }
    
}
