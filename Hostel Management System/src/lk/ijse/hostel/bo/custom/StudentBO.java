package lk.ijse.hostel.bo.custom;


import lk.ijse.hostel.bo.SuperBO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.Student;

import java.sql.SQLException;


public interface StudentBO extends SuperBO {

    public boolean add(StudentDTO studentDTO) throws Exception;

    public boolean update(StudentDTO studentDTO) throws Exception;

    public boolean delete(String id) throws Exception;

    public String generateNewId() throws SQLException, ClassNotFoundException;

    public StudentDTO search(String s)throws Exception;
}
