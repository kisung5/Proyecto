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

public class ListaDoble<T extends Comparable<T>> implements List<T> {
    private Nodo<T> indicate;
    private int size;
    
    public ListaDoble() {
        this.indicate = null;
    }
    
    @Override
    public boolean isEmpty() {
        return indicate == null;
    }
    
    @Override
    public void addLast(T valor) {
        if (this.indicate == null) {
            this.indicate = new Nodo<>(valor);
            this.size++;
        } else {
            Nodo<T> actual = this.indicate;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(new Nodo<>(valor));
            actual.getNext().setPrev(actual);
            this.size++;
        }

    }

    @Override
    public T print() {
        Nodo<T> actual = this.indicate;
        while (actual != null) {
            System.out.println(actual.getValor());
            actual = actual.getNext();
        }
        return null;
    }

    @Override
    public void addFirst(T valor) {
        if (this.indicate == null) {
            this.indicate = new Nodo<>(valor);
            this.size++;
        } else {
            Nodo<T> nuevo = new Nodo<>(valor);
            nuevo.setNext(this.indicate);
            this.indicate = nuevo;
            this.size++;
        }
    }

    @Override
    public Nodo<T> search(T buscado) {
        Nodo<T> actual = this.indicate;
        while (actual != null) {
            if (actual.getValor() == buscado) {
//            if (actual.getValor().compareTo(buscado) == 0) {
                return actual;
            } else {
                actual = actual.getNext();
            }
        }
        return null;
    }

    @Override
    public void kickout(T buscado) {
        Nodo<T> actual = this.indicate;
        
        while (actual != null) {
            if (actual.getValor() == buscado) {
                this.indicate = actual.getNext();
                this.size--;
                return;
            } else if (actual.getNext().getValor() == buscado) {
//            } else if (actual.getNext().getValor().compareTo(buscado) == 0) {
                actual.setNext(actual.getNext().getNext());
                actual.getNext().setPrev(actual);
                this.size--;
                return;
            } else {
                actual = actual.getNext();
            }
        }
    }
    
    @Override
    public void insertPos(int pos, T valor) {
        Nodo<T> actual = this.indicate;
        int count = 0;
        while (count < size) {
            if (pos == 0) {
                Nodo<T> nuevo = new Nodo<>(valor);
                nuevo.setNext(this.indicate);
                this.indicate = nuevo;
                this.size++;
                return;
            } else if (count == (pos - 1)) {
                Nodo<T> nuevo = new Nodo<>(valor);
                nuevo.setNext(actual.getNext());
                actual.setNext(nuevo);
                actual.getNext().setPrev(actual);
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
        Nodo<T> actual = this.indicate;
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
        Nodo<T> actual = this.indicate;
        int count = 0;
        while (count < size) {
            if (pos == 0) {
                this.indicate = actual.getNext();
            } else if (count == (pos - 1)) {
                actual.setNext(actual.getNext().getNext());
                actual.getNext().setPrev(actual);
                this.size--;
                return;
            } else {
                actual = actual.getNext();
                count++;
            }            
        }
    }
    
}
