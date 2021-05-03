package by.internetbanking.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public Session openHibernateSession(){
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Session session = factory.openSession();
        return session;
    }

}
