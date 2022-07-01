package lk.ijse.hostel.bo;


import lk.ijse.hostel.bo.custom.impl.ReserveRoomBOImpl;
import lk.ijse.hostel.bo.custom.impl.RoomBOImpl;
import lk.ijse.hostel.bo.custom.impl.StudentBOImpl;
import lk.ijse.hostel.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public SuperBO getBO(BOType boType){

        switch (boType){
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return  new RoomBOImpl();
            case USER:
                return new UserBOImpl();
            case RESERVEROOM:
                return new ReserveRoomBOImpl();
            default:
                return null;
        }
    }

}

