package lk.ijse.hostel.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.hostel.bo.BOFactory;
import lk.ijse.hostel.bo.BOType;
import lk.ijse.hostel.bo.custom.impl.UserBOImpl;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.dto.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageUserFormController {
    public TextField txtContact;
    public Button btnAdd;
    public Button btnUpdate;
    public Button btnDelete;
    public TextField txtEmail;
    public ComboBox cmbUserName;
    public TextField txtFullName;
    public TextField txtPassword;

    UserBOImpl userBOImpl = (UserBOImpl) BOFactory.getInstance().getBO(BOType.USER);

    public void initialize() throws SQLException, ClassNotFoundException {

        cmbUserName.getItems().clear();
        txtFullName.setDisable(true);
        ArrayList<UserDTO> all = userBOImpl.getAll();
        for (UserDTO user:all
             ) {
            cmbUserName.getItems().add(user.getUserName());
        }
        cmbUserName.getItems().add(" ");

        cmbUserName.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{


            if (!(newValue == null)){
                if (newValue.equals(" ")){

                    txtContact.clear();
                    txtEmail.clear();
                    txtPassword.clear();
                    txtFullName.clear();



                    txtFullName.setDisable(false);
                    btnAdd.setDisable(false);
                    btnDelete.setDisable(true);
                    btnUpdate.setDisable(true);

                }else {

                    try {
                        txtFullName.setDisable(true);
                            UserDTO search = userBOImpl.search((String) cmbUserName.getValue());
                            txtFullName.setText(search.getUserName());
                            txtContact.setText(search.getContact());
                            txtEmail.setText(search.getEmail());
                            txtPassword.setText(search.getPassword());

                            btnAdd.setDisable(true);
                            btnDelete.setDisable(false);
                            btnUpdate.setDisable(false);
                             
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
    }

    public void clearFields () {

        cmbUserName.setValue(null);
        txtContact.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtFullName.clear();

    }

    public void addUserOnAction(ActionEvent actionEvent) {

        String userName = txtFullName.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        try {
            if (userBOImpl.add(new UserDTO(userName,contact,email,password))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved.!").show();
                clearFields();
                initialize();
            }
        } catch (Exception e) {
            System.out.println(e);

            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }

    public void updateUserOnAction(ActionEvent actionEvent) {

        String userName = (String) cmbUserName.getValue();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        try {
            if (userBOImpl.update(new UserDTO(userName,contact,email,password))){
                new Alert(Alert.AlertType.CONFIRMATION,"Update").show();
                clearFields();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Something Happened ").showAndWait();
        }
    }

    public void deleteUserOnAction(ActionEvent actionEvent) throws Exception {

        userBOImpl.delete(txtFullName.getText());
        clearFields();
        initialize();
    }
}
