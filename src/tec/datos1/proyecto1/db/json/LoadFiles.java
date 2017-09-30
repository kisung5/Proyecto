/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.json;

import java.io.File;
import javafx.scene.control.TreeItem;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.documents;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.rootItem;
import tec.datos1.proyecto1.db.json.JsonConstructor;

/**
 *
 * @author fundacionsos
 */
public class LoadFiles {
    private JsonConstructor constructor = new JsonConstructor();
    
    private File directory = new File(System.getProperty("user.dir") 
            + "\\LinkedBDdata\\");
       
    public void load () {
        int count =0;
        for (File files: directory.listFiles()) {
            if (files.isDirectory()) {
                documents.addLast(files.getName());
                TreeItem<String> item = new TreeItem<>(files.getName());
                rootItem.getChildren().add(item);
                
                for (File doc : files.listFiles()) {
                    constructor.readJson(doc, count);
                }               
                count++;
            }
        }   
    }
}
