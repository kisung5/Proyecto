/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.frame;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.TextFieldTreeCell;
import static tec.datos1.proyecto1.db.frame.NewWindow.newWindow;
//import static tec.datos1.proyecto1.db.frame.NewDocController.getText;

/**
 *
 * @author fundacionsos
 */
public class MainMenu {
    public static class ShowMenu extends TextFieldTreeCell<String> {
        public static TreeItem root;
        MenuItem search;
        MenuItem update;
        MenuItem show;
        MenuItem deleteMenu;
        MenuItem childnewMenu;
                
        private final ContextMenu contextMenu = new ContextMenu();

        public ShowMenu(TreeItem<String> root) {
            this.root = root;
            
            search = new MenuItem("Buscar");
            update = new MenuItem("Actualizar");
            SeparatorMenuItem spacer1 = new SeparatorMenuItem();
            show = new MenuItem("Mostrar");
            childnewMenu = new MenuItem("Nuevo");
            SeparatorMenuItem spacer2 = new SeparatorMenuItem();

            deleteMenu = new MenuItem("Eliminar");
            
            contextMenu.getItems().addAll(search, update, spacer1,
                    childnewMenu, spacer2, deleteMenu);
        }
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setGraphic(null);
            } else if (getTreeItem().getParent() == root) {
                search.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event t) {
                            try {
                                newWindow("Search");
                            } catch (IOException ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                });
                update.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event t) {
                        try {
                            newWindow("Update");
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
                        try {       
                            newWindow("Add");
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        TreeItem newMenuItem = new TreeItem<String>("Nuevo");        
                        getTreeItem().getChildren().add(newMenuItem);
                    }
                });
                deleteMenu.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event t) {                                   
                        root.getChildren().removeAll(getTreeItem());          
                    }
                });
                setContextMenu(contextMenu);
            } else if (!empty && getTreeItem().getParent() == null) {
                search.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event t) {
                            try {
                                newWindow("Search");
                            } catch (IOException ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                });
                update.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event t) {
                        try {
                            newWindow("Update");
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
                        try {       
                            newWindow("NewDoc");
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
//                        TreeItem newMenuItem = new TreeItem<String>(getText());        
//                        root.getChildren().add(newMenuItem);
                    }
                });
                setContextMenu(contextMenu);
            } else if (getTreeItem().isLeaf() && getTreeItem().getParent().getParent() != null) {
                search.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event t) {
                            try {
                                newWindow("Search");
                            } catch (IOException ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                });

                update.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event t) {
                        try {
                            newWindow("Update");
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
                    }
                });
                setContextMenu(contextMenu);
            } else {
                return;
                
            }
        }
    }
}