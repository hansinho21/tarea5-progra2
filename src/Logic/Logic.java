/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.Cell;
import Domain.Order;
import Domain.Product;
import Domain.ProductsList;
import Domain.StateTable;
import Domain.Table;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
    
    private static ObservableList<ProductsList> productList;
    JsonFiles jsonFiles = new JsonFiles();
    
    public Logic() throws Exception{
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
//                cell[i][j].setIdTable(++i);
               
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
    public void changeScene(ActionEvent event, String destino) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(destino));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    private void fillMenu() throws Exception{
        for (int i = 0; i < jsonFiles.readProductsListJsonFile().size(); i++) {
            
            ArrayList<ProductsList> productsListArray = jsonFiles.readProductsListJsonFile();
            ProductsList tempProductsList = productsListArray.get(i);
            this.productList.add(tempProductsList);
        }
       
       
    }
    
    public ArrayList<String> getNameOfProducts(){
        ArrayList<String> auxList = new ArrayList<>();
        for (int i = 0; i < this.productList.size(); i++) {
            auxList.add(this.productList.get(i).getName());
        }
        return auxList;
    }
    
    public ProductsList searchProductByName(String name){
        ProductsList auxProduct = null;
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

    public ObservableList<ProductsList> getProductList() {
        return productList;
    }

    public void setProductList(ObservableList<ProductsList> productList) {
        this.productList = productList;
    }
    
    public String getDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedLocalDate = localDate.format(formatter);
        return formattedLocalDate;
    }
     public String getHour(){
         Date date = new Date();
         String hour = String.valueOf(date.getHours());
         return hour;
     }
    
    
}
