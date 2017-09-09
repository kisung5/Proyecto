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
public class ListaDoble<T extends Comparable<T>> {
    private Nodo<T> last;
    
    public ListaDoble() {
        this.last = null;
    }
    
    public boolean isEmpty() {
        return last == null;
    }
    
    public Nodo<T> searchback(T buscado) {
        Nodo<T> actual = this.last;
        while (actual != null) {
            if (actual.getValor().compareTo(buscado) == 0) {
                return actual;
            } else {
                actual = actual.getPrev();
            }
        }
        return null;
    }
    
    public void kickoutback(T buscado) {
        Nodo<T> actual = this.last;
        while (actual != null) {
            if (actual.getValor().compareTo( buscado) == 0) {
                this.last = actual.getPrev();
                return;
            } else if ()
        }
    }
    
}
