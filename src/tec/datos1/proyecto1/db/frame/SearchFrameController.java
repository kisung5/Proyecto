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

/**
 *
 * @author fundacionsos
 */
public class SearchFrameController implements Initializable{
    private Stage stage;
    
    public void setStage(Stage stagePrincipal) {
        this.stage= stagePrincipal;
    }
    
    @FXML
    private void salirVentana(ActionEvent event) {
        stage.close();
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
