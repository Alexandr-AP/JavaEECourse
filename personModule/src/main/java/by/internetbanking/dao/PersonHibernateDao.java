package by.internetbanking.dao;

import by.internetbanking.entity.Person;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class PersonHibernateDao implements PersonDao {

    public static void main(String[] args) {
        // new PersonHibernateDao().createPerson(new Person("UtPerson",22));
        // new PersonHibernateDao().readAllPersons();
        //  new PersonHibernateDao().createPerson("Ioan56",72);
        //  new PersonHibernateDao().deletePersonById(4);
        //  new PersonHibernateDao().updatePersonById(6, "Oporos",65);
        //  new PersonHibernateDao().readAllPersons();
        // new PersonHibernateDao().createPersonWithPassport();
        new PersonHibernateDao().getPersonsWithNameLikeAndAgeBetween("Ut", 20, 40);


    }

    private void createPersonWithPassport() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Person> personList = session.createQuery("FROM Person").list();
        transaction.commit();


    }

    @Override
    public void createPerson(Person person) {
        //HibernateUtil hibernateUtil = new HibernateUtil();
        //   SessionFactory factory = new Configuration().configure().buildSessionFactory();
        //  Session session = factory.openSession();
        Session session = new HibernateUtil().openHibernateSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
        //hibernate
    }

    @Override
    public void createPerson(String name, int age) {
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
        Session session = new HibernateUtil().openHibernateSession();
        Person person = new Person(name, age);
        session.save(person);

        session.close();
    }


    @Override
    public Person readPersonById(int id) {
        return null;
    }


    @Override
    public List<Person> readAllPersons() {
        SessionFactory factoty = new Configuration().configure().buildSessionFactory();
        Session session = factoty.openSession();
        List<Person> persons = new ArrayList<>();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<Person> personList = session.createQuery("FROM Person").list();
            for (Iterator iterator = personList.iterator(); ((Iterator<?>) iterator).hasNext(); ) {
                Person person = (Person) iterator.next();
                persons.add(person);

            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return persons;


    }

    @Override
    public void updatePersonById(int id, String nameNew, int ageNew) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Person person = (Person) session.get(Person.class, id);
            person.setAge(ageNew);
            person.setName(nameNew);
            session.update(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updatePerson(Person personUpdated) {

    }

    @Override
    public void deletePersonById(int id) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Person person = (Person) session.get(Person.class, id);
            session.delete(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void getPersonsWithNameLikeAndAgeBetween(String likeName, int minAge, int maxAge) {
        Session session = new HibernateUtil().openHibernateSession();
        Criteria criteria = session.createCriteria(Person.class);
        criteria.add(Restrictions.or(Restrictions.like("name", "%" + likeName + "%"),
                Restrictions.like("name", "%" + likeName.toLowerCase() + "%")));
        List result = criteria.list();

        System.out.println("ghh");
    }
}



