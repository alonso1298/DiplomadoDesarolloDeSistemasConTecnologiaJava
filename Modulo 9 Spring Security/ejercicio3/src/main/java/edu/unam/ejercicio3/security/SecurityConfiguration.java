package edu.unam.ejercicio3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize.anyRequest().fullyAuthenticated())
                .formLogin(Customizer.withDefaults())
        ;
        return http.build();
    }

    /*@Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());
    }

    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource ldapContextSource = new LdapContextSource();
        ldapContextSource.setUrl("ldap://localhost:10389");
        ldapContextSource.setUserDn("uid=admin,ou=system");
        ldapContextSource.setPassword("secret");
        return ldapContextSource;
    }

    @Bean
    AuthenticationManager authManager(BaseLdapPathContextSource source) {
        LdapBindAuthenticationManagerFactory factory = new LdapBindAuthenticationManagerFactory(source);
        factory.setUserDnPatterns("cn={0},ou=users,ou=system");
        //factory.setUserDnPatterns("cn={0},ou=users");
        return factory.createAuthenticationManager();
    }*/

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:8389/dc=unam,dc=mx")
                .and()
                .passwordCompare()
                .passwordAttribute("userPassword");
    }
}
