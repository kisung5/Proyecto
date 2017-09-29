/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.json;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author fundacionsos
 */
public class Person {
        private final SimpleStringProperty name;
        private final SimpleStringProperty id;
        private final SimpleStringProperty age;
 
        public Person(String name, String id, String age) {
            this.name = new SimpleStringProperty(name);
            this.id = new SimpleStringProperty(id);
            this.age = new SimpleStringProperty(age);
        }
 
        public String getName() {
            return name.get();
        }
 
        public void setName(String name) {
            this.name.set(name);
        }
 
        public String getId() {
            return id.get();
        }
 
        public void setId(String id) {
            this.id.set(id);
        }
 
        public String getAge() {
            return age.get();
        }
 
        public void setAge(String age) {
            this.age.set(age);
        }
}

