package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.bo.SuperBO;
import lk.ijse.hostel.dto.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {

    public boolean add(UserDTO userDTO) throws Exception;

    public boolean update(UserDTO userDTO) throws Exception;

    public boolean delete(String id) throws Exception;

    ArrayList<UserDTO> getAll () throws SQLException, ClassNotFoundException;

    UserDTO search(String s) throws SQLException, ClassNotFoundException;
}
