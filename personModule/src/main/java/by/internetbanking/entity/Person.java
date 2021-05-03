package by.internetbanking.entity;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table //(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson")
    int id;

    @Column(name = "person_name")
    String name;

    @Column(name = "person_age")
    int age;

//    @OneToOne (mappedBy = "personInside")
//    private Passport passport;
//
//    @OneToMany (mappedBy = "personInsidePhones")
//    private Set<Phones> phones;


    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public Passport getPassport() {
//        return passport;
//    }
//
//    public void setPassport(Passport passport) {
//        this.passport = passport;
//    }
}
