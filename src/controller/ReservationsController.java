/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Domain.Cell;
import Domain.Client;
import Domain.Reservation;
import Domain.Table;
import Logic.Logic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class ReservationsController implements Initializable {

    private Logic logic;
    private RestaurantController restaurantController;
    private int idTableSelected;
    private int rowTableSelected;
    private int columnTableSelected;
    private Cell[][] cell;
    
    @FXML
    private TextField textFielName;
    @FXML
    private TextField textFieldCellphone;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private DatePicker datePickerDate;
    @FXML
    private ComboBox comboBoxTime;
    @FXML
    private Button buttonConfirm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logic = new Logic();
        fillComboBox();
        comboBoxTime.setValue("Select an hour");
        
        this.restaurantController = new RestaurantController();
        this.idTableSelected = restaurantController.getIdTableSelected();
        this.rowTableSelected = restaurantController.getTableRow();
        this.columnTableSelected = restaurantController.getTableColumn();
        this.cell = restaurantController.getCell();
        
    }

    private void fillComboBox(){
        comboBoxTime.getItems().addAll("11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00",
                "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00");
    }

    @FXML
    private void backOnAction(ActionEvent event) throws IOException {
        logic.changeScene(event, "/gui/Restaurant.fxml");
    }

    @FXML
    private void confirmOnAction(ActionEvent event) throws IOException {
        Client newClient = new Client(textFielName.getText(), textFieldEmail.getText(), textFieldCellphone.getText());
        Reservation newReservation = new Reservation(newClient, new Table(), datePickerDate.getValue(), comboBoxTime.getValue().toString());
        this.cell[this.rowTableSelected][this.columnTableSelected].setImageView(new ImageView("/Images/mesaVerde.png"));
        this.restaurantController.setCell(cell);
        logic.changeScene(event, "/gui/Restaurant.fxml");
    }
    
}
