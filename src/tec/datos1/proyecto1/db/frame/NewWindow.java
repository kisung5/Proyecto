/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.frame;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author fundacionsos
 */
public class NewWindow {
    
    public static TreeItem item;
    
    @SuppressWarnings("UseSpecificCatch")
    public static void newWindow(String name) {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(name+".fxml"));
        AnchorPane form = null;
        try {
            form = (AnchorPane) loader.load();
        } catch (IOException ex) {
            Logger.getLogger(NewWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage window = new Stage();
        window.setTitle(name);
        window.initOwner(Main.stage);
        Scene scene = new Scene(form);
        window.setScene(scene);
        window.setResizable(false);                                            
        window.initModality(Modality.WINDOW_MODAL);
        //init no deja usar la ventana principal sin cerrar esta
            
        if (name.compareTo("Add") == 0) {
            AddFrameController controller = loader.getController();
            controller.setStage(window);
            window.show();
        } else if (name.compareTo("Search") == 0) {
            SearchFrameController controller = loader.getController();
            controller.setStage(window);
            window.show();
        } else if (name.compareTo("Update") == 0) {
            UpdateFrameController controller = loader.getController();
            controller.setStage(window);
            window.show();
        } else if (name.compareTo("NewDoc") == 0) {
            NewDocController controller = loader.getController();
            controller.setStage(window);
            window.show();
        } else {
            return;
        }
    }
    
    public static void newWindow(String name, TreeItem item) {
        NewWindow.item = item;
       
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(name+".fxml"));
        AnchorPane form = null;
        try {
            form = (AnchorPane) loader.load();
        } catch (IOException ex) {
            Logger.getLogger(NewWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage window = new Stage();
        window.setTitle(name);
        window.initOwner(Main.stage);
        Scene scene = new Scene(form);
        window.setScene(scene);
        window.setResizable(false);                                            
        window.initModality(Modality.WINDOW_MODAL);
        //init no deja usar la ventana principal sin cerrar esta
        
        AddFrameController controller = loader.getController();
        controller.setStage(window);
        window.show();
    }
}
