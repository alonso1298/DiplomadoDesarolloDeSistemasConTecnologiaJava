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
        for(IActividades actividades:empleado.getActividades()) {
            actividades.realizar();
        }

        System.out.println("-----------------------------------------------");
        Empleado empleadoDos = contexto.getBean("empleadoDos", Empleado.class);
        System.out.println(empleadoDos);
        for(IActividades actividades:empleadoDos.getActividades()) {
            actividades.realizar();
        }

        System.out.println("-----------------------------------------------");
        EmpleadoM empleadoTres = contexto.getBean("empleadoTres", EmpleadoM.class);
        System.out.println(empleadoTres);
        for(String llave:empleadoTres.getActividades().keySet()){
            System.out.println("Llave: " + llave);
            empleadoTres.getActividades().get(llave).realizar();
        }

        System.out.println("-----------------------------------------------");
        EmpleadoP empleadoCuatro = contexto.getBean("empleadoCuatro", EmpleadoP.class);
        System.out.println(empleadoCuatro);
        for (Iterator<Object> iter = empleadoCuatro.getActividades().keySet().iterator();
                iter.hasNext();){
            String llave = (String) iter.next();
            System.out.println("Llave: " + llave);
            System.out.println(empleadoCuatro.getActividades().get(llave));
        }

        ((ClassPathXmlApplicationContext) contexto).close();
    }
}
