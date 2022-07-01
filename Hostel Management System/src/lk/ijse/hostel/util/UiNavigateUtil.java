package lk.ijse.hostel.util;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/17/2022
 * Time        : 7:44 PM
 */
public class UiNavigateUtil {
    public static void  navigationForm(AnchorPane anchorPane, String url) throws IOException {

        anchorPane.getChildren().clear();
        Parent parent = FXMLLoader.load(UiNavigateUtil.class.getResource("../view/"+url+".fxml"));
        anchorPane.getChildren().add(parent);
    }

    public static void newUi(AnchorPane anchorPane, String url) throws IOException {
        Stage stage=(Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(UiNavigateUtil.class.getResource("../../view/fxml/"+url+".fxml"))));
        stage.centerOnScreen();
        stage.centerOnScreen();
        stage.show();
    }

    public static void closeForm(AnchorPane anchorPane){
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

}
