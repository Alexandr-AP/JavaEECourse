package by.internetbanking.controller;


import by.internetbanking.entity.Person;
import by.internetbanking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonRestController {
    public static void main(String[] args) {


    }


    @Autowired
    PersonService personService;


        @GetMapping (value = "/rest/person/list")
        public List<Person> uuu() {
            List<Person> people = personService.readAllPersons();
            System.out.println("u");
            return people;

        }
}
