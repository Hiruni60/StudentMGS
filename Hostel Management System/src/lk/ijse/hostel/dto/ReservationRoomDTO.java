package lk.ijse.hostel.dto;

import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;

import java.time.LocalDate;

public class ReservationRoomDTO {

    private String reservationId;
    private Student student;
    private Room room;
    private String timeDuration;
    private String status;
    private LocalDate reserveDate;

    public ReservationRoomDTO() {
    }

    public ReservationRoomDTO(String reservationId, Student student, Room room, String timeDuration, String status, LocalDate reserveDate) {
        this.reservationId = reservationId;
        this.student = student;
        this.room = room;
        this.timeDuration = timeDuration;
        this.status = status;
        this.reserveDate = reserveDate;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(LocalDate reserveDate) {
        this.reserveDate = reserveDate;
    }

    @Override
    public String toString() {
        return "ReservationRoomDTO{" +
                "reservationId='" + reservationId + '\'' +
                ", student=" + student +
                ", room=" + room +
                ", timeDuration='" + timeDuration + '\'' +
                ", status='" + status + '\'' +
                ", reserveDate=" + reserveDate +
                '}';
    }
}
