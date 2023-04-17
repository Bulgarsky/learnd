/*
package com.example.securityapp.security;

import com.example.securityapp.services.PersonDetailsService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {
    private final PersonDetailsService personDetailsService;

    public AuthenticationProvider(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       //поулчение логина с формы Auth  и передача в obj authentication
        String login = authentication.getName();

        //т.к. метод взвращает объект интерфейса UserDetails то и обект мы созлаем через интерфейс
        UserDetails person = personDetailsService.loadUserByUsername(login);

        String password = authentication.getCredentials().toString();
        if(!password.equals(person.getPassword())) {
            throw  new BadCredentialsException("Некорректный пароль");
        }
        return new UsernamePasswordAuthenticationToken(person, password, Collections.emptyList());
    }


    //можно указать в каких случаях будет использоваться провайдер
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
*/
