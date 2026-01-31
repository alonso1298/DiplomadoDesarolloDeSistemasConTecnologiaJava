package dgtic.core.config;

import org.springframework.context.annotation.*;

@Configuration
@ImportResource(locations = {"classpath:bean-configuration.xml"})
@ComponentScan(basePackages = "dgtic.core") // Se realiza un escano apartir de esa clase
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
