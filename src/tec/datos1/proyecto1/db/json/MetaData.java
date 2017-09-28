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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.File;
import java.util.ArrayList;

public class MetaData {
    private File meta = new File(System.getProperty("user.dir")+ 
            "\\LinkedBDdata\\","metaData.txt");
    private Gson gson = new Gson();
    
    public void getValues () {
        try {
            BufferedReader br = new BufferedReader( new FileReader(meta));
            String jsonline = br.readLine();
            System.out.println(jsonline);
            JsonElement jelement = new JsonParser().parse(jsonline);

            for (int i=1; i<4; i++) {
                JsonElement c = jelement.getAsJsonObject().get("c"+Integer.toString(i));
                String atr = c.getAsJsonObject().get("atr").getAsString();
                String type = c.getAsJsonObject().get("type").getAsString();
                System.out.println(atr);
                System.out.println(type);
                System.out.println("");
            }          
        } catch (IOException e) {
            
        }
    }
}
