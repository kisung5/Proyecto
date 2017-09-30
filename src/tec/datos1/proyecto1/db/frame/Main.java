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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
//        TreeItem<String> item = new TreeItem();
//        TreeItem<String> n = new TreeItem();
//        TreeItem<String> i = new TreeItem();
//        item.getChildren().addAll(n,i);
//        System.out.println(item.getChildren().indexOf(i));
        launch(args);
    }
}
