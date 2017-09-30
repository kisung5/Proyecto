/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.frame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.data;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.person;
import static tec.datos1.proyecto1.db.frame.ViewFrameController.rootItem;
import tec.datos1.proyecto1.db.json.Person;

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
    private TableView tableV;
    
    @FXML
    private TextField searchText;
    
    @FXML
    private void searchOut(ActionEvent event) {
        stage.close();
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//        TableColumn c1 = new TableColumn("Nombre");
//        c1.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//        TableColumn c2 = new TableColumn();
//        c2.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn c3 = new TableColumn();       
//        c3.setCellValueFactory(new PropertyValueFactory<>("age"));
//
//        tableV.getColumns().addAll(c1 ,c2 ,c3);
//        data.addAll(person.getPerson(rootItem.getChildren().indexOf(0)));
//        tableV.setItems(data);
//
//        FilteredList<Person> filteredData = new FilteredList<>(data, s -> true);
//
//        searchText.textProperty().addListener((obs, oldValue, newValue)->{
//            String filter = searchText.getText(); 
//            if(filter == null || filter.length() == 0) {
//                filteredData.setPredicate(s -> true);
//            }
//            else {
//                filteredData.setPredicate(s -> {
//                    String lowerCaseFilter = newValue.toLowerCase();
//
//                    if (s.getName().toString().contains(lowerCaseFilter)) {
//                        return true; // Filter matches Carne
//                    
//                    }
//                    return false; // Does not match.
//                }
//                );
//            }
//        });
//        SortedList<Person> sortedData = new SortedList<>(filteredData);
//
//        sortedData.comparatorProperty().bind(tableV.comparatorProperty());
//
//        tableV.setItems(sortedData);
    }    
}
