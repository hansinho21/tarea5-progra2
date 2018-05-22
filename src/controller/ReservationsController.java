/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Domain.Cell;
import Domain.Client;
import Domain.Reservation;
import Domain.StateTable;
import Domain.Table;
import Logic.Logic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    @FXML
    private Button buttonBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            logic = new Logic();
            fillComboBox();
            comboBoxTime.setValue("Select an hour");
            
            this.datePickerDate.setEditable(false);

            this.restaurantController = new RestaurantController();
            this.idTableSelected = restaurantController.getIdTableSelected();
            this.rowTableSelected = restaurantController.getTableRow();
            this.columnTableSelected = restaurantController.getTableColumn();
            this.cell = restaurantController.getCell();
        } catch (Exception ex) {
            Logger.getLogger(ReservationsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void fillComboBox() {
        comboBoxTime.getItems().addAll("11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00",
                "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00");
    }

    @FXML
    private void backOnAction(ActionEvent event) throws IOException {
        // get a handle to the stage
        Stage stage = (Stage) buttonBack.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    private void confirmOnAction(ActionEvent event) throws IOException {
        if (verifyInformation() == true) {
            Client newClient = new Client(textFielName.getText(), textFieldEmail.getText(), textFieldCellphone.getText());
            Reservation newReservation = new Reservation(newClient, new Table(), datePickerDate.getValue(), comboBoxTime.getValue().toString());
            this.cell[this.rowTableSelected][this.columnTableSelected].setImageView(new ImageView("/Images/mesaVerde.png"));
            this.restaurantController.setCell(cell);
            this.cell[this.rowTableSelected][this.columnTableSelected].getTable().setStatus(StateTable.RESERVADA);

        }
        // get a handle to the stage
        Stage stage = (Stage) buttonConfirm.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    private boolean verifyInformation() {
        if (textFielName.getText().equals("")
                || textFieldCellphone.getText().equals("")
                || textFieldEmail.getText().equals("")
                || datePickerDate.getValue() == null
                || comboBoxTime.getValue().equals("Select an hour")) {
            JOptionPane.showMessageDialog(null, "Complete todos los espacios");
            return false;
        } else {
            return true;
        }
    }

}
