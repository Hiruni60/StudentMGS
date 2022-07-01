package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.bo.SuperBO;
import lk.ijse.hostel.dto.ReservationRoomDTO;
import lk.ijse.hostel.dto.ReserveRoomDTO;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public interface ReserveRoomBO extends SuperBO {

    public boolean add(ReserveRoomDTO reserveRoomDTO) throws Exception;

    public boolean update(ReserveRoomDTO reserveRoomDTO) throws Exception;

    public boolean delete(String id) throws Exception;

    ArrayList<RoomDTO> getAll() throws Exception;

    ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException, IOException;

    RoomDTO search(String id) throws SQLException, ClassNotFoundException, IOException;

    StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException, IOException;

    public boolean save(ReservationRoomDTO reservationRoomDTO) throws Exception;
    ReserveRoomDTO search()throws Exception;

    public String generateReserveRoomId() throws SQLException, ClassNotFoundException, IOException;

    ArrayList<ReserveRoomDTO> getAllReserve() throws SQLException, ClassNotFoundException, IOException;

    boolean updateRoom(RoomDTO roomDTO) throws Exception;

}
