package lk.ijse.hostel.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.bo.BOFactory;
import lk.ijse.hostel.bo.custom.impl.RoomBOImpl;
import lk.ijse.hostel.dto.RoomDTO;


public class ManageRoomController {

    public AnchorPane manageRoomContext;
    public TextField txtType;
    public TextField txtQty;
    public Button btnAddRoom;
    public TextField txtMonthlyRent;
    //public ComboBox cmbRoomId;
    public Button btnUpdateRoom;
    public Button btnDeleteRoom;
    public TextField txtRoomId;
    RoomDTO search;
    RoomBOImpl roomBoImpl = (RoomBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.ROOM);

    public void initialize() throws Exception {

       /* ArrayList<RoomDTO> all = null;
        try{
            all = roomBoImpl.getAll();
        } catch (Exception e){
            // manage
        }
        if(all!=null) {
            for (RoomDTO r : all
            ) {
                cmbRoomId.getItems().add(r.getRoom_id());
            }

            cmbRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

                try {

                    if (!(newValue == null)) {
                        search = roomBoImpl.search((String) newValue);
                        txtType.setText(search.getTye());
                        txtMonthlyRent.setText(String.valueOf(search.getKey_money()));
                        txtQty.setText(String.valueOf(search.getQty()));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }*/

            }

            public void clearFields () {
                txtType.clear();
                txtMonthlyRent.clear();
                txtQty.clear();
                txtRoomId.clear();

            }

            public void addRoomOnAction (ActionEvent actionEvent) throws Exception {

                String id = txtRoomId.getText();
                Double mRent = Double.parseDouble(txtMonthlyRent.getText());
                int qty = Integer.parseInt(txtQty.getText());
                String roomType = txtType.getText();


                try {
                    if (roomBoImpl.add(new RoomDTO(id,roomType,mRent,qty))) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Saved.!").show();
                        clearFields();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
                }
            }

    public void updateOnAction(ActionEvent actionEvent) throws Exception {

        String id = txtRoomId.getText();
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
        roomBoImpl.delete(txtRoomId.getText());
        clearFields();


    }

    public void roomIdOnAction(ActionEvent actionEvent) throws Exception {
        RoomDTO roomDTO = roomBoImpl.search(txtRoomId.getText());
        if (roomDTO != null) {
            txtMonthlyRent.setText(String.valueOf(roomDTO.getKey_money()));
            txtQty.setText(String.valueOf(roomDTO.getQty()));
            txtType.setText(roomDTO.getTye());


        }
    }
}