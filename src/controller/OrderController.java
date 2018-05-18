/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Domain.Product;
import Logic.Logic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class OrderController implements Initializable {

    private Logic logic;
    private static ObservableList productList;

    @FXML
    private TableView<?> tableViewOrder;
    @FXML
    private Label jLabelSubtotal;
    @FXML
    private Label jLabelIva;
    @FXML
    private Label jLabelTotal;
    @FXML
    private TextField textFieldProduct;
    @FXML
    private TableColumn tableColumnProduct;
    @FXML
    private TableColumn tableColumnQuantity;
    @FXML
    private TableColumn tableColumnPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logic = new Logic();
        productList = FXCollections.observableArrayList();
        initialiceTableView();
    }

    private void initialiceTableView() {
        tableColumnProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        tableColumnQuantity.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));
        tableColumnPrice.setCellValueFactory(new PropertyValueFactory<Product, String>("quantity"));
        
        tableViewOrder.setItems(productList);
    }

    @FXML
    private void backOnAction(ActionEvent event) throws IOException {
        logic.changeScene(event, "/gui/Restaurant.fxml");
    }

    @FXML
    private void addOnAction(ActionEvent event) {
        productList.add(new Product(textFieldProduct.getText(), "a", 1));|
    }

}
