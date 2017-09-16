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

import com.google.gson.Gson;
/**
 *
 * @author fundacionsos
 */

//Esta funcion excribe
public class JsonConstructor {
    public void construir() {
        try
        {
            //Create a new Employee object
            Key key = new Key("String","Carlos","Persona","False","Personas");
            // El key es la clase Store creada
            //Set values to its properties

            // Create a new Gson object
            Gson gson = new Gson();

            //convert the Java object to json
            String jsonString = gson.toJson(key);
            //Write JSON String to file        
            FileWriter fileWriter = new FileWriter("C:\\DataLinkedDB\\json.txt");
            fileWriter.write(jsonString);
            fileWriter.close();
            
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    //Esta funcion lee.
    public void readJson() {
        try {
            //Create a new Gson object
            Gson gson = new Gson();

            //Read the employee.json file
            BufferedReader br = new BufferedReader( new FileReader("C:\\DataLinkedDB\\json.txt"));

            //convert the json to  Java object (Employee)
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


