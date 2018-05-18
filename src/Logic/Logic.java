/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.Cell;
import Domain.Product;
import java.io.IOException;
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
    
    
    public Logic(){
    }
    
    public GridPane createGridPane(int rows, int columns, Cell[][] cell) {
        GridPane newGridPane = new GridPane();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cell[i][j] = new Cell();
                cell[i][j].setRow(i);
                cell[i][j].setColumn(j);
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
    
}
