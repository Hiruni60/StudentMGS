package lk.ijse.hostel.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.hostel.bo.BOFactory;
import lk.ijse.hostel.bo.custom.ReserveRoomBO;
import lk.ijse.hostel.bo.custom.RoomBO;
import lk.ijse.hostel.bo.custom.impl.ReserveRoomBOImpl;
import lk.ijse.hostel.dto.ReservationRoomDTO;
import lk.ijse.hostel.dto.ReserveRoomDTO;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ReserveRoomFormController {

    public Button btnReserve;
    public ComboBox <String >cmbRoomId;
    public AnchorPane reserveContext;
    public TextField txtRoomType;
    public TextField txtStatus;
    public ComboBox <String>cmbStudentId;
    public Label lblDate;
    public Label lblTime;
    public TableView<ReserveRoomDTO>tblReserveRoom;
    public TableColumn colRId;
    public TableColumn colType;
    public TableColumn colDate;
    public TableColumn colStatus;
    public TextField txtTimeDuration;
    public TableColumn colOption;
    public ComboBox cmbStatus;
    public Button btnDelete;


    ReserveRoomBOImpl reserveRoomBO = (ReserveRoomBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.RESERVEROOM);

    public void initialize() throws Exception {
        cmbStatus.getItems().add("Paid");
        cmbStatus.getItems().add("Pending");
        cmbStatus.getItems().add("Booked");
        cmbStatus.getItems().add("Deposit");

        colRId.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
       // colOption.setCellValueFactory(new PropertyValueFactory<>("delete"));
        ArrayList<RoomDTO> all = null;
        try{
            all = reserveRoomBO.getAll();
        }catch (Exception e){}
        if(all!=null) {
            for (RoomDTO r : all
            ) {
                cmbRoomId.getItems().add(r.getRoom_id());
            }

            for (StudentDTO s : reserveRoomBO.getAllStudent()
            ) {
                cmbStudentId.getItems().add(s.getId());
            }
            loadDateAndTime();

            cmbRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                try {

                    RoomDTO search = reserveRoomBO.search(newValue);
                    txtRoomType.setText(search.getTye());

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }


            });

            loadReservationTable();
        }
    }

    private void loadReservationTable() throws SQLException, ClassNotFoundException, IOException {
        tblReserveRoom.getItems().clear();
        ArrayList<ReserveRoomDTO> allReserve = reserveRoomBO.getAllReserve();
        for (ReserveRoomDTO reserveRoomDTO:allReserve
             ) {
            tblReserveRoom.getItems().add(reserveRoomDTO);

        }
    }

    private void loadDateAndTime() {

        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour() + ":" +
                    currentTime.getMinute() + ":" +
                    currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }



    public void reserveRoomOnAction(ActionEvent actionEvent) throws Exception {

        RoomDTO search = reserveRoomBO.search(cmbRoomId.getValue());
        StudentDTO studentDTO = reserveRoomBO.searchStudent(cmbStudentId.getValue());

        String s = reserveRoomBO.generateReserveRoomId();

        reserveRoomBO.save(new ReservationRoomDTO(s,new Student(studentDTO.getId(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getContact(),
                studentDTO.getDob(),studentDTO.getGender()),new Room(search.getRoom_id(),search.getTye(),search.getKey_money(),search.getQty()),
                txtTimeDuration.getText(),String.valueOf(cmbStatus.getValue()), LocalDate.now()));

        search.setQty(search.getQty()-1);
        reserveRoomBO.updateRoom(search);
        loadReservationTable();

        txtRoomType.clear();
        cmbStatus.setValue(null);
        txtTimeDuration.clear();


    }

    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

       /* if(ReserveRoomBO.delete(tblReserveRoom.getSelectionModel().getSelectedItem().getReservationId())){
            new Alert(Alert.AlertType.INFORMATION,"reservation deleted!").show();
        }
        RoomDTO roomDTO = RoomBO.search(tblReserveRoom.getSelectionModel().getSelectedItem().getRoomType());
        roomDTO.setQty(roomDTO.getQty()+1);
        RoomBO.update(roomDTO);
        loadReservationTable();*/


}
}
