package by.internetbanking.service;

import by.internetbanking.dao.PersonDao;
import by.internetbanking.dao.PersonHibernateDao;
import by.internetbanking.entity.Person;
import by.internetbanking.exception.PersonWebException;
import by.internetbanking.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;


    @Autowired
    @Qualifier("personSpringJPADataDao")      // ==  personDao = new PersonHibernateDao();
    PersonDao personDao;


    public static final String REG_EXP_CHECK_LETTERS = "[a-zA-Z]{2,15}";

    public PersonService() {
        //  personDao = new PersonJdbcDao();
         // personDao = new PersonHibernateDao();
    }

    public void createPerson(Person person) {
      //  personDao.createPerson(person);
        personRepository.save(person);
    }


    public void createPerson(String personName, String personAgeString) throws PersonWebException {
        Person person = new Person();
                int personAge = Integer.parseInt(personAgeString);
        person.setName(personName);
        person.setAge(personAge);


        personRepository.save(person);


//
//        ArrayList<String> errorList = new ArrayList<>();
//        int personAge = 0;
//        if (personName != null && personAgeString != null) {
//
//
//            if (personName.length() < 2 || personName.length() > 15) {
//                String message = "personName not in range in 2-15";
//
//                errorList.add(message);
//
//            }
//
//            if (Pattern.matches(REG_EXP_CHECK_LETTERS, personName)) {
//                String message = "personName is invalid";
//                errorList.add(message);
//
//
//            }
//
//            try {
//                personAge = Integer.parseInt(personAgeString);
//
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//                String message = "personAge not a number";
//                errorList.add(message);
//
//
//            }
//
//        } else {
//            String message = "personAge not a number";
//            errorList.add(message);
//
//        }
//
//        if (errorList.size() > 0) {
//            throw new PersonWebException(errorList);
//        }
//
//        Person person = new Person(personName, personAge);
//        createPerson(person);
    }


    public Person readPersonById(int id) {
        personRepository.findById(id);
        return null;
    }


    public List<Person> readAllPersons() {
//        List<Person> people = personDao.readAllPersons();
//        return people;
        return (List<Person>) personRepository.findAll();
    }

    public void updatePersonById(int id, String nameNew, int ageNew) {
        //personDao.updatePersonById(id, nameNew, ageNew);
      //  personRepository.
    }

    public void updatePerson(Person personUpdated) {

    }

    public void deletePersonById(int id) {
        //personDao.deletePersonById(id);

        personRepository.deleteById(id);
    }

}
