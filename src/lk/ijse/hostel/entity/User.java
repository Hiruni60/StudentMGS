package lk.ijse.hostel.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    private String userName;
    private String contact;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Student>studentList=new ArrayList<>();

    public User() {
    }

    public User(String userName, String contact, String email, String password) {
        this.userName = userName;
        this.contact = contact;
        this.email = email;
        this.password = password;
    }

    public User(String userName, String contact, String email, String password, List<Student> studentList) {
        this.userName = userName;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.studentList = studentList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
