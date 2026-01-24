package dgtic.core.inicio;

import dgtic.core.modelo.Persona;
import dgtic.core.modelo.TipoCarro;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto =
                new ClassPathXmlApplicationContext(new String[] {
                        "bean-configuration.xml",
                        "bean-service.xml"});
        Persona persona = contexto.getBean("persona", Persona.class);
        try {
            persona.getCoche().getModeloCoche(TipoCarro.DEPORTIVO).crear();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        ((ClassPathXmlApplicationContext) contexto).close();
    }
}
