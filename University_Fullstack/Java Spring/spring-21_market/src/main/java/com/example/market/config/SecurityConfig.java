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

    @Bean
    public PasswordEncoder getPasswordEncode(){
        return new BCryptPasswordEncoder();
    }

    //конфиг
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //конфиг работы Spring Security

        http
                .authorizeHttpRequests()
                //настройка доступа к странице для роли ADMIN (префикс ROLE_ отбрасывается)
                .requestMatchers("/admin","/admin/terminal", "/admin/users", "/admin/orders", "/admin/products", "/terminal/**").hasRole("ADMIN")
                //настройка доступа страницам для других ролей
                .requestMatchers("/", "/notauth", "/notauth/**","notauth/search/**", "/index", "/index/search", "/auth", "/reg", "/error", "/resources/**", "/static/**", "/css/**","/svg/**", "/js/**", "/img/**", "/product/info/{id}", "/search/**", "/404", "/404/**").permitAll()
                //настройка доступа к остальным страницам для ролей
                .anyRequest().hasAnyRole("USER", "ADMIN", "SELLER")
                .and() //соединить компоненты в рамках одного кофнига, дальше идет аутент
                //на какой url -> будет оптравляться запрос при входе на защищ.стр.
                .formLogin().loginPage("/auth")
                //на какой url будет отпр. данные с формы(не нужно создавать метов в контроллере и обрабатывать данные с формы. Задали default url для обработки формы Auth средствами Spring Security. Security будет ожидать obj и сверять логин и пароль в БД):
                .loginProcessingUrl("/login")
                //на какой url необходимо направить после успешной Auth. True - чтоы редирект был в любом случае после успеха Auth
                .defaultSuccessUrl("/my", true)
                //куда делать редирект после провала Auth. В запрос будет передан obj error, который будет проверятся на форме и при наличии, будет выводтся сообщение
                .failureUrl("/auth?error")
                .and()
                //настройка выхода из аккаунта, редирект (удаляется сессия)
                .logout().logoutUrl("/logout").logoutSuccessUrl("/");

        return http.build();
    }


    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(personDetailsService)
                .passwordEncoder(getPasswordEncode());
    }
}

