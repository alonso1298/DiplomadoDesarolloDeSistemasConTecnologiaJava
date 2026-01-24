package dgtic.core.inicio;

import dgtic.core.modelo.Persona;
import dgtic.core.modelo.Proyecto;
import dgtic.core.modelo.Servicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto=
                new ClassPathXmlApplicationContext(new String[] {
                        "bean-configuration.xml",
                        "bean-service.xml" });
        // Unica logica de negocio
        Proyecto pro=(Proyecto)contexto.getBean("proyecto");
        Persona persona = contexto.getBean("persona", Persona.class);
        Persona persona1 = contexto.getBean("persona2", Persona.class);
        // Dentro del contenedor
        pro.getPersonas().add(persona);
        pro.getPersonas().add(persona1);
        // No esta dentro del contenedor
        pro.getPersonas().add(new Persona());

        System.out.println(pro.toString());

        ((ClassPathXmlApplicationContext) contexto).close();
    }
}
