/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tac.datos1.proyecto1.db.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import java.io.IOException; 
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author fundacionsos
 */
public class JsonConstructor {
    public void prueba() {
        Constructor emp = new Constructor(1, "Lokesh Gupta", 34, "India");
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            String json = mapper.writeValueAsString(emp);
            System.out.println(json);
 
//            Use pretty print for printing the output
            String beutifulJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
            System.out.println(beutifulJson);
 
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) { 
            e.printStackTrace();
        }
    }
}

