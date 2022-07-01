package lk.ijse.hostel.dto;



public class ReserveRoomDTO {

    private String reservationId;
    private String roomType;
    private String studentId;
    private String status;

    public ReserveRoomDTO() {
    }

    public ReserveRoomDTO(String reservationId, String roomType, String studentId, String status) {
        this.reservationId = reservationId;
        this.roomType = roomType;
        this.studentId = studentId;
        this.status = status;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReserveRoomDTO{" +
                "reservationId='" + reservationId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", studentId='" + studentId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
