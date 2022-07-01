package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO{

    @Override
    public List<Room> getAll() throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Room> from_room_ = session.createQuery("FROM Room ").list();


        transaction.commit();
        session.close();
        return from_room_;
    }

    @Override
    public boolean save(Room dto) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(dto);

        transaction.commit();
        session.close();
        return true;
    }


    @Override
    public boolean update(Room dto) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(dto);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Room search(String s) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.get(Room.class, s);



        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.load(Room.class,s);

        session.delete(room);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

//    @Override
//    public boolean add(Room entity) throws Exception {
//
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        session.save(entity);
//
//        transaction.commit();
//        session.close();
//        return true;
//    }
//
//    @Override
//    public boolean update(Room entity) throws Exception {
//
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        session.update(entity);
//
//        transaction.commit();
//        session.close();
//        return true;
//    }
//
//    @Override
//    public boolean delete(String s) throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        Student student = session.load(Student.class,s);
//
//        session.delete(student);
//
//        transaction.commit();
//        session.close();
//        return true;
//    }
//
//    @Override
//    public Room find(String s) throws Exception {
//        return null;
//    }
//
//    @Override
//    public List<Room> findAll() throws Exception {
//        return null;
//    }
}
