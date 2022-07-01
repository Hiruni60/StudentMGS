package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.StudentBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.DAOType;
import lk.ijse.hostel.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.Student;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAO = (StudentDAOImpl) DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    public ArrayList <StudentDTO> getAll() throws Exception {

        List<Student> all = studentDAO.getAll();

        ArrayList <StudentDTO> allStudent = new ArrayList<>();
        for (Student student:all
             ) {
            allStudent.add(new StudentDTO(student.getStudentId(),student.getStudentName(),student.getStudentAddress(),
                    student.getStudentContact(),student.getDateOfBirth(),student.getGender()));
        }

        return allStudent;

    }

    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {

        return studentDAO.save(new Student(

                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender()

        ));
    }



    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {

        return studentDAO.update(new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return studentDAO.delete(id);
    }

    public String generateNewId() throws SQLException, ClassNotFoundException {

        return studentDAO.generateNewID();


    }

    public StudentDTO search(String s) throws SQLException, ClassNotFoundException {

        Student search = studentDAO.search(s);
        return new StudentDTO(search.getStudentId(),search.getStudentName(),search.getStudentAddress(),
                search.getStudentContact(),search.getDateOfBirth(),search.getGender());
    }
}
