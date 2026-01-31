package dgtic.core.spring_boot.configuration;

import dgtic.core.spring_boot.model.Persona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {

    @Bean
    public Persona getPersona(){
        Persona persona = Persona.builder()
                .nombre("Persona1")
                .edad(34)
                .build();
        return persona;
    }

}
