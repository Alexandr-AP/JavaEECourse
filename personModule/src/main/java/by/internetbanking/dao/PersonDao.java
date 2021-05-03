package by.internetbanking.dao;

import by.internetbanking.entity.Person;

import java.util.List;

public interface PersonDao {

    void createPerson(Person person);

    void createPerson(String name, int age);

    Person readPersonById(int id);

    List<Person> readAllPersons();

    void updatePersonById(int id, String nameNew, int ageNew);

    void updatePerson(Person personUpdated);

    void deletePersonById(int id);

}
