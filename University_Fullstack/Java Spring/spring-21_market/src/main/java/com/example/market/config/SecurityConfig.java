package com.example.market.config;

//import com.example.securityapp.security.AuthenticationProvider;
import com.example.market.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    /*
    @Bean
    public PasswordEncoder getPasswordEncode(){
        return NoOpPasswordEncoder.getInstance();
    }
     */
    @Bean
    public PasswordEncoder getPasswordEncode(){
        return new BCryptPasswordEncoder();
    }

    //конфиг
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //конфиг работы Spring Security

        //отключаем CSRF токены (защиту от межсайтовой подделки запросов) для тестов:
        //http.csrf().disable()
        http
                .authorizeHttpRequests() //указание что все старницы длж б защищеты Auth
                //какие страницы доступны всем и на обьект ошибки

                //БЕЗ РОЛЕЙ
                /*
                .requestMatchers("/auth", "/reg","/error").permitAll()
                //для остальных страниц - вызвать метод Auth:
                .anyRequest().authenticated()
                 */

                //ПОСЛЕ ДОБАВЛЕНИЯ РОЛЕЙ
                //настрйока доступа к странице для роли ADMIN (префикс отбрасывается)
                .requestMatchers("/admin").hasRole("ADMIN")
                //настройка доступа страницам для других ролей
                .requestMatchers("/auth", "/reg", "/error", "/resources/**", "/static/**", "/css/**", "js/**", "img/**").permitAll()
                //настройка доступа к остальным страницам для ролей
                .anyRequest().hasAnyRole("USER", "ADMIN")

                .and() //соединить компоненты в рамках одного кофнига
                //на какой url -> будет оптравляться запрос при входе на защищ.стр.
                .formLogin().loginPage("/auth")
                //на какой url будет отпр. данные с формы(не нужно создавать метов в контроллере и обрабатывать данные с формы. Задали default url  дял обработки формы Auth средствами Spring Security. Security будет ожидать obj и сверять лоигн и пароль в БД):
                .loginProcessingUrl("/process_login")
                //на какой url необходимо направить после успешной Auth. True - чтоы редирект был в любом случае после успеха Auth
                .defaultSuccessUrl("/index", true)
                //куда делать редирект после провала Auth. В запрос будет передан obj error, который  будет проверятся на форме и при наличии, будет выводтся сообщение
                .failureUrl("/auth?error")
                .and()
                //настройка выхода из аккаунта, редирект (удалеяется сессия)
                .logout().logoutUrl("/logout").logoutSuccessUrl("/auth");

        return http.build();

        //before login
//        Idea-52a553a3=3865262a-b47a-4670-a33d-514f5a2f7457;
//        JSESSIONID=3C3315A7A9C1CD16DB9612E646F03694

        //Logout
//        Idea-52a553a3=3865262a-b47a-4670-a33d-514f5a2f7457;
//        JSESSIONID=1DA1FB46627AE73930DBC94E2AD1CE47
    }


    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{

        //так же будет ошибка, тк в БД ключ не зашифрованы бикрипт (нужно отключить )
        //AuthenticationProvider (все что было в логике, вся проверка под копотом Spring Security) :
        authenticationManagerBuilder.userDetailsService(personDetailsService)
                //вызываем метод хеширования
                .passwordEncoder(getPasswordEncode());
    }
}

