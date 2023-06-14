package com.example.market.util;

import com.example.market.models.Person;
import com.example.market.services.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidate implements Validator {
    private final PersonService personService;

    public PersonValidate(PersonService personService) {
        this.personService = personService;
    }

    //указываем для какой модели предназначен данный валидатор
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    //проверяем наличие аккаунта
    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if(personService.findByLogin(person) != null){
            errors.rejectValue("login", "", "Данный пользователь уже зарегистрирован!");
        }
    }

}
