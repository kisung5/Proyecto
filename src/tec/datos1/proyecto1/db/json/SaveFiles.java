/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.json;

import java.io.File;
import tec.datos1.proyecto1.db.data.List;
import static tec.datos1.proyecto1.db.json.MakeDir.eraseFile;
import static tec.datos1.proyecto1.db.json.MakeDir.makeDir;
import tec.datos1.proyecto1.db.json.JsonConstructor;
import tec.datos1.proyecto1.db.json.KeyCon;

/**
 *
 * @author fundacionsos
 */
public class SaveFiles {
    private JsonConstructor constructor = new JsonConstructor();
    private KeyCon keycon = new KeyCon();
    
    private List<String> documents;
    private List<String> objects;
    private List<String> garbage;
    private List<Integer> keygar;
    
    public SaveFiles(List<String> documents) {
        this.documents = documents;
        this.objects = null;
        this.garbage = null;
    }
    
    public SaveFiles(List<String> documents,List<String> objects) {
        this.documents = documents;
        this.objects = objects;
        this.garbage = null;
    }
    
    public SaveFiles(List<String> documents,List<String> objects, 
            List<String> garbage, List<Integer> keygar) {
        this.documents = documents;
        this.objects = objects;
        this.garbage = garbage;
        this.keygar = keygar;
    }
    
    public void direct() {
        for (String valor : documents.print()) {
            makeDir(valor);
        }
        for (String valor : garbage.print()) {
            eraseFile(valor);
        }
        
        int count = 0;
        for (String valor : objects.print()) {
            Key key = keycon.stringToStore(valor);
            constructor.construir(key, key.getStoreName(), key.getStoreName()+
                    "."+Integer.toString(count));
            count++;
        }
        
        File directory = new File(System.getProperty("user.dir") 
            + "\\LinkedBDdata\\");
        
            for (int num : keygar.print()) {
                for (File file: directory.listFiles() ) {
                    if (file.isDirectory()) {
                        for (File arch : file.listFiles()) {
                            if (arch.getName() == (file.getName()+"."+Integer.toString(num))) {
                                System.out.println(arch.getName());
                                System.out.println(file.getName()+"."+Integer.toString(num));
                                arch.delete();
                            }
                        }
                    }
                }
            }
        
    }
}
