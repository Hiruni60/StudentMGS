package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.StudentBO;
import lk.ijse.hostel.bo.custom.UserBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.DAOType;
import lk.ijse.hostel.dao.custom.impl.UserDAOImpl;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.entity.User;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {

    UserDAOImpl userDAO = (UserDAOImpl) DAOFactory.getInstance().getDAO(DAOType.USER);

    public ArrayList<UserDTO> getAll () throws SQLException, ClassNotFoundException {

        List<User> all = userDAO.getAll();
        ArrayList<UserDTO> allUser = new ArrayList<>();

        for (User user:all
             ) {
            allUser.add(new UserDTO(user.getUserName(),user.getContact(),user.getEmail(),user.getPassword()));
        }
        return allUser;
    }

    @Override
    public boolean add(UserDTO userDTO) throws Exception {

        return userDAO.save(new User(
                userDTO.getUserName(),
                userDTO.getContact(),
                userDTO.getEmail(),
                userDTO.getPassword()
        ));
    }

    @Override
    public boolean update(UserDTO userDTO) throws Exception {

        return userDAO.update(new User(
                userDTO.getUserName(),
                userDTO.getContact(),
                userDTO.getEmail(),
                userDTO.getPassword()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {

        return userDAO.delete(id);
    }


    public UserDTO search(String s) throws SQLException, ClassNotFoundException{

        User search = userDAO.search(s);

      return   new UserDTO(search.getUserName(),search.getContact(),search.getEmail(),search.getPassword());
    }
}
