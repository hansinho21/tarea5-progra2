/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Logic.Logic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class ReservationsController implements Initializable {

    private Logic logic;
    
    @FXML
    private TextField textFielName;
    @FXML
    private TextField textFieldCellphone;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private DatePicker datePickerDate;
    @FXML
    private ComboBox<?> comboBoxTime;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logic = new Logic();
    }    

    @FXML
    private void backOnAction(ActionEvent event) throws IOException {
        logic.changeScene(event, "/gui/Restaurant.fxml");
    }
    
}
