package lk.ijse.hostel.dto;


public class RoomDTO {

    private String room_id;
    private String tye;
    private double key_money;
    private int qty;

    public RoomDTO() {
    }

    public RoomDTO(String room_id, String tye, double key_money, int qty) {
        this.room_id = room_id;
        this.tye = tye;
        this.key_money = key_money;
        this.qty = qty;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getTye() {
        return tye;
    }

    public void setTye(String tye) {
        this.tye = tye;
    }

    public double getKey_money() {
        return key_money;
    }

    public void setKey_money(double key_money) {
        this.key_money = key_money;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "room_id='" + room_id + '\'' +
                ", tye='" + tye + '\'' +
                ", key_money=" + key_money +
                ", qty=" + qty +
                '}';
    }
}
