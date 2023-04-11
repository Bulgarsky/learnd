package com.example.securityapp.services;

import com.example.securityapp.models.Person;
import com.example.securityapp.repositories.PersonRepository;
import com.example.securityapp.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //получаем пользователя из таблицы по лоигну с форму Auth
        Optional<Person> person = personRepository.findByLogin(username);
        //проверка: найден ли пользователь
        if(person.isEmpty()){
            //не найден, выбросить исключение
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return new PersonDetails(person.get());
    }
}
