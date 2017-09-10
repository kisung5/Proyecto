/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.cb.data;

import java.util.ArrayList;

/**
 *
 * @author fundacionsos
 * @param <T>
 */
public interface List<T extends Comparable<T>> {
    boolean isEmpty();
    void addLast(T valor);
    void addFirst(T valor);
    Nodo<T> search(T buscado);
    void kickout(T buscado);
    void kickout(int pos);
    void insertPos(int pos, T valor);
    T print();
    Nodo<T> search(int pos);
    
    
}
