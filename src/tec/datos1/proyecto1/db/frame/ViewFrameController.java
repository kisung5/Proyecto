/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.frame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.util.Callback;
import tec.datos1.proyecto1.db.data.List;
import static tec.datos1.proyecto1.db.data.ListFactory.getList;
import static tec.datos1.proyecto1.db.frame.NewWindow.newWindow;
import tec.datos1.proyecto1.db.json.MetaData;
import tec.datos1.proyecto1.db.json.Person;
import tec.datos1.proyecto1.db.json.PersonArray;
import tec.datos1.proyecto1.db.json.SaveFiles;

/**
 *
 * @author fundacionsos
 */
public class ViewFrameController implements Initializable {
    
    public static List<String> jsons = getList("simple");
    public static List<String> documents = getList("double");
    public static List<String> garbage = getList("double");
    public static TreeItem<String> rootItem;
    private MetaData meta = new MetaData();
    public static PersonArray person = new PersonArray();
    public static ObservableList<Person> data = 
            FXCollections.observableArrayList();
        
    @FXML
    private Button commitButton;
    
    @FXML
    private Label label;
    
    @FXML 
    private TableView tableView;
    
    @FXML
    private TreeView<String> treeView;
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        SaveFiles save = new SaveFiles(documents,jsons,garbage);
        save.direct();
        label.setText("Guardado");
        commitButton.setDisable(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TableColumn c1;
        TableColumn c2;
        TableColumn c3;
        
        rootItem = new TreeItem<> ("Principal");
        rootItem.setExpanded(true);
        
        treeView.setRoot(rootItem);
        
        meta.getValues();
        c1 = new TableColumn(meta.getArrayA().get(0));
        c1.setMinWidth(200);
        c1.setCellValueFactory(new PropertyValueFactory<>("name"));

        c2 = new TableColumn(meta.getArrayA().get(1));
        c2.setMinWidth(200);
        c2.setCellValueFactory(new PropertyValueFactory<>("id"));

        c3 = new TableColumn(meta.getArrayA().get(2));       
        c3.setMinWidth(100);
        c3.setCellValueFactory(new PropertyValueFactory<>("age"));

        tableView.getColumns().addAll(c1 ,c2 ,c3);
        
        treeView.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            class ShowMenu extends TextFieldTreeCell<String> {
                MenuItem search;
                MenuItem update;
                MenuItem show;
                MenuItem deleteMenu;
                MenuItem childnewMenu;
                SeparatorMenuItem spacer1;
                SeparatorMenuItem spacer2;
                
                private ContextMenu contextMenu;

                public ShowMenu() {
                    
                    spacer1 = new SeparatorMenuItem();
                    spacer2 = new SeparatorMenuItem();
                    search = new MenuItem("Buscar");
                    update = new MenuItem("Actualizar");
                    show = new MenuItem("Mostrar");
                    childnewMenu = new MenuItem("Nuevo");
                    deleteMenu = new MenuItem("Eliminar");
                    
                }
                
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    
                    if (empty) {
                        setGraphic(null);
                    } else if (getTreeItem().getParent() == rootItem) {

                        contextMenu = new ContextMenu();
                        contextMenu.getItems().addAll(search, spacer1,
                        childnewMenu, show, spacer2, deleteMenu);
                      
                        search.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                newWindow("Search");
                            }
                        });
                        show.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                data.clear();
                                data.addAll(person.getPerson(rootItem.getChildren().indexOf(getTreeItem())));
                                tableView.setItems(data);

                            }
                        });
                        childnewMenu.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                newWindow("Add",getTreeItem());                           
                                commitButton.setDisable(false);
                            }
                        });
                        deleteMenu.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                garbage.addLast(getTreeItem().getValue());                               
                                rootItem.getChildren().removeAll(getTreeItem());
                                commitButton.setDisable(false);
                            }
                        });
                        setContextMenu(contextMenu);
                        
                    } else if (!empty && getTreeItem().getParent() == null) {
                        
                        contextMenu = new ContextMenu();                       
                        contextMenu.getItems().addAll(search, spacer1, spacer2, 
                                childnewMenu);
                        
                        search.setOnAction(new EventHandler() {
                                @Override
                                public void handle(Event t) {
                                    newWindow("Search");
                                }
                        });
                        childnewMenu.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {       
                                newWindow("NewDoc");
                                commitButton.setDisable(false);
                            }
                        });
                        setContextMenu(contextMenu);
                        
                    } else if (getTreeItem().isLeaf() && getTreeItem().getParent().getParent() != null) {
                        
                        contextMenu = new ContextMenu();            
                        contextMenu.getItems().addAll(update, spacer1, deleteMenu);

                        update.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                newWindow("Update");
//                                data.set(0, e);
                                commitButton.setDisable(false);
                            }
                        });
                        deleteMenu.setOnAction(new EventHandler() {
                            @Override                    
                            public void handle(Event t) {                                   
                                getTreeItem().getParent().getChildren().removeAll(getTreeItem());
                                commitButton.setDisable(false);
                            }
                        });
                        setContextMenu(contextMenu);
                    } else {
                        return;
                    }
                }
            }
            @Override
            public TreeCell<String> call(TreeView<String> arg0) {
                return new ShowMenu();
            }
        });
    }
}
