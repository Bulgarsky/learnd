package com.example.market.services;

import com.example.market.enumm.Role;
import com.example.market.models.Person;
import com.example.market.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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

    //найти пользователя по логину
    public Person findByLogin(Person person){
        Optional<Person> person_db = personRepository.findByLogin(person.getLogin());
        return person_db.orElse(null);
    }

    //регистрация
    @Transactional
    public void register(Person person){
        //хешированный пароль:
        person.setPassword((passwordEncoder.encode(person.getPassword())));
        //Установить роль пользователя при регистрации!
        person.setRole("ROLE_USER"); //+
        personRepository.save(person);
    }

    //получить список пользователей для админа (работает)
    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    //получить пользователя по id для редактирования для админа (работает)
    public Person getPersonId(int id){
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElse(null);
    }

    //обновить пользователя для админа (не работает)
    public void setPersonNewRole(int id, Person person, Role newRole){
        Person personUpdate = getPersonId(id);
        personUpdate.setLogin(person.getLogin());
        personUpdate.setPassword(person.getPassword());
        personUpdate.setRole(newRole.toString());
        personRepository.save(personUpdate);
    }

    //удалить пользователя из базы для админа (работает)
    @Transactional
    public void deletePerson(int id){
        personRepository.deleteById(id);
    }

}















