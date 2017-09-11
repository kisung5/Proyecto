/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tac.datos1.proyecto1.db.json;

/**
 *
 * @author fundacionsos
 */

public class Constructor {
    private Integer id;
    private String name;
    private Integer age;
    private String location;
     
    public Constructor(Integer id, String name, Integer age, String location) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.location = location;
    }
 
    //Setters and Getters will be added here
 
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age
                + ", location=" + location + "]";
    }
}

