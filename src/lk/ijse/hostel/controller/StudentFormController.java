package lk.ijse.hostel.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.bo.BOFactory;
import lk.ijse.hostel.bo.custom.impl.StudentBOImpl;
import lk.ijse.hostel.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class StudentFormController {

    public AnchorPane registerContext;
    public TextField txtSName;
    public TextField txtSAddress;
    public TextField txtSContact;
    public TextField txtSBirthday;
   // public TextField txtSGender;
    public Button btnRegisterStudent;
    public Button btnUpdateStudent;
    public Button btnDeleteStudent;
    public ComboBox cmbStudentId;
    public TextField txtStId;
    public ComboBox cmbGender;


    StudentBOImpl studentBOImpl = (StudentBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    public void initialize() throws Exception {
        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");

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
        cmbGender.setValue(null);
        txtStId.clear();

    }

    public void registerStudentOnAction(ActionEvent actionEvent) {

        String id = txtStId.getText();
        String name = txtSName.getText();
        String address = txtSAddress.getText();
        String contact = txtSContact.getText();
        String birthday = txtSBirthday.getText();
        String gender = cmbGender.getValue().toString();

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
        String gender = cmbGender.getValue().toString();
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
            cmbGender.setValue(studentDTO.getGender());
        }
    }

    private Object validate() {
        Pattern idPattern = Pattern.compile("^(S00-)[0-9]{3,5}$");
        Pattern nameUPartern = Pattern.compile("^[A-Z][A-z]{3,20}$");
        Pattern contact= Pattern.compile("^[0-9]{10}$");
        // Pattern postalCodePatern = Pattern.compile("^[0-9]{5,9}$");


        if (!idPattern.matcher(txtSName.getText()).matches()) {
            addUError(txtSName);
            return txtSName;
        } else {
            removeUError(txtSName);
            if(!nameUPartern.matcher(txtSName.getText()).matches()){
                addUError(txtSName);
                return txtSName;
            }
            else{
                removeUError(txtSName);
                if(!contact.matcher(txtSContact.getText()).matches()){
                    addUError(txtSContact);
                    return  txtSContact;
                }
                else{
                        removeUError(txtSContact);
                    }
                }
            }


        return true;
    }

    private void addUError(TextField txtField) {
        if (txtField.getText().length() > 0) {
            txtField.setStyle("-fx-border-color: red");

        }
        btnRegisterStudent.setDisable(true);
       // btnUpdateStudent.setDisable(true);
    }

    private void removeUError(TextField txtField) {
        txtField.setStyle("-fx-border-color: green");

        btnRegisterStudent.setDisable(false);
      //  btnUpdateStudent.setDisable(false);

    }


    public void textFields_Key_Released(KeyEvent keyEvent) {
        validate();
        //validateU();
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response = validate();
            //if the response is a text field
            //that means there is a error
            if (response instanceof TextField) {
                TextField textField = (TextField) response;
                textField.requestFocus();// if there is a error just focus it
            } else if (response instanceof Boolean) {

            }

        }
    }
}
