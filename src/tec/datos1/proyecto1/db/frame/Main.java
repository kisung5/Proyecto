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
import javafx.stage.Stage;

/**
 *
 * @author fundacionsos
 * 
 */

public class Main extends Application {
    
    public static Stage stage;  
    
    
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
    }
}
