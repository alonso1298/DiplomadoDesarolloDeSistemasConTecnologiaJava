package dgtic.core.inicio;

import dgtic.core.modelo.Empleado;
import dgtic.core.modelo.PlanificacionProyectos;
import dgtic.core.modelo.Servicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto =
                new ClassPathXmlApplicationContext(new String[] {
                        "bean-configuration.xml"});
        Empleado empleado = contexto.getBean("empleado", Empleado.class);
        System.out.println(empleado);

        /* PlanificacionProyectos planificacionProyectos = new PlanificacionProyectos();
        empleado.setActividades(planificacionProyectos); */

        empleado.getActividades().realizar();

        System.out.println("..................");
        Empleado empleadoDos = contexto.getBean("empleadoDos", Empleado.class);
        System.out.println(empleadoDos);
        empleadoDos.getActividades().realizar();

        ((ClassPathXmlApplicationContext) contexto).close();
    }
}
