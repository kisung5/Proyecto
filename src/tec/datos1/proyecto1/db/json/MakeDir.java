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

public class MakeDir {
    public static File directory;
    
    public static void makeDir(String name) {
        directory = new File( System.getProperty("user.dir")
                + "\\LinkedBDdata\\"+ name +"\\");
        
        if (directory.exists() && directory.isFile()) {
            System.out.println("Ya existe");
        }
        else {
            try {
                if (!directory.exists()) {
                    if (directory.mkdir()) {
                        System.out.println("Listo");
                    } else {
                        System.out.println("No Listo");
                    }
                }
            }
            catch (Exception e) {
            System.out.println("Error");
            }
        }
    }
    
    public static void eraseFile(String name) {
        File fi = new File(System.getProperty("user.dir")
                + "\\LinkedBDdata\\" + name);
        
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