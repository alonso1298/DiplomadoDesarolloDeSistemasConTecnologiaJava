package dgtic.core.config;

import dgtic.core.modelo.Persona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {

    @Bean(name = "Persona")
    public Persona getPersona(){
        Persona persona = new Persona();
        persona.setNombre("Persona 1");
        persona.setEdad(23);
        return persona;
    }
}
