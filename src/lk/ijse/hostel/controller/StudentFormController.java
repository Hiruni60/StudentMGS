package lk.ijse.hostel.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.bo.BOFactory;
import lk.ijse.hostel.bo.custom.impl.StudentBOImpl;
import lk.ijse.hostel.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;

public class StudentFormController {

    public AnchorPane registerContext;
    public TextField txtSName;
    public TextField txtSAddress;
    public TextField txtSContact;
    public TextField txtSBirthday;
    public TextField txtSGender;
    public Button btnRegisterStudent;
    public Button btnUpdateStudent;
    public Button btnDeleteStudent;
    public ComboBox cmbStudentId;
    public TextField txtStId;


    StudentBOImpl studentBOImpl = (StudentBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    public void initialize() throws Exception {

        /*btnRegisterStudent.setDisable(true);
        btnUpdateStudent.setDisable(true);
        btnDeleteStudent.setDisable(true);*/
        /*ArrayList<StudentDTO> all = null;
        try{
            all = studentBOImpl.getAll();
        }catch (Exception e){
            //manage
        }
        if(all!=null) {
            for (StudentDTO s : all
            ) {
                cmbStudentId.getItems().add(s.getId());
            }
            cmbStudentId.getItems().add("  ");

            cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.equals("  ")) {
                    try {
                        cmbStudentId.setValue(studentBOImpl.generateNewId());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    btnRegisterStudent.setDisable(false);
                    btnDeleteStudent.setDisable(true);
                    btnUpdateStudent.setDisable(true);

                } else {
                    try {
                        StudentDTO search = studentBOImpl.search((String) cmbStudentId.getValue());
                        txtSName.setText(search.getName());
                        txtSAddress.setText(search.getAddress());
                        txtSContact.setText(search.getContact());
                        txtSBirthday.setText(search.getDob());
                        txtSGender.setText(search.getGender());

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException | IOException e) {
                        e.printStackTrace();
                    }

                    btnRegisterStudent.setDisable(true);
                    btnDeleteStudent.setDisable(false);
                    btnUpdateStudent.setDisable(false);
                }

            });
        }*/

    }

    public void clearFields() {


        txtSName.clear();
        txtSAddress.clear();
        txtSContact.clear();
        txtSBirthday.clear();
        txtSGender.clear();
        txtStId.clear();

    }

    public void registerStudentOnAction(ActionEvent actionEvent) {

        String id = txtStId.getText();
        String name = txtSName.getText();
        String address = txtSAddress.getText();
        String contact = txtSContact.getText();
        String birthday = txtSBirthday.getText();
        String gender = txtSGender.getText();

        try {
            if (studentBOImpl.add(new StudentDTO(id, name, address, contact, birthday, gender))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved.!").show();
                clearFields();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }

    public void updateStudentOnAction(ActionEvent actionEvent) {

        String id = txtStId.getText();
        String name = txtSName.getText();
        String address = txtSAddress.getText();
        String contact = txtSContact.getText();
        String birthday = txtSBirthday.getText();
        String gender = txtSGender.getText();
        try {
            if (studentBOImpl.update(new StudentDTO(id, name, address, contact, birthday, gender))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated.!").show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }

    }

    public void deleteStudentOnAction(ActionEvent studentId) throws Exception {

        studentBOImpl.delete(txtStId.getText());
        clearFields();

    }

    public void stIdOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        StudentDTO studentDTO = studentBOImpl.search(txtStId.getText());
        if (studentDTO != null) {
            txtSAddress.setText(studentDTO.getAddress());
            txtSContact.setText(studentDTO.getContact());
            txtSBirthday.setText(studentDTO.getDob());
            txtSName.setText(studentDTO.getName());
            txtSGender.setText(studentDTO.getGender());
        }
    }
}
