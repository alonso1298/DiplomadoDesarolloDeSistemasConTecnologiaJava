package edu.unam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // metodo de configuracion del chain of responsability
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // autorizar mis endopoints
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("auth/welcome").permitAll()
                        // Para cualquier endopoint
                        // .requestMatchers("/auth/**")
                        .anyRequest().authenticated() // Es zero trust fuerte
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("pepe")
                .password("sanchez")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

}
