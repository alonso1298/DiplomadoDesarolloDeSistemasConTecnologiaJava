package dgtic.core.inicio;

import dgtic.core.modelo.Persona;
import dgtic.core.modelo.Servicio;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
