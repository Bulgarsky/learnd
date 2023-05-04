package com.example.market.services;

import com.example.market.models.Person;
import com.example.market.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        //хешированный пароль:
        person.setPassword((passwordEncoder.encode(person.getPassword())));
        //Установить роль пользователя при регистрации!
        person.setRole("ROLE_USER"); //+
        personRepository.save(person);
    }

    //получить список пользователей (работает)
    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    //получить пользователя по id для редактирования (работает)
    public Person getPersonId(int id){
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElse(null);
    }

    //обновить пользователя (не работает)
    @Transactional
    public void updatePerson(int id, Person person){
        person.setId(id);
        //person.setRole(person.getRole());
        personRepository.save(person);
    }
    //удалить пользователя из базы (работает)
    @Transactional
    public void deletePerson(int id){
        personRepository.deleteById(id);
    }

}
