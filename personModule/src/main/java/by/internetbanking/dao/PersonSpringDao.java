package by.internetbanking.dao;

import by.internetbanking.entity.Person;

import java.util.List;

public class PersonSpringDao implements PersonDao {
    @Override
    public void createPerson(Person person) {

    }

    @Override
    public void createPerson(String name, int age) {


       // String sql="insert into Emp99(name,salary,designation) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";

        //template.update(sql);

        }

    @Override
    public Person readPersonById(int id) {
        return null;
    }

    @Override
    public List<Person> readAllPersons() {
        return null;
    }

    @Override
    public void updatePersonById(int id, String nameNew, int ageNew) {

    }

    @Override
    public void updatePerson(Person personUpdated) {

    }

    @Override
    public void deletePersonById(int id) {

    }
}
