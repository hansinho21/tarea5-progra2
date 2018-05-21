/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import controller.RestaurantController;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author hvill
 */
public class Cell extends Pane {

    private ImageView imageView;
    private int row;
    private int column;
    private String url;
    private Table table;
    private RestaurantController restaurantController;
    private static int idTable;

    public Cell() {
        setStyle("-fx-border-color : black");
        this.setPrefSize(100, 100);
        this.setOnMouseClicked(e -> handleClick());
        this.url = "";
        this.table = new Table();
        this.restaurantController = new RestaurantController();
        this.getChildren().add(new ImageView("/Images/mesaGris.png"));
        
        updateIdTable();
    }
    
    public void updateIdTable(){
        if(idTable <=24){
            this.table.setID(++idTable);
        } else {
            idTable = 1;
            this.table.setID(idTable);
        }
    }

    /**
     * Se ejecuta cuando se da click en una celda.
     */
    public void handleClick() {
        this.restaurantController.setTextIdTable(getTable().getID());
        System.out.println(getTable().getID());
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

}
