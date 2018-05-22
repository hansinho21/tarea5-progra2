/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Domain.Cell;
import Domain.Order;
import Domain.StateTable;
import Logic.JsonFiles;
import Logic.Logic;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class RestaurantController implements Initializable {

    private Logic logic;
    private JsonFiles jsonFiles;
    private static Cell[][] cell;
    private static int rows;
    private static int columns;
    private static GridPane gridPaneTables;
    private static int idTableSelected;
    private static int tableRow;
    private static int tableColumn;
    private static int cont;

    @FXML
    private AnchorPane anchorPaneTables;
    @FXML
    private Label idTable;
    @FXML
    private Button buttonOrder;
    @FXML
    private Button buttonAssign;
    @FXML
    private Button buttonReserve;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            this.logic = new Logic();
            this.jsonFiles = new JsonFiles();
            createGridPane();
            x();
            this.buttonOrder.setDisable(true);

            buttonOrder.setDisable(true);
            buttonAssign.setDisable(true);
            buttonReserve.setDisable(true);
        } catch (Exception ex) {
            Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createGridPane() throws Exception {
        this.rows = 5;
        this.columns = 5;
        this.cell = new Cell[this.rows][this.columns];
        this.gridPaneTables = new GridPane();

        this.gridPaneTables = this.logic.createGridPane(this.rows, this.columns, this.cell);

        this.anchorPaneTables = this.logic.addGridPaneToAnchorPane(this.anchorPaneTables, this.gridPaneTables);
//        ArrayList document = jsonFiles.readRestaurantJsonFile();
//        
//        for (int i = 0; i < document.size(); i++) {
//            System.out.println(document.get(i).toString());
//        }
//
//        String id = document.get(1).toString();
//        String x = document.get(2).toString();
//        ArrayList y = (ArrayList) document.get(3);
//
//        this.anchorPaneTables.getChildren().clear();
//        this.cell = new Cell[this.rows][this.columns];
//
//        //Crea el GridPane
//        this.gridPaneTables = this.logic.createGridPane(this.rows, this.columns, this.cell);
//
//        //Añade el GridPane al AnchorPane
//        this.anchorPaneTables = this.logic.addGridPaneToAnchorPane(this.anchorPaneTables, this.gridPaneTables);
//
//        int cont = 0;
//        for (int i = 0; i < this.rows; i++) {
//            for (int j = 0; j < this.columns; j++) {
//                if (!url2.get(cont).equals("")) {
//                    this.cell[i][j].getChildren().add(new ImageView(url2.get(cont).toString()));
//                    this.cell[i][j].setUrl(url2.get(cont).toString());
//                }
//                cont++;
//            }
//        }
    }

    public void setIdTable(int id, int row, int column) {
        this.idTableSelected = id;
        this.tableRow = row;
        this.tableColumn = column;
    }

    public int getIdTableSelected() {
        return this.idTableSelected;
    }

    private void x() {
        this.gridPaneTables.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                idTable.setText("Mesa #" + idTableSelected);
                if (cell[tableRow][tableColumn].getTable().getID() == idTableSelected
                        && cell[tableRow][tableColumn].getTable().getStatus().equals(StateTable.LIBRE)) {
                    buttonOrder.setDisable(true);
                    buttonAssign.setDisable(false);
                    buttonReserve.setDisable(false);
                } else if (cell[tableRow][tableColumn].getTable().getID() == idTableSelected
                        && cell[tableRow][tableColumn].getTable().getStatus().equals(StateTable.OCUPADA)) {
                    buttonOrder.setDisable(false);
                    buttonAssign.setDisable(true);
                    buttonReserve.setDisable(true);
                } else if (cell[tableRow][tableColumn].getTable().getID() == idTableSelected
                        && cell[tableRow][tableColumn].getTable().getStatus().equals(StateTable.RESERVADA)) {
                    buttonOrder.setDisable(false);
                    buttonAssign.setDisable(true);
                    buttonReserve.setDisable(true);
                }
            }
        });
    }

    @FXML
    private void reserveOnAction(ActionEvent event) throws IOException {

        logic.changeScene(event, "/gui/Reservations.fxml");

    }

    @FXML
    private void orderOnAction(ActionEvent event) throws IOException {
        if (this.cell[this.tableRow][this.tableColumn].getTable().getOrder() == null) {
            logic.changeScene(event, "/gui/Order.fxml");
        } else {
            JOptionPane.showMessageDialog(null, "Esta mesa ya tiene una orden asignada");
        }
    }

    @FXML
    private void assignATableOnAction(ActionEvent event) {
        if (this.cell[this.tableRow][this.tableColumn].getTable().getID() == this.idTableSelected) {
            this.cell[this.tableRow][this.tableColumn].setImageView(new ImageView("/Images/mesaRoja.png"));
            this.cell[this.tableRow][this.tableColumn].getTable().setStatus(StateTable.OCUPADA);
            this.idTable.setText("");
        } else if (this.cell[this.tableRow][this.tableColumn].getTable().getOrder() != null) {
            JOptionPane.showMessageDialog(null, "La mesa ya tiene una orden");
        }
    }

    public static int getTableRow() {
        return tableRow;
    }

    public static void setTableRow(int tableRow) {
        RestaurantController.tableRow = tableRow;
    }

    public static int getTableColumn() {
        return tableColumn;
    }

    public static void setTableColumn(int tableColumn) {
        RestaurantController.tableColumn = tableColumn;
    }

    public Cell[][] getCell() {
        return cell;
    }

    public void setCell(Cell[][] cell) {
        this.cell = cell;
    }

    public void setOrderTable(Order order) {
        System.out.println(this.cell[this.tableRow][this.tableColumn].getTable().getID());

    }

}
