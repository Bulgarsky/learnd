package com.example.securityapp.services;

import com.example.securityapp.models.Person;
import com.example.securityapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Person findByLogin(Person person){
        Optional<Person> person_db = personRepository.findByLogin(person.getLogin());
        return person_db.orElse(null);
    }

    @Transactional
    public void register(Person person){
        //херованный пароль:
        person.setPassword((passwordEncoder.encode(person.getPassword())));
        person.setRole("ROLE_USER"); //назначение всем роли USER
        personRepository.save(person);
    }
}
