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

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.File;
import java.util.ArrayList;

public class MetaData {
    private File meta = new File(System.getProperty("user.dir")+ 
            "\\LinkedBDdata\\","metadata.txt");
    private Gson gson = new Gson();
    
    private ArrayList<String> arrayA = new ArrayList<>();
    private ArrayList<String> arrayT = new ArrayList<>();
    
    public ArrayList<String> getArrayA() {
        return arrayA;
    }

    public ArrayList<String> getArrayT() {
        return arrayT;
    }
    
    public void getValues () {
        try {
            BufferedReader br = new BufferedReader( new FileReader(meta));
            String jsonline = br.readLine();
            JsonElement jelement = new JsonParser().parse(jsonline);

            for (int i=1; i<4; i++) {
                JsonElement c = jelement.getAsJsonObject().get("c"+Integer.toString(i));
                String atr = c.getAsJsonObject().get("atr").getAsString();
                String type = c.getAsJsonObject().get("type").getAsString();
                arrayA.add(atr);
                arrayT.add(type);
            }          
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
}
