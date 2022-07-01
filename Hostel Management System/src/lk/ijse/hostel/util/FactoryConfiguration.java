package lk.ijse.hostel.util;


import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;
import lk.ijse.hostel.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        // configure() -> load and config Hibernate.cfg.xml file to SessionFactory
        // addAnnotatedClass() -> define which Entity that gonna use to Persist
        Configuration configuration = new Configuration().configure("/lk/ijse/hostel/resources/hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Reservation.class);
        

        // build a SessionFactory and assign it to sessionFactory reference
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                : factoryConfiguration;
    }
    // return a new Session through sessionFactory
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
