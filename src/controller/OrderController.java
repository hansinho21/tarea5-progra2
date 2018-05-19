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
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class OrderController implements Initializable {

    private Logic logic;
    private static ObservableList<Product> productList;
    private ObservableList<Product> orderList;
    private double subtotal;
    private double iva;
    private double total;
    private int quantity;

    @FXML
    private TableView tableViewOrder;
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
    @FXML
    private Label labelQuantity;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logic = new Logic();
        productList = logic.getProductList();
        orderList = FXCollections.observableArrayList();
        
        this.subtotal = this.iva = this.total = 0;
        this.quantity = 1;
        
        TextFields.bindAutoCompletion(textFieldProduct, logic.getNameOfProducts());
        initialiceTableView();
    }
    
    private void calculatePrice(Product product){
        this.subtotal +=  product.getPrice() * this.quantity;
        this.iva += (product.getPrice() * 10 / 100) * this.quantity;
        this.total = this.subtotal + this.iva;
        
        jLabelSubtotal.setText(String.valueOf(this.subtotal));
        jLabelIva.setText(String.valueOf(this.iva));
        jLabelTotal.setText(String.valueOf(this.total));
    }

    private void initialiceTableView() {
        tableColumnProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        tableColumnQuantity.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));
        tableColumnPrice.setCellValueFactory(new PropertyValueFactory<Product, String>("quantity"));
        
        tableViewOrder.setItems(orderList);
    }

    @FXML
    private void backOnAction(ActionEvent event) throws IOException {
        logic.changeScene(event, "/gui/Restaurant.fxml");
    }

    @FXML
    private void addOnAction(ActionEvent event) {
        Product auxProduct = new Product(textFieldProduct.getText(), logic.getProductPrice(textFieldProduct.getText()), this.quantity);
        auxProduct.setPrice(auxProduct.getPrice()*this.quantity);
        if(logic.isProduct(textFieldProduct.getText())){
            orderList.add(auxProduct);
            calculatePrice(auxProduct);
        }
        textFieldProduct.setText("");
        this.quantity = 1;
        labelQuantity.setText(String.valueOf(this.quantity));
    }

    @FXML
    private void reduceQuantityOnAction(ActionEvent event) {
        if(this.quantity > 1){
            this.quantity--;
            labelQuantity.setText(String.valueOf(this.quantity));
        }
    }

    @FXML
    private void increaseQuantityOnAction(ActionEvent event) {
        this.quantity++;
        labelQuantity.setText(String.valueOf(this.quantity));
    }

}
