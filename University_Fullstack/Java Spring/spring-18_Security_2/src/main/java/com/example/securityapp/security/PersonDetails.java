package com.example.securityapp.security;

import com.example.securityapp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class PersonDetails implements UserDetails {
    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }
    public Person getPerson(){
        return this.person;
    }


    //
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    //
    @Override
    public String getPassword() {
        return this.person.getPassword();
    }
    //
    @Override
    public String getUsername() {
        return this.person.getLogin();
    }

    //Метод: аккаунт действителен?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //Метод: аккаунт незаблокирован?
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //Метод: пароль действителен?
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //Метод: аккаунт активный или деактивирован ?
    @Override
    public boolean isEnabled() {
        return true;
    }
}
