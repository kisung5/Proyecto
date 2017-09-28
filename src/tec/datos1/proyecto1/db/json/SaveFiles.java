/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.json;

import tec.datos1.proyecto1.db.data.List;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.documents;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.garbage;
import static tec.datos1.proyecto1.db.json.MakeDir.eraseFile;
import static tec.datos1.proyecto1.db.json.MakeDir.makeDir;

/**
 *
 * @author fundacionsos
 */
public class SaveFiles {
    private List<String> documents;
    private List<String> objects;
    private List<String> garbage;
    
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
    
    public SaveFiles(List<String> documents,List<String> objects, List<String> garbage) {
        this.documents = documents;
        this.objects = objects;
        this.garbage = garbage;
    }
    
    public void direct() {
        for (String valor : documents.print()) {
            makeDir(valor);
        }
        for (String valor : garbage.print()) {
            eraseFile(valor);
        }
    }
}
