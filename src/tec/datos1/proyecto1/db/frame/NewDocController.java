/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.frame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import static tec.datos1.proyecto1.db.frame.MainMenu.ShowMenu.root;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.documents;
        
/**
 *
 * @author fundacionsos
 */
public class NewDocController implements Initializable {

    private Stage stage;
    
    @FXML
    private TextField textDoc;

    public void setStage(Stage stagePrincipal) {
        this.stage= stagePrincipal;
    }
    
    @FXML
    private void newdocOut(ActionEvent event) {
        stage.close();
        if (textDoc.getText() != "") {
            
            TreeItem<String> nchild = new TreeItem<> (textDoc.getText());
            documents.addLast(textDoc.getText());
            root.getChildren().add(nchild);
//            ViewFrameController hola = null;
//            hola.active(false);
        } else {
            return;
        }
//        commitButton.setDisable(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
} 

