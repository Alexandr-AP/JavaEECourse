//package by.internetbanking.entity;//package by.internetbanking.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table
//public class Phones {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_phone")
//    int phone_id;
//    @Column
//    String number;
//    @ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "person_fk", referencedColumnName = "idperson")
//    Person personInsidePhones;
//
//    public Phones() {
//    }
//
//    public Phones(String number, Person personInsidePhones) {
//        this.number = number;
//        this.personInsidePhones = personInsidePhones;
//    }
//
//    public Phones(int phone_id, String number, Person personInsidePhones) {
//        this.phone_id = phone_id;
//        this.number = number;
//        this.personInsidePhones = personInsidePhones;
//    }
//
//    public int getPhone_id() {
//        return phone_id;
//    }
//
//    public void setPhone_id(int phone_id) {
//        this.phone_id = phone_id;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public Person getPersonInsidePhones() {
//        return personInsidePhones;
//    }
//
//    public void setPersonInsidePhones(Person personInsidePhones) {
//        this.personInsidePhones = personInsidePhones;
//    }
//}
