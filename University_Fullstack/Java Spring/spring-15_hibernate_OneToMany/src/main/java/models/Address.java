package models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String city;
    private String street;
    private String building;
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private List<Person> tenants;
}
