/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import java.util.Observable;
import javafx.collections.ObservableList;

/**
 *
 * @author fabian
 */
public class Order {
    private int ID;
    private ObservableList<Product> products;
    private String time;

    public Order() {
    }

    public Order(ObservableList<Product> list, String time) {
        this.time = time;
        this.products = list;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ObservableList<Product> getProducts() {
        return products;
    }

    public void setProducts(ObservableList<Product> products) {
        this.products = products;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}


