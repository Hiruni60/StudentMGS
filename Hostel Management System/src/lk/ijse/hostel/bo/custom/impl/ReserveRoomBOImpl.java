package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.BOFactory;
import lk.ijse.hostel.bo.BOType;
import lk.ijse.hostel.bo.custom.ReserveRoomBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.DAOType;
import lk.ijse.hostel.dao.custom.impl.ReserveRoomDAOImpl;
import lk.ijse.hostel.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostel.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostel.dto.ReservationRoomDTO;
import lk.ijse.hostel.dto.ReserveRoomDTO;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReserveRoomBOImpl implements ReserveRoomBO {

    ReserveRoomDAOImpl reserveRoomDAO= (ReserveRoomDAOImpl) DAOFactory.getInstance().getDAO(DAOType.RESERVE);
    RoomDAOImpl roomDAO = (RoomDAOImpl) DAOFactory.getInstance().getDAO(DAOType.ROOM);
    StudentDAOImpl studentDAO = (StudentDAOImpl) DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public boolean add(ReserveRoomDTO reserveRoomDTO) throws Exception {

        return false;

    }

    @Override
    public boolean update(ReserveRoomDTO reserveRoomDTO) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    public RoomDTO search(String id) throws SQLException, ClassNotFoundException {

        Room search = roomDAO.search(id);

        return new RoomDTO(search.getRoomId(),search.getRoomType(),search.getMonthlyRent(),search.getQty());


    }

    public StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException {
        Student search = studentDAO.search(id);

        return new StudentDTO(search.getStudentId(),search.getStudentName(),search.getStudentAddress(),search.getStudentContact(),
                search.getDateOfBirth(),search.getGender());
    }

    @Override
    public boolean save(ReservationRoomDTO reservationRoomDTO) throws Exception {

      return   reserveRoomDAO.save(new Reservation(reservationRoomDTO.getReservationId(),reservationRoomDTO.getStudent(),reservationRoomDTO.getRoom(),
                reservationRoomDTO.getTimeDuration(),reservationRoomDTO.getStatus(),reservationRoomDTO.getReserveDate()));


    }

    @Override
    public ReserveRoomDTO search() throws Exception {
        return null;
    }

    @Override
    public ArrayList<RoomDTO> getAll() throws Exception {

        List<Room> all = roomDAO.getAll();

        ArrayList<RoomDTO> allReserve = new ArrayList<>();

        for (Room r:all
             ) {
            allReserve.add(new RoomDTO(r.getRoomId(),r.getRoomType(),r.getMonthlyRent(),r.getQty()));
        }
        return allReserve;
    }

    public ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException {

        List<Student> all = studentDAO.getAll();
        ArrayList<StudentDTO> allStudent = new ArrayList<>();

        for (Student s:all
             ) {
            allStudent.add(new StudentDTO(s.getStudentId(),s.getStudentName(),s.getStudentAddress(),
                    s.getStudentContact(),s.getDateOfBirth(),
            s.getGender()));
        }
        return allStudent;
    }

    public ArrayList<ReserveRoomDTO> getAllReserve() throws SQLException, ClassNotFoundException {

        List<Reservation> all = reserveRoomDAO.getAll();
        ArrayList<ReserveRoomDTO> allReserve = new ArrayList<>();

        for (Reservation room:all
             ) {
            allReserve.add(new ReserveRoomDTO(room.getReservationId(),room.getRoom().getRoomId(),
                    room.getStudent().getStudentId(),room.getStatus()));
        }
        return allReserve;
    }

   public String generateReserveRoomId() throws SQLException, ClassNotFoundException {
      return   reserveRoomDAO.generateNewID();
   }

    public boolean updateRoom(RoomDTO roomDTO) throws Exception {

        return roomDAO.update(new Room(
                roomDTO.getRoom_id(),
                roomDTO.getTye(),
                roomDTO.getKey_money(),
                roomDTO.getQty()

        ));


    }
}
