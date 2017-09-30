/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.json;

import tec.datos1.proyecto1.db.data.List;
import static tec.datos1.proyecto1.db.data.ListFactory.getList;
import java.util.ArrayList;

/**
 *
 * @author fundacionsos
 */
public class PersonArray {
    private ArrayList<List<String>> arrayList = new ArrayList<>();
    
    public void setPerson(String id) {
        List<String> list = getList("simple");
        list.setIdentifier(id);
        arrayList.add(list);
    }
    
    public void setPerson(String id,String name, String num, String age) {
        for (List<String> pList : arrayList) {
            if(pList.getIdentifier() == id) {;  
                pList.addLast(name+"-"+age+"-"+num);
            }
        }
    }
    
    public ArrayList<String> getPerson(String id) {
        for (List<String> pList : arrayList) {
            if(pList.getIdentifier() == id) {
                return pList.print();
            }
        }
        return null;
    }
}
