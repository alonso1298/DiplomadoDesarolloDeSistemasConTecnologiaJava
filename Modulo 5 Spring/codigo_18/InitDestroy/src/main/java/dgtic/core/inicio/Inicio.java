package dgtic.core.inicio;

import dgtic.core.modelo.Empleado;
import dgtic.core.modelo.GestionProyectos;
import dgtic.core.modelo.PlanificacionProyectos;
import dgtic.core.modelo.Servicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto=
                new ClassPathXmlApplicationContext(new String[] {
                        "bean-configuration.xml"});
        Empleado empleado=contexto.getBean("empleado", Empleado.class);
        System.out.println(empleado);
        empleado.getActividades().realizar();
        ((GestionProyectos)empleado.getActividades()).setCantidad(10);
        System.out.println(((GestionProyectos)empleado.getActividades()).getCantidad());

        System.out.println("........");
        Empleado empleadoDos=contexto.getBean("empleadoDos", Empleado.class);
        System.out.println(empleadoDos);
        empleadoDos.getActividades().realizar();
        System.out.println(((GestionProyectos)empleadoDos.getActividades()).getCantidad());


        System.out.println("........");


        ((ClassPathXmlApplicationContext) contexto).close();
    }
}
