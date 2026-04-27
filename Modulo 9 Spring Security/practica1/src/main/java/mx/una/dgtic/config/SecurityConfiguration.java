package mx.una.dgtic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(auth -> auth
                        // Recursos publicos
                        .requestMatchers(
                                "/login",
                                "/bootstrap/**",
                                "/tema/**",
                                "/image/**",
                                "/iconos/**"
                        ).permitAll()
                        // Página pública
                        .requestMatchers("/").permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login") // login personalizado
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/", true) // direccion de donde va después del login
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                );
        return http.build();
    }
}
