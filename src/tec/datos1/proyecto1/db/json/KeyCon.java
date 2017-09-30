/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.json;

/**
 *
 * @author fundacionsos
 */
public class KeyCon {

    public Key stringToStore(String value) {
        //String = valor-defecto-requiered-storename
        String[] array = value.split("-", 0);
        
        return new Key(array[0], array[1], array[2], array[3]);
    }
    
    public String storeToString(Key key) {
        String formatter = "";
        
        formatter += key.getValor();
        formatter += ("-"+key.getDefecto());
        formatter += ("-"+key.getRequerido());
        formatter += ("-"+key.getStoreName());
        
        return formatter;
    }       
}
