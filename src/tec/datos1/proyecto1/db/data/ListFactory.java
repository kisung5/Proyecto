/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.data;

/**
 *
 * @author fundacionsos
 */
public class ListFactory {

    public static List getList(String type) {
        if("single".equals(type)) {
            return new Lista<>();
        } else if("double".equals(type)) {
            return new ListaDoble<>();
        } else if("circle".equals(type)) {
            return new ListaCircularDoble<>();
        } else {
            return null;
        }
    }

    
}
