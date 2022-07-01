package lk.ijse.hostel.dao;

import lk.ijse.hostel.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T, ID> extends SuperDAO{
    List<T> getAll() throws SQLException, ClassNotFoundException, IOException;

    boolean save(T dto) throws SQLException, ClassNotFoundException, IOException;

    boolean update(T dto) throws SQLException, ClassNotFoundException, IOException;

    T search(ID id) throws SQLException, ClassNotFoundException, IOException;

    boolean exist(ID id) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException, IOException;

    String generateNewID() throws SQLException, ClassNotFoundException, IOException;
}
