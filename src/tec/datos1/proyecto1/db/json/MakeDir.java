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

import java.io.File;
import java.nio.file.Paths;
//import java.io.IOException;

public class MakeDir {
    
    public static File path = Paths.get(".").toAbsolutePath().normalize().toFile();
    
    public static void makeDir(String name) {    
        File directory = new File(path + "\\LinkedBDdata\\" + name);
        if (directory.exists() && directory.isFile()) {
            System.out.println("Ya existe");
        }
        else {
            try {
                if (!directory.exists()) {
                directory.mkdir();
                }
                String username = System.getProperty("user.name");
                String filename = " path/" + username + ".txt"; //extension if you need one

            }
            catch (Exception e) {
            System.out.println("Error");
            }
        }
    }
    
    public static void eraseFile(String name) {
        File fi = new File(path + "\\LinkedDBdata\\" + name);
        
        if (!fi.exists()) {
            System.out.println("El archivo data no existe.");
        } else {
            for(File file : fi.listFiles() ) 
                if ( !file.isDirectory() ){ 
                    file.delete();
                }
            fi.delete();
            System.out.println("El archivo data fue eliminado.");
        }

    }
}