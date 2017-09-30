/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.json;

import java.util.ArrayList;

/**
 *
 * @author fundacionsos
 */
public class PersonArray {
    ArrayList<ArrayList> elements = new ArrayList<>();
    
    public void setPerson() {
        ArrayList<Person> nArray = new ArrayList<>();      
        elements.add(nArray);
    }
    
    public void setPerson(int id,String name, String num, String age) {
        ArrayList<Person> temp= elements.get(id);
        temp.add(new Person(name,num,age));
    }
    
    public ArrayList<Person> getPerson(int id) {
        return elements.get(id);
    }
}
