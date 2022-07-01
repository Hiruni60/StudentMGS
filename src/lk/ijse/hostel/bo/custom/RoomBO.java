package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.bo.SuperBO;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;

import java.util.ArrayList;

public interface RoomBO extends SuperBO {

    public boolean add(RoomDTO roomDTO) throws Exception;

    public RoomDTO findRoom(String id)throws Exception;

    public RoomDTO getRoom(String id) throws Exception;

    public boolean update(RoomDTO roomDTO) throws Exception;

    public boolean delete(String id) throws Exception;

    ArrayList<RoomDTO> getAll() throws Exception;

    public RoomDTO search(String s)throws Exception;
}
