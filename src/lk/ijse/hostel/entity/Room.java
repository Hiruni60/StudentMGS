package lk.ijse.hostel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    private String roomId;
    private String roomType;
    private double monthlyRent;
    private int qty;
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservationList=new ArrayList<>();


    public Room() {
    }

    public Room(String roomId, String roomType, double monthlyRent, int qty) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.monthlyRent = monthlyRent;
        this.qty = qty;
    }

    public Room(String roomId, String roomType, double monthlyRent, int qty, List<Reservation> reservationList) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.monthlyRent = monthlyRent;
        this.qty = qty;
        this.reservationList = reservationList;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", monthlyRent=" + monthlyRent +
                ", qty=" + qty +
                ", reservationList=" + reservationList +
                '}';
    }
}
