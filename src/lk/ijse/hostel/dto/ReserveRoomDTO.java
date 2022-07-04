package lk.ijse.hostel.dto;


import java.time.LocalDate;

public class ReserveRoomDTO {

    private String reservationId;
    private String roomType;
    private String studentId;
    private String status;
    private LocalDate reserveDate;
    private String timeDuration;

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public ReserveRoomDTO() {
    }

    public LocalDate getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(LocalDate reserveDate) {
        this.reserveDate = reserveDate;
    }

    public ReserveRoomDTO(String reservationId, String roomType, String studentId, String status, LocalDate reserveDate, String timeDuration) {
        this.reservationId = reservationId;
        this.roomType = roomType;
        this.studentId = studentId;
        this.status = status;
        this.reserveDate=reserveDate;
        this.timeDuration=timeDuration;
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
