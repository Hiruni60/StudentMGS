package lk.ijse.hostel.dao.custom.impl;


import lk.ijse.hostel.dao.custom.ReserveRoomDAO;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ReserveRoomDAOImpl implements ReserveRoomDAO {

    @Override
    public List<Reservation> getAll() throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        String hql ="from Reservation ";

        Query query = session.createQuery(hql);

        List<Reservation> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean save(Reservation dto) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(dto);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reservation dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Reservation search(String s) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        Reservation reservation = session.get(Reservation.class, s);

        transaction.commit();
        session.close();
        return reservation;
    }

//    @Override
//    public boolean save(Room dto) throws SQLException, ClassNotFoundException {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        session.save(dto);
//
//        transaction.commit();
//        session.close();
//        return true;
//    }
//
//
//    @Override
//    public boolean update(Room dto) throws SQLException, ClassNotFoundException {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        session.update(dto);
//
//        transaction.commit();
//        session.close();
//        return true;
//    }
//
//    @Override
//    public Room search(String s) throws SQLException, ClassNotFoundException {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//
//        Room room = session.get(Room.class, s);
//
//        transaction.commit();
//        session.close();
//        return room;
//    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(s);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List list = session.createSQLQuery("SELECT reservationId FROM reservation ORDER BY reservationId DESC LIMIT 1").list();

        transaction.commit();
        session.close();

        if (list.isEmpty()){
            return "R00-001";
        }else {
            String id=(String) list.get(0);
            int newItemId = Integer.parseInt(id.replace("R00-", "")) + 1;
            return String.format("R00-%03d", newItemId);
        }


    }

}
