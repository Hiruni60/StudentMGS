package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.RoomBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.DAOType;
import lk.ijse.hostel.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.entity.Room;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RoomBOImpl implements RoomBO {

    RoomDAOImpl roomDAO = (RoomDAOImpl) DAOFactory.getInstance().getDAO(DAOType.ROOM);

    public ArrayList<RoomDTO> getAll() throws Exception {


        List<Room> all = roomDAO.getAll();



        ArrayList <RoomDTO> allRoom = new ArrayList<>();
        for (Room room:all
        ) {
            allRoom.add(new RoomDTO(room.getRoomId(),room.getRoomType(),room.getMonthlyRent(),room.getQty()));
        }

        return allRoom;

    }

    @Override
    public RoomDTO search(String s) throws Exception {
        Room search = roomDAO.search(s);
        return new RoomDTO(search.getRoomId(),search.getRoomType(),search.getMonthlyRent(),search.getQty());
    }

    @Override
    public boolean add(RoomDTO roomDTO) throws Exception {

        return roomDAO.save(new Room(

                roomDTO.getRoom_id(),
                roomDTO.getTye(),
                roomDTO.getKey_money(),
                roomDTO.getQty()

        ));

    }

    @Override
    public RoomDTO findRoom(String id) throws Exception {
        return null;
    }

    @Override
    public RoomDTO getRoom(String id) throws Exception {
        return null;
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws Exception {

                return roomDAO.update(new Room(
                roomDTO.getRoom_id(),
                roomDTO.getTye(),
                roomDTO.getKey_money(),
                roomDTO.getQty()

        ));


    }

    @Override
    public boolean delete(String id) throws Exception {

        return roomDAO.delete(id);
    }



    public String generateNewId() throws SQLException, ClassNotFoundException {

        return roomDAO.generateNewID();


    }

//
//    @Override
//    public boolean add(RoomDTO roomDTO) throws Exception {
//
//        return roomDAO.add(new Room(
//                roomDTO.getRoom_id(),
//                roomDTO.getTye(),
//                roomDTO.getKey_money(),
//                roomDTO.getQty()
//
//        ));
//    }
//
//    @Override
//    public RoomDTO findRoom(String id) throws Exception {
//        return null;
//    }
//
//    @Override
//    public RoomDTO getRoom(String id) throws Exception {
//        return null;
//    }
//
//    @Override
//    public boolean update(RoomDTO roomDTO) throws Exception {
//
//        return roomDAO.add(new Room(
//                roomDTO.getRoom_id(),
//                roomDTO.getTye(),
//                roomDTO.getKey_money(),
//                roomDTO.getQty()
//
//        ));
//
//    }
//
//    @Override
//    public boolean delete(String id) throws Exception {
//        return roomDAO.delete(id);
//    }
}
