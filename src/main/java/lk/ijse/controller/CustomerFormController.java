package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.bo.BOTypes;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.CustomerBo;

import lk.ijse.dto.CustomerDTO;

import lk.ijse.view.CustomerTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class CustomerFormController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> coltel;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TableView<CustomerTM> tblCustomer;



    CustomerBo customerBo = (CustomerBo) BoFactory.getBoFactory().getBo(BOTypes.Customer);



    public void initialize() {
        setCellValueFactory();
        loadAllCustomers();

    }
    private void loadAllCustomers() {
        ObservableList<CustomerTM> objList = FXCollections.observableArrayList();
        try {

            List<CustomerDTO> customerList = customerBo.getAllCustomer();
            for (CustomerDTO customer : customerList) {
                CustomerTM tm = new CustomerTM(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getCustomerPhone()
                );

                objList.add(tm);
            }
            tblCustomer.setItems(objList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setCellValueFactory() {
        colid.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        coltel.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));



    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtId.clear();
        txtName.clear();
        txtPhone.clear();
        txtAddress.clear();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(txtId.getText());



        try {
            customerBo.deleteCustomer(id);
            System.out.println("Customer deleted");
            loadAllCustomers();
        }
        catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Customer not deleted").show();
        }


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();

        CustomerDTO customer = new CustomerDTO(id, name, address, phone);

        try {
            boolean save = customerBo.saveCustomer(customer);
            if (save){
                System.out.println("Customer Save");
                loadAllCustomers();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        int id  = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();

        CustomerDTO customer = new CustomerDTO(id, name, address, phone);

        try {
            boolean b = customerBo.updateCustomer(customer);
            if (b){
                System.out.println("Customer Update");
                loadAllCustomers();
            }
        }catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnBackOnAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Customer Form");
        stage.setScene(scene);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.hide();

        stage.show();

    }
}
