package lk.ijse.hostel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostel.util.UiNavigateUtil;

import java.io.IOException;
import java.net.URL;

public class DashboardFormController {

    public Button btnManageAccount;
    public AnchorPane dashboardContext;
    public Button btnLogOut;
    public Button btnManageStudent;
    public Button btnManageRoom;
    public Button btnDashboard;
    public Button reserveRoom;
    public Button btnManageUser;
    public AnchorPane workingContext;

    public void initialize() throws IOException {
        URL resource = getClass().getResource("../view/AboutForm.fxml");
        Parent load = FXMLLoader.load(resource);
        workingContext.getChildren().clear();
        workingContext.getChildren().add(load);
    }

    public void manageUserOnAction(ActionEvent actionEvent) throws IOException {


        URL resource = getClass().getResource("../view/ManageUserForm.fxml");
        Parent load = FXMLLoader.load(resource);
        workingContext.getChildren().clear();
        workingContext.getChildren().add(load);
    }

    public void manageAccountOnAction(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/ManageAccountForm.fxml");
        Parent load = FXMLLoader.load(resource);
        workingContext.getChildren().clear();
        workingContext.getChildren().add(load);

    }
    public void manageStudentOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentForm.fxml");
        Parent load = FXMLLoader.load(resource);
        workingContext.getChildren().clear();
        workingContext.getChildren().add(load);
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) workingContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }


    public void manageRoomOnAction(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/ManageRoomForm.fxml");
        Parent load = FXMLLoader.load(resource);
        workingContext.getChildren().clear();
        workingContext.getChildren().add(load);
    }

    public void reserveRoomOnAction(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/ReserveRoomForm.fxml");
        Parent load = FXMLLoader.load(resource);
        workingContext.getChildren().clear();
        workingContext.getChildren().add(load);
    }

    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AboutForm.fxml");
        Parent load = FXMLLoader.load(resource);
        workingContext.getChildren().clear();
        workingContext.getChildren().add(load);

    }


}
