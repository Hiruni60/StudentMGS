package lk.ijse.hostel.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.bo.BOFactory;
import lk.ijse.hostel.bo.BOType;
import lk.ijse.hostel.bo.custom.impl.RoomBOImpl;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;


public class ManageRoomController {

    public AnchorPane manageRoomContext;
    public TextField txtType;
    public TextField txtQty;
    public Button btnAddRoom;
    public TextField txtMonthlyRent;
    public ComboBox cmbRoomId;
    public Button btnUpdateRoom;
    public Button btnDeleteRoom;
    RoomDTO search;
    RoomBOImpl roomBoImpl = (RoomBOImpl) BOFactory.getInstance().getBO(BOType.ROOM);

    public void initialize() throws Exception {

        ArrayList<RoomDTO> all = roomBoImpl.getAll();
        for (RoomDTO r:all
        ) {
            cmbRoomId.getItems().add(r.getRoom_id());
        }

        cmbRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{

            try {

                if (!(newValue ==null)){
                     search = roomBoImpl.search((String) newValue);
                    txtType.setText(search.getTye());
                    txtMonthlyRent.setText(String.valueOf(search.getKey_money()));
                    txtQty.setText(String.valueOf(search.getQty()));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });


            }

            public void clearFields () {
                txtType.clear();
                txtMonthlyRent.clear();
                txtQty.clear();
                cmbRoomId.setValue(null);
            }

            public void addRoomOnAction (ActionEvent actionEvent) throws Exception {

                search.setQty(search.getQty()+1);
                roomBoImpl.update(new RoomDTO(search.getRoom_id(),search.getTye(),search.getKey_money(),search.getQty()));
                clearFields();
            }

    public void updateOnAction(ActionEvent actionEvent) throws Exception {

        String id = (String) cmbRoomId.getValue();
        String type = txtType.getText();
        String monthlyRent = txtMonthlyRent.getText();
        String qty = txtQty.getText();

        try {
            if(roomBoImpl.update(new RoomDTO(id,type,Double.parseDouble(monthlyRent),Integer.parseInt(qty)))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated.!").show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }
    }


    public void deleteOnAction(ActionEvent actionEvent) throws Exception {


        search.setQty(search.getQty()-1);
        roomBoImpl.update(new RoomDTO(search.getRoom_id(),search.getTye(),search.getKey_money(),search.getQty()));
        clearFields();
    }
}