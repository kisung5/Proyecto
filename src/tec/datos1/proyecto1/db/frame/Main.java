/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.frame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import tec.datos1.proyecto1.db.data.List;
//import static tec.datos1.proyecto1.db.data.ListFactory.getList;
//import tec.datos1.proyecto1.db.data.Nodo;
//import tec.datos1.proyecto1.db.json.JsonConstructor;
//import tec.datos1.proyecto1.db.json.Key;
//import tec.datos1.proyecto1.db.json.KeyCon;
//import static tec.datos1.proyecto1.db.json.MakeDir.makeDir;

/**
 *
 * @author fundacionsos
 * 
 */

public class Main extends Application {
    
    public static Stage stage;
    private AnchorPane rootPane;
    private TreeView tree;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("ViewFrame.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Linked DB by Kisung Lim");
        
        stage.setScene(scene);
        stage.show();
    }
    

    /**
     * @param args the command line arguments
     * El metodo main que lanza los args de la interfaz.
     */
    
    public static void main(String[] args) {
        launch(args);
//        System.out.println(System.getProperty("user.dir"));
//        KeyCon keycon = new KeyCon();
//        Key key = new Key("String","Juan","","false","Casas");
//        System.out.println(keycon.storeToString(key));
//        List<String> lista = getList("simple");
//        lista.addLast(keycon.storeToString(key));
//        lista.print();
//        Nodo<String> nodo = lista.search(0);
//        String[] array = nodo.getValor().split("-", 0);
//        System.out.println(array[1]);
//        makeDir(array[4]);
//        JsonConstructor construir = new JsonConstructor();
//        construir.construir(key, array[4],array[1]);
//        
    }
}
