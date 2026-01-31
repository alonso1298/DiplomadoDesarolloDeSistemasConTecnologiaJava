package dgtic.core.inicio;

import dgtic.core.config.Configuracion;
import dgtic.core.modelo.Persona;
import dgtic.core.modelo.Telefono;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Inicio {
    public static void main(String[] args) {
        ConfigurableApplicationContext contexto
                =new AnnotationConfigApplicationContext(Configuracion.class); // se puede declarar tambine la ruta del proyecto "dgtic.core"
        Persona persona=contexto.getBean("persona",Persona.class);
        persona.setEdad(100);
        System.out.println(persona);
        Persona personaDos=contexto.getBean("persona",Persona.class);
        System.out.println(personaDos);

        Telefono telefono = contexto.getBean("telefono", Telefono.class);
        contexto.close();
    }
}
