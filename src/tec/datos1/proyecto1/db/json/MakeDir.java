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
//import java.io.IOException;

public class MakeDir {
    public static void makeDir(String name) {
        File directory = new File("C:\\DataLinkedDB\\"+ name);
        if (directory.exists() && directory.isFile()) {
            System.out.println("The dir with name could not be" +
            " created as it is a normal file");
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
            System.out.println("prompt for error");
            }
        }
    }
    
    public static void eraseFile(String name) {
        File fi = new File("C:\\DataLinkedDB\\"+name);
        
        if (!fi.exists()) {
            System.out.println("El archivo data no existe.");
        } else {
            fi.delete();
            System.out.println("El archivo data fue eliminado.");
        }

    }
}