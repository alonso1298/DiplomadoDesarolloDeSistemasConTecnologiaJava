package dgtic.core.inicio;

import dgtic.core.config.Configuracion;
import dgtic.core.repository.BaseDeDatosDaoImpl;
import dgtic.core.repository.IBaseDeDatosDao;
import dgtic.core.servicio.ServicioDao;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Inicio {
    public static void main(String[] args) {
        ConfigurableApplicationContext contexto
                =new AnnotationConfigApplicationContext("dgtic.core");
        IBaseDeDatosDao datos = contexto.getBean("baseDeDatosDao", IBaseDeDatosDao.class);
        System.out.println(datos.getEstudiantes("ico"));
        System.out.println("................");
        ServicioDao servicioDao = contexto.getBean(ServicioDao.class);
        System.out.println(servicioDao.archivoCSV("ico"));
        System.out.println(servicioDao.archivoCSV("ime"));

        contexto.close();
    }
}
