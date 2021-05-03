package by.internetbanking.dao;

import by.internetbanking.entity.Person;
import by.internetbanking.repository.PersonRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonSpringJPADataDao implements PersonDao {
    @Autowired
    PersonRepository repository;

    @Override
    public void createPerson(Person person) {
        repository.save(person);
    }

    @Override
    public void createPerson(String name, int age) {
        Person person = new Person(name, age);
        repository.save(person);

    }

    @Override
    public Person readPersonById(int id) {
        Optional<Person> personOptional = repository.findById(id);
        Person person = personOptional.orElse(new Person("Null", -1));
        return person;
    }

    @Override
    public List<Person> readAllPersons() {
        Iterable<Person> people = repository.findAll();

        return (List<Person>) people;
    }

    @Override
    public void updatePersonById(int id, String nameNew, int ageNew) {
        Optional<Person> personOptional = repository.findById(id);
        Person person = personOptional.get();
        person.setName(nameNew);
        person.setAge(ageNew);
        repository.save(person);
    }

    @Override
    public void updatePerson(Person personUpdated) {

    }

    @Override
    public void deletePersonById(int id) {
        repository.deleteById(id);
    }
}
