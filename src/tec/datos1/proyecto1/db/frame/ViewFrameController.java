/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.frame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
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
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.util.Callback;
import tec.datos1.proyecto1.db.data.List;
import static tec.datos1.proyecto1.db.data.ListFactory.getList;
import static tec.datos1.proyecto1.db.frame.NewWindow.newWindow;
import static tec.datos1.proyecto1.db.json.MakeDir.makeDir;

/**
 *
 * @author fundacionsos
 */
public class ViewFrameController implements Initializable {
    
    public static List<String> jsons = getList("simple");
    public static List<String> documents = getList("double");
    public static List<String> garbage = getList("double");
    public static TreeItem<String> rootItem;
    
    @FXML
    private Button commitButton;
    
    @FXML
    private Label label;
    
    @FXML
    private TreeView<String> treeView;
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        for (String valor : documents.print()) {
            makeDir(valor);
        }
        label.setText("Guardado");
        commitButton.setDisable(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootItem = new TreeItem<> ("Principal");
        rootItem.setExpanded(true);

        treeView.setRoot(rootItem);
        
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
                        childnewMenu, show, spacer2, update, deleteMenu);
                      
                        search.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                newWindow("Search");
                            }
                        });
                        update.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                newWindow("Update");
                                commitButton.setDisable(false);
                            }
                        });
                        show.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
        //                        table.setItems(list);
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
                        contextMenu.getItems().addAll(update, spacer1,
                        childnewMenu,show, spacer2, deleteMenu);

                        update.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                newWindow("Update");
                                commitButton.setDisable(false);
                            }
                        });
                        show.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
        //                        table.setItems(list);
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
