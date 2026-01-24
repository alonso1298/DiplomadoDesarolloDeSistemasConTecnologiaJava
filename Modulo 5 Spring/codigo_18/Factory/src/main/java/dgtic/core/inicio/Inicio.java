package dgtic.core.inicio;

import dgtic.core.modelo.Empleado;
import dgtic.core.modelo.EmpleadoM;
import dgtic.core.modelo.EmpleadoP;
import dgtic.core.modelo.IActividades;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;


public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto =
                new ClassPathXmlApplicationContext(new String[] {
                        "bean-configuration.xml"});
        Empleado empleado = contexto.getBean("empleado", Empleado.class);
        System.out.println(empleado);
        if (empleado.getActividades()!=null){
            empleado.getActividades().realizar();
        }
        System.out.println("--------------------");

        ((ClassPathXmlApplicationContext) contexto).close();
    }
}
