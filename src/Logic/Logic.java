/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.Cell;
import Domain.Product;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author fabian
 */
public class Logic {
    
    private static ObservableList<Product> productList;
    
    public Logic(){
        this.productList = FXCollections.observableArrayList();
        if(productList.isEmpty()){
            fillMenu();
        }
    }
    
    public GridPane createGridPane(int rows, int columns, Cell[][] cell) {
        GridPane newGridPane = new GridPane();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cell[i][j] = new Cell();
                cell[i][j].setRow(i);
                cell[i][j].setColumn(j);
//                cell[i][j].getTable().setID(++i);
                newGridPane.add(cell[i][j], j, i);
            }
        }
        newGridPane.setStyle("-fx-cursor : hand");
        return newGridPane;
    }
    
    /**
     * Añade un GridPane a un AnchorPane.
     * @param anchorPane
     * @param gridPane
     * @return Retorna el AnchorPane con el GridPane.
     */
    public AnchorPane addGridPaneToAnchorPane(AnchorPane anchorPane, GridPane gridPane) {
        anchorPane.setPrefHeight(gridPane.getPrefHeight());
        anchorPane.setPrefWidth(gridPane.getPrefWidth());
        anchorPane.getChildren().add(gridPane);

        return anchorPane;
    }
    
    /**
     * Metodo para cambiar de scene
     * @param event
     * @param destino
     * @throws IOException 
     */
    public void changeScene(ActionEvent event, String destino) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(destino));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    private void fillMenu(){
        this.productList.add(new Product("Pollo", 10, 1));
        this.productList.add(new Product("Arroz", 11, 1));
        this.productList.add(new Product("Frijoles", 12, 1));
        this.productList.add(new Product("Carne", 15, 1));
        this.productList.add(new Product("Hamburguesa", 20, 1));
        this.productList.add(new Product("Papas fritas", 8, 1));
        this.productList.add(new Product("Fresco de naranja", 7, 1));
        this.productList.add(new Product("Fresco de limón", 7, 1));
        this.productList.add(new Product("Fresco de melón", 7, 1));
    }
    
    public ArrayList<String> getNameOfProducts(){
        ArrayList<String> auxList = new ArrayList<>();
        for (int i = 0; i < this.productList.size(); i++) {
            auxList.add(this.productList.get(i).getName());
        }
        return auxList;
    }
    
    public Product searchProductByName(String name){
        Product auxProduct = null;
        for (int i = 0; i < this.productList.size(); i++) {
            if(this.productList.get(i).getName().equals(name)){
                auxProduct = this.productList.get(i);
            }
        }
        return auxProduct;
    }
    
    public double getProductPrice(String name){
        for (int i = 0; i < this.productList.size(); i++) {
            if(this.productList.get(i).getName().equals(name)){
                return this.productList.get(i).getPrice();
            }
        }
        return -1;
    }
    
    public boolean isProduct(String name){
        for (int i = 0; i < this.productList.size(); i++) {
            if(this.productList.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public ObservableList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ObservableList<Product> productList) {
        this.productList = productList;
    }
    
}
