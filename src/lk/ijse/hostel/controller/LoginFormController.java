package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostel.bo.BOFactory;
import lk.ijse.hostel.bo.custom.UserBO;
import lk.ijse.hostel.dto.UserDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;

public class LoginFormController {

    public AnchorPane loginContext;
    public TextField txtUserName;
    public Button btnLogin;
    public Button btnCancel;

    public Label lblWrongLogin;
    //public JFXTextField txtPassword;

    private final UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOType.USER);;
    public JFXPasswordField pwdPassword;
    public JFXTextField pwdShowPassWord;


    public void initialize(){
        //userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOType.USER);
        txtUserName.setOnAction(event -> {
            pwdPassword.requestFocus();
        });
    }

    public void LoginOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        UserDTO dto = userBO.search(txtUserName.getText());

        /*URL resource = getClass().getResource("../view/DashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) loginContext.getScene().getWindow();
        window.setScene(new Scene(load));*/
        checkup(dto);
    }

   private void checkup(UserDTO dto) throws IOException {
            if(dto!=null){
                String passcode = pwdPassword.getText();

                if(passcode.equals(dto.getPassword())){
                    // log in successful
                    //System.out.print("successful");
                   /* Stage stage = (Stage)loginContext.getScene().getWindow();
                    Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("../view/DashboardForm.fxml"));
                    stage.setScene(new Scene(root));
                    stage.show();*/
                    URL resource = getClass().getResource("../view/DashboardForm.fxml");
                    assert resource != null;
                    Parent load = FXMLLoader.load(resource);
                    Stage window = (Stage) loginContext.getScene().getWindow();
                    window.setScene(new Scene(load));

                }else  new Alert(Alert.AlertType.ERROR,"Password is incorrect!").show();
            }else new Alert(Alert.AlertType.ERROR,"User not found!").show();
        }
            /*URL resource = getClass().getResource("../view/DashboardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) loginContext.getScene().getWindow();
            window.setScene(new Scene(load));*/
//        }else {
//            lblWrongLogin.setText("Please enter your correct Password or user Name.");
//        }


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

    public void pwViewOnMousePressed(MouseEvent event) {
        pwdShowPassWord.setText(pwdPassword.getText());
        pwdShowPassWord.setVisible(true);
        pwdPassword.setVisible(false);
    }

    public void pwViewOnMouseReleased(MouseEvent event) {
        pwdShowPassWord.setVisible(false);
        pwdPassword.requestFocus();
        pwdPassword.setVisible(true);
    }

    public void checkCredentials(ActionEvent actionEvent) {
        btnLogin.fire();
    }


   /* public void pwViewOnMousePressed(MouseEvent event) {
        txtPassword.setText(txtPassword.getText());
        txtPassword.setVisible(true);
    }*/
}
