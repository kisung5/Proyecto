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
import static tec.datos1.proyecto1.db.json.MakeDir.makeDir;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fundacionsos
 */

//Esta funcion excribe
public class JsonConstructor {
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
    
    //Esta funcion lee.
    public void readJson(String name) {
        try {
            //Create a new Gson object
            Gson gson = new Gson();

            BufferedReader br = new BufferedReader( new FileReader(directory + name));

            Key key = gson.fromJson(br, Key.class);

            //Printing the Employee Details
//            System.out.println("****Employee Details****");
//            System.out.println("Employee Name    : "+key.;
//            System.out.println("Employee ID      : "+key.getAtributo());
//            System.out.print("Employee Department: "+key.getValor());
//            for(String department : key.getStoreName())
//            {
//                System.out.print(department+" | ");
//            }
            }
            catch (IOException e) 
            {  
                e.printStackTrace();  
            }
    }
}


