package lk.ijse.hostel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class LoginFormController {

    public AnchorPane loginContext;
    public TextField txtUserName;
    public Button btnLogin;
    public Button btnCancel;
    public PasswordField pwdPassword;
    public Label lblWrongLogin;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {

//        if(txtUserName.getText().equals("renuka")&&pwdPassword.getText().equals("123")){
//            txtUserName.clear();
//            pwdPassword.clear();
//            new Alert(Alert.AlertType.CONFIRMATION, "Successfully......", ButtonType.CLOSE).show();
//
            URL resource = getClass().getResource("../view/DashboardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) loginContext.getScene().getWindow();
            window.setScene(new Scene(load));
//        }else {
//            lblWrongLogin.setText("Please enter your correct Password or user Name.");
//        }
    }

    public void cancelOnAction(ActionEvent actionEvent) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();

        if (buttonType.get().equals(ButtonType.YES)) {
            Stage stage = (Stage) loginContext.getScene().getWindow();
            stage.close();

            URL resource = getClass().getResource("../sample/HostelManagementSystem.fxml");
            Parent load = FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage1 = new Stage();
            stage1.setScene(scene);


            stage1.centerOnScreen();

            stage1.show();
        }
    }
}
