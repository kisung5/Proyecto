/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.frame;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


//import static javax.swing.UIManager.getString;
//import tec.datos1.proyecto1.db.data.List;
import tec.datos1.proyecto1.db.json.Key;
//import static tec.datos1.proyecto1.db.data.ListFactory.getList;
//import tec.datos1.proyecto1.db.json.JsonConstructor;
import tec.datos1.proyecto1.db.json.KeyCon;
//import static tec.datos1.proyecto1.db.json.MakeDir.makeDir;
//import static tec.datos1.proyecto1.db.json.MakeDir.eraseFile;

/**
 *
 * @author fundacionsos
 */

public class Main extends Application {
    
    public static Stage stage;
    private AnchorPane rootPane;
    
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
     */
    public static void main(String[] args) {
//        Key key = new Key("int","hola","0","true","Store1");
//        KeyCon keycon = new KeyCon();
//        System.out.println(keycon.storeToString(key));
//        System.out.println(keycon.validar(key));
//        String username = System.getProperty("user.name");
//        String filename = " path/" + username + ".txt"; //extension if you need one
//        System.out.println(filename);
        
//        lista.addLast(hola);
//        lista.addLast(quetal);
//        lista.print();
//        List<Integer> lista2 = getList("circle");
//        lista2.addLast(6);
//        lista2.addLast(10);
//        lista2.print();
        
    launch(args);
    }
}
