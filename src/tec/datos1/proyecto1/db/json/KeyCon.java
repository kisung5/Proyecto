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
    private Boolean flag = true;
    public Boolean validar(Key key){ //todo REVISAR RETURN
        try{
            switch(key.getAtributo()){
                case "int": Integer.parseInt(key.getValor());
                return flag;

                case "float": Float.parseFloat(key.getValor());
                return flag;
            }

        }catch(Exception e){
            return false;
        }
        return flag;
    }

    public Key stringToStore(String value) {
        //String = atributo-valor-defecto-requiered-storename
        String[] array = value.split("-", 0);
        
        return new Key(array[0], array[1], array[2], array[3], array[4]);
    }
    
    public String storeToString(Key key) {
        String formatter = "";
        
        formatter += key.getValor();
        formatter += ("-"+key.getAtributo());
        formatter += ("-"+key.getDefecto());
        formatter += ("-"+key.getRequerido());
        formatter += ("-"+key.getStoreName());
        
        return formatter;
    }
    
    
}
