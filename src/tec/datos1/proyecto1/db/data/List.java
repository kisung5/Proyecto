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
 * El parametro T es un generico para la inteefaz list, contiene los metodos 
 * para las clases Lista.
 */

public interface List<T extends Comparable<T>> {
    /**
     * 
     * @return
     * Retorna boolean. 
     */
    boolean isEmpty();
    /**
     * 
     * @param valor
     * Recibe un valor T.
     */
    void addLast(T valor);
    /**
     * 
     * @param valor
     * Recibe un valor T.
     */
    void addFirst(T valor);
    /**
     * 
     * @param buscado
     * Recibe un valor T.
     * @return
     * Retorna un Nodo T.
     */
    Nodo<T> search(T buscado);
    /**
     * 
     * @param buscado
     * Recibe un valor T.
     */
    void kickout(T buscado);
    /**
     * 
     * @param pos
     * Recibe un int posicion.
     */
    void kickout(int pos);
    /**
     * 
     * @param pos
     * Recibe un int posicion.
     * @param valor 
     * Recibe un valor T.
     */
    void insertPos(int pos, T valor);
    /**
     * 
     * @return
     * Retorna los valores en memoria.
     */
    T print();
    /**
     * 
     * @param pos
     * Recibe un int posicion.
     * @return
     * Retorna un Nodo T.
     */
    Nodo<T> search(int pos);   
}
