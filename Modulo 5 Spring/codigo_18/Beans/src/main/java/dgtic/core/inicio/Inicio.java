package dgtic.core.inicio;

import dgtic.core.modelo.Servicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto=
                new ClassPathXmlApplicationContext(new String[] {
                        "bean-configuration.xml",
                        "bean-service.xml" });
        Servicio ser=(Servicio)contexto.getBean("servicio");
        ser.getPersona().setNombre("Miguel");
        ser.getPersona().setEdad(23);

        System.out.println(ser.toString());
        ((ClassPathXmlApplicationContext) contexto).close();
    }
}
