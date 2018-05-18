/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Domain.Cell;
import Logic.Logic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class RestaurantController implements Initializable {

    private Logic logic;
    private Cell[][] cell;
    private int rows;
    private int columns;
    private GridPane gridPaneTables;
    private static String tableSelected;
    
    @FXML
    private AnchorPane anchorPaneTables;
    @FXML
    private Label idTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.logic = new Logic();
        createGridPane();
    }

    public void createGridPane() {
        this.rows = 5;
        this.columns = 5;
        this.cell = new Cell[this.rows][this.columns];
        this.gridPaneTables = new GridPane();
        
        this.gridPaneTables = this.logic.createGridPane(this.rows, this.columns, this.cell);
        
        this.anchorPaneTables = this.logic.addGridPaneToAnchorPane(this.anchorPaneTables, this.gridPaneTables);
    }
    
    public void setTextIdTable(int id){
        tableSelected = "Mesa #" + id;
        idTable.setText(tableSelected);
    }

    @FXML
    private void reserveOnAction(ActionEvent event) throws IOException {
        logic.changeScene(event, "/gui/Reservations.fxml");
    }

    @FXML
    private void orderOnAction(ActionEvent event) throws IOException {
        logic.changeScene(event, "/gui/Order.fxml");
    }

}
