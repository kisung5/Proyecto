/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.frame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ContextMenu;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
/**
 *
 * @author fundacionsos
 */
public class ViewFrameController implements Initializable {
    
    @FXML
    private Label label;
    private ContextMenu menu;
    private NewWindow n = new NewWindow();
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        n.newWindow("Add");
        label.setText("Hello World!");
    }
    
    @FXML
    private void contextHandleMenu() {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
