package by.internetbanking.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "passport")
//public class Passport {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_passport")
//    private int idPassport;
//
//    @Column(name = "serial_number")
//    private String serialNumber;
//
//    @Column
//    private String name;
//
//    @Column
//    private String adress;
//
//    @OneToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_person_fk", referencedColumnName = "idperson")
//    private Person personInside;
//
//
//    public Passport() {
//    }
//
//    public Passport(String serialNumber, String name, String adress) {
//        this.serialNumber = serialNumber;
//        this.name = name;
//        this.adress = adress;
//    }
//
//    public Passport(int idPassport, String serialNumber, String name, String adress) {
//        this.idPassport = idPassport;
//        this.serialNumber = serialNumber;
//        this.name = name;
//        this.adress = adress;
//    }
//
//    public int getIdPassport() {
//        return idPassport;
//    }
//
//    public void setIdPassport(int idPassport) {
//        this.idPassport = idPassport;
//    }
//
//    public String getSerialNumber() {
//        return serialNumber;
//    }
//
//    public void setSerialNumber(String serialNumber) {
//        this.serialNumber = serialNumber;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAdress() {
//        return adress;
//    }
//
//    public void setAdress(String adress) {
//        this.adress = adress;
//    }
//
//    public Person getPersonInside() {
//        return personInside;
//    }
//
//    public void setPersonInside(Person personInside) {
//        this.personInside = personInside;
//    }
//}

