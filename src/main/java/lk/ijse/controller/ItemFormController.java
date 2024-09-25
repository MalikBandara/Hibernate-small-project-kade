package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.bo.BOTypes;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.impl.ItemBo;
import lk.ijse.dto.ItemDTO;
import lk.ijse.view.ItemTM;

import java.io.IOException;
import java.util.List;

public class ItemFormController {

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colprice;

    @FXML
    private TableColumn<?, ?> colqty;

    @FXML
    private TableView<ItemTM> tblItem;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQTY;

    ItemBo itemBo = (ItemBo) BoFactory.getBoFactory().getBo(BOTypes.Item);
    @FXML

    public void initialize() {
        setCellValueFactory();
        loadAllItems();

    }

    private void setCellValueFactory(){
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }
    private void loadAllItems(){
        ObservableList<ItemTM> objects = FXCollections.observableArrayList();
        try {
            List<ItemDTO> ItemList = itemBo.getAllItems();
            for (ItemDTO item : ItemList) {
                ItemTM tm = new ItemTM(
                        item.getId(),
                        item.getName(),
                        item.getPrice(),
                        item.getQuantity()
                );

                objects.add(tm);
            }
            tblItem.setItems(objects);

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Customer Form");
        stage.setScene(scene);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.hide();

        stage.show();
    }

    @FXML
    void btnCLearOnAction(ActionEvent event) {
            txtId.clear();
            txtName.clear();
            txtPrice.clear();
            txtQTY.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        int id  = Integer.parseInt(txtId.getText());

        try {
            boolean b = itemBo.DeleteItem(id);
            if (b){
                System.out.println("delete success");
                loadAllItems();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int qty = Integer.parseInt(txtQTY.getText());

        ItemDTO itm = new ItemDTO(id, name, price, qty);

        try {
            boolean b = itemBo.saveItem(itm);
            if (b){
                System.out.println("Item added");
                loadAllItems();
            }


        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int qty = Integer.parseInt(txtQTY.getText());

        ItemDTO itm = new ItemDTO(id, name, price, qty);

        try {
            boolean b = itemBo.UpdateItem(itm);
            if (b){
                System.out.println("Item updated");
                loadAllItems();

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
