/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.frame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.rootItem;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.documents;
import javafx.scene.control.Alert;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.person;

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
        if (textDoc.getText() == null || textDoc.getText().trim().isEmpty()) {
            Platform.runLater(new Runnable() {
                public void run() {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("No se pueden crear documentos en blanco.");
                    alert.showAndWait();
                }
            });
        } else {
            TreeItem<String> nchild = new TreeItem<> (textDoc.getText());
            documents.addLast(textDoc.getText());
            rootItem.getChildren().add(nchild);
            person.setPerson(textDoc.getText());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
} 

