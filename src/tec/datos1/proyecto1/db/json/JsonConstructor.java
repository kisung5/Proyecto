/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.json;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import static tec.datos1.proyecto1.db.json.MakeDir.directory;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.jsons;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TreeItem;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.person;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.rootItem;

/**
 *
 * @author fundacionsos
 */

public class JsonConstructor {
    
    private KeyCon keycon = new KeyCon();
    
    public void construir(Key key, String dir, String name) {
        Gson gson = new Gson();      
        File file = new File(directory, name + ".txt");
        String jsonString = gson.toJson(key);
        
        try {
            if (file.exists()) {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
                bufferedWriter.write(jsonString);
                bufferedWriter.close();
            }
            else {
                if (file.createNewFile()) {
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(jsonString);
                    fileWriter.close();
                } else {
                    System.out.println("Error");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(JsonConstructor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void readJson(File name, int id) {
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader( new FileReader(name));

            Key key = gson.fromJson(br, Key.class);
            jsons.addLast(keycon.storeToString(key));
            
            Person personOb = gson.fromJson(key.getValor(), Person.class);
            person.setPerson();
            person.setPerson(id, personOb.getName(), personOb.getId(), 
                    personOb.getAge());
            
            TreeItem<String> nitem = new TreeItem<>(personOb.getName());
            rootItem.getChildren().get(id).getChildren().add(nitem);
            
            }
            catch (IOException e) 
            {  
                e.printStackTrace();  
            }
    }
}


