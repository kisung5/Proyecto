/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.datos1.proyecto1.db.json;

/**
 *
 * @author fundacionsos
 */


public class Key {
    
    private String valor;
    private String defecto;
    private String requerido;
    private String fileName;
    
    public Key() {
        super();
    }
    
    public Key(String v, String d, String r, String s) {
        super();
        this.valor = v;
        this.defecto = d;
        this.requerido = r;
        this.fileName = s;
    }
    
    public String getDefecto() {
        return defecto;
    }

    public void setDefecto(String defecto) {
        this.defecto = defecto;
    }

    public String getRequerido() {
        return requerido;
    }

    public void setRequerido(String requerido) {
        this.requerido = requerido;
    }

    public String getStoreName() {
        return fileName;
    }

    public void setStoreName(String fileName) {
        this.fileName = fileName;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    
}
