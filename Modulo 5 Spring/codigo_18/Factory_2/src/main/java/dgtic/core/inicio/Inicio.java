package dgtic.core.inicio;

import dgtic.core.servicio.IEmpleadoServicio;
import dgtic.core.servicio.IReporteEmpleadoServicio;
import dgtic.core.servicio.PredeterminadoServicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto =
                new ClassPathXmlApplicationContext(new String[] {
                        "bean-configuration.xml",
                        "bean-service.xml"});
        //factory-bean
        IEmpleadoServicio servUno=(IEmpleadoServicio) contexto.getBean("empleadoServicio");
        servUno.servicioEmpleado();
        IReporteEmpleadoServicio servDos=(IReporteEmpleadoServicio) contexto.getBean("empleadoServicioReporte");
        servDos.reporteDiario();
        System.out.println("----");
        PredeterminadoServicio servTres=(PredeterminadoServicio) contexto.getBean("servicioLocal");
        servTres.getEmpleadoServicio().servicioEmpleado();
        servTres.getReporteEmpleadoServicio().reporteDiario();
        
        ((ClassPathXmlApplicationContext) contexto).close();
    }
}
