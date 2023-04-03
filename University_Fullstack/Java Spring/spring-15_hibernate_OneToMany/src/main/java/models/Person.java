package models;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Address address;


}
