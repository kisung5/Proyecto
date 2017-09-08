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
import tec.datos1.proyecto1.cb.data.Lista;

/**
 *
 * @author fundacionsos
 */
public class Proyecto_DatosI_Kisung_Lim extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ViewFrame.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista<String> lista = new Lista<String>();
        lista.insertarFinal("Kisung");
        lista.insertarFinal("141000013808");
        lista.insertarFinal("estudiante");
        lista.imprimir();
        System.out.println("");
        lista.eliminar("141000013808");
        lista.imprimir();
//        launch(args);
         
    }
    
}
