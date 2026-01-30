package dgtic.core.inicio;

import dgtic.core.modelo.Empleado;
import dgtic.core.servicio.Servicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto=
                new ClassPathXmlApplicationContext(new String[] {
                        "bean-configuration.xml",
                        "bean-service.xml"});
        Empleado empleado=contexto.getBean("empleado", Empleado.class);
        System.out.println("-------------");
        Servicio servicio=contexto.getBean("servicio", Servicio.class);
        servicio.destruir();
        System.out.println("........");

        ((ClassPathXmlApplicationContext) contexto).close();
    }
}
