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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.stage.Stage;
import static tec.datos1.proyecto1.db.frame.NewWindow.item;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.person;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.jsons;
import tec.datos1.proyecto1.db.json.Person;
import com.google.gson.Gson;
import tec.datos1.proyecto1.db.json.Key;
import tec.datos1.proyecto1.db.json.KeyCon;

/**
 *
 * @author fundacionsos
 */
public class AddFrameController implements Initializable{
    
    private Gson gson = new Gson();
    private KeyCon keycon = new KeyCon();
    private Stage stage;
    private Boolean flag = false;
    
    @FXML
    private TextField nameText;
    
    @FXML
    private TextField idText;
    
    @FXML
    private TextField ageText;
    
    @FXML 
    private Label labelTitle;
    
    public void setStage(Stage stagePrincipal) {
        this.stage= stagePrincipal;
    }
    
    @FXML
    private void requiredAction(){
        this.flag = true;
    }
    
    @FXML
    private void addOut(ActionEvent event) {
        stage.close();
        if ((nameText.getText() == null || nameText.getText().trim().isEmpty()) 
                && (idText.getText() == null) || idText.getText().trim().isEmpty()) {
        Platform.runLater(new Runnable() {
            public void run() {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("No se pueden dejar esos espacios en blanco.");
                alert.showAndWait();
                }
            });
        } else {
        
        Person p = new Person(nameText.getText(),idText.getText(), ageText.getText());
        String jsonString = gson.toJson(p);
        Key key = new Key(jsonString,"","false",item.getValue().toString()); 
        jsons.addLast(keycon.storeToString(key));
        
        TreeItem<String> nchild = new TreeItem<> (nameText.getText());
        item.getChildren().add(nchild);
        person.setPerson(item.getParent().getChildren().lastIndexOf(item), nameText.getText(), 
                idText.getText(), ageText.getText());
        }
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelTitle.setText(item.getValue().toString());
    }    
}

