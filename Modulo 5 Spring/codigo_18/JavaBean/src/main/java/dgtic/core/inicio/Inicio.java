package dgtic.core.inicio;

import dgtic.core.config.Configuracion;
import dgtic.core.modelo.Persona;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Inicio {
    public static void main(String[] args) {
        ConfigurableApplicationContext contexto
                =new AnnotationConfigApplicationContext(Configuracion.class);
        Persona persona=contexto.getBean("persona",Persona.class);
        System.out.println(persona);
        contexto.close();
    }
}
