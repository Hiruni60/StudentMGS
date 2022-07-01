package lk.ijse.hostel.dao;

import lk.ijse.hostel.dao.custom.impl.ReserveRoomDAOImpl;
import lk.ijse.hostel.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostel.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostel.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return (null == daoFactory) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public SuperDAO getDAO(DAOType daoType){
        switch (daoType){
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case USER:
                return new UserDAOImpl();
            case RESERVE:
                return new ReserveRoomDAOImpl();
            default:
                return null;
        }
    }
}
