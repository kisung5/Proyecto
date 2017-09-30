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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.rootItem;

/**
 *
 * @author fundacionsos
 */
public class UpdateFrameController implements Initializable{
    private Stage stage;
    
    @FXML
    private Label mainLabel;
    
    @FXML
    private TextField nText;
    
    @FXML
    private TextField cText;
    
    @FXML
    private TextField eText;
    
    public void setStage(Stage stagePrincipal) {
        this.stage= stagePrincipal;
    }
    
    @FXML
    private void updateOut (ActionEvent event) {
        stage.close();
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

