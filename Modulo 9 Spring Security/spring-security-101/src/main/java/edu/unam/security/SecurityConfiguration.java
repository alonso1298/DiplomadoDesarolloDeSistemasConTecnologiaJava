package edu.unam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.SecureRandom;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // metodo de configuracion del chain of responsability
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // autorizar mis endopoints
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("auth/welcome").authenticated()
                        .requestMatchers("/user").hasAnyRole("USER")
                        .requestMatchers( "/admin").hasAnyRole("ADMIN")
                        .requestMatchers("/static", "/css/**", "/", "/index").permitAll()
                        // Para cualquier endopoint
                        // .requestMatchers("/auth/**")
                        .anyRequest().authenticated() // Es zero trust fuerte
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(
                        //Customizer.withDefaults()
                        (FormLoginConfigurer<HttpSecurity> login) -> login
                                .usernameParameter("usuario")
                                .passwordParameter("contrasenia")
                                .defaultSuccessUrl("/")
                                .permitAll()
                        )
                .logout(
                        (LogoutConfigurer<HttpSecurity> logout) -> logout
                                .logoutSuccessUrl("/")
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        //Escuela
        /*UserDetails userDetails = new User("pepe", "sanchez",
                true, true, true,
                true,
                Collections.singletonList(new SimpleGrantedAuthority("Admin")));
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();*/

        UserDetails userDetails = User.withUsername("pepe")
                . password ("{scrypt}sanchez") // esta codificado?
                . roles ("USER")
                .build ();

        String secret = "misecreto";
        int iteration = 1232435456;
        int keyLength = 256;
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder
                = new Pbkdf2PasswordEncoder(secret, iteration, keyLength);
        String password = pbkdf2PasswordEncoder.encode ( "123456");

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11, new SecureRandom());
        String encodePassword = encoder.encode("12345");
        System.out.println(encodePassword);


        //Builder
        UserDetails userDetails2 = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123456")
                .roles("ADMIN")// esta codificados?
                .build();

        return new InMemoryUserDetailsManager(userDetails, userDetails2);
    }

}
