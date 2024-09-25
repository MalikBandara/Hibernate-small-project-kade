package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class OrderFormController {

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colItemID;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableView<?> tblOrder;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtItemID;

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {


//        int id  = Integer.parseInt(txtId.getText());
//        long date = Date.parse(txtDate.getText());
//        String customerId = txtCustomerID.getText();
//        String itemId = txtItemID.getText();







    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
