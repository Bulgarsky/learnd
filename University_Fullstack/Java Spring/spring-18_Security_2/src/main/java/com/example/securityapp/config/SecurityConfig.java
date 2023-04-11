package com.example.securityapp.config;

//import com.example.securityapp.security.AuthenticationProvider;
import com.example.securityapp.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{
    private final PersonDetailsService personDetailsService;
    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    //параметр позвол. не шифровать пароли (только для теста):
    @Bean
    public PasswordEncoder getPasswordEncode(){
        return NoOpPasswordEncoder.getInstance();
    }

    //конфиг
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //конфиг работы Spring Security

        //отиключаем CSRF токены (защиту от межсайтовой подделки запросов):
        http.csrf().disable()
                .authorizeHttpRequests() //указание что все старницы длж б защищеты Auth
                //какие страницы доступны всем и на обьект ошибки
                .requestMatchers("/auth", "/reg","/error").permitAll()
                //для остальных страниц - вызвать метод Auth:
                .anyRequest().authenticated()
                .and() //соединить компоненты в рамках одного кофнига
                //на какой url -> будет оптравляться запрос при входе на защищ.стр.
                .formLogin().loginPage("/auth")
                //на какой url будет отпр. данные с формы(не нужно создавать метов в контроллере и обрабатывать данные с формы. Задали default url  дял обработки формы Auth средствами Spring Security. Security будет ожидать obj и сверять лоигн и пароль в БД):
                .loginProcessingUrl("/process_login")
                //на какой url необходимо направить после успешной Auth. True - чтоы редирект был в любом случае после успеха Auth
                .defaultSuccessUrl("/index", true)
                //куда делать редирект после провала Auth. В запрос будет передан obj error, который  будет проверятся на форме и при наличии, будет выводтся сообщение
                .failureUrl("/auth?error");

        return http.build();
    }


    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{

        //так же будет ошибка, тк в БД ключ не зашифрованы бикрипт
        //AuthenticationProvider (все что было в логике, вся проверка под копотом Spring Security) :
        authenticationManagerBuilder.userDetailsService(personDetailsService);
    }
}

