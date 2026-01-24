package dgtic.core.inicio;

import dgtic.core.modelo.Empleado;
import dgtic.core.modelo.IActividades;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto =
                new ClassPathXmlApplicationContext(new String[] {
                        "bean-configuration.xml"});
        Empleado empleado = contexto.getBean("empleado", Empleado.class);
        System.out.println(empleado);
        for(IActividades actividades:empleado.getActividades()) {
            actividades.realizar();
        }

        System.out.println("-----------------------------------------------");
        Empleado empleadoDos = contexto.getBean("empleadoDos", Empleado.class);
        System.out.println(empleadoDos);
        for(IActividades actividades:empleadoDos.getActividades()) {
            actividades.realizar();
        }

        ((ClassPathXmlApplicationContext) contexto).close();
    }
}
