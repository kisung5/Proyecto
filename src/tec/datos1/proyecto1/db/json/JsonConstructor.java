/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.json;

import com.google.gson.JsonIOException;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import static tec.datos1.proyecto1.db.json.MakeDir.path;
import com.google.gson.Gson;
/**
 *
 * @author fundacionsos
 */

//Esta funcion excribe
public class JsonConstructor {
    public void construir(Key key, String name) {
        try
        {     
            Gson gson = new Gson();

            //convert the Java object to json
            String jsonString = gson.toJson(key);
            //Write JSON String to file        
            FileWriter fileWriter = new FileWriter(path + "\\LinkedDBdata\\"+ name);
            fileWriter.write(jsonString);
            fileWriter.close();
            
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    //Esta funcion lee.
    public void readJson(String name) {
        try {
            //Create a new Gson object
            Gson gson = new Gson();

            BufferedReader br = new BufferedReader( new FileReader(path + "\\LinkedDBdata\\"+ name));

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


