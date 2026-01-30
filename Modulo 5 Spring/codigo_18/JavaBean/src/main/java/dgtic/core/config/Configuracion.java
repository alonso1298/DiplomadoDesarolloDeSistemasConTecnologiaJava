package dgtic.core.config;

import dgtic.core.modelo.Persona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Configuracion {
    @Bean(name = "persona")
    @Scope("prototype")
    public Persona getPersona(){
        Persona persona=new Persona();
        persona.setNombre("Persona 1");
        persona.setEdad(23);
        return persona;
    }
}
