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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.util.Callback;
import tec.datos1.proyecto1.db.data.List;
import tec.datos1.proyecto1.db.frame.MainMenu.ShowMenu;
import static tec.datos1.proyecto1.db.data.ListFactory.getList;

/**
 *
 * @author fundacionsos
 */
public class ViewFrameController implements Initializable {
    
    public static List<String> jsons = getList("simple");
    public static List<String> documents = getList("double");
    public TreeItem<String> rootItem;
    
//    @FXML
//    private Button commitButton;
//    
    @FXML
    private Label label;
    
    @FXML
    private TreeView<String> treeView;
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootItem = new TreeItem<> ("Principal");
        rootItem.setExpanded(true);

        treeView.setRoot(rootItem);
        
        treeView.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            @Override
            public TreeCell<String> call(TreeView<String> arg0) {
                return new ShowMenu(rootItem);
            }
        });
    }
    
//    public void active(Boolean flag) {
//        commitButton.setDisable(flag);
//    }
}
