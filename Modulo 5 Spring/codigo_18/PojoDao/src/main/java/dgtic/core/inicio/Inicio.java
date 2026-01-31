package dgtic.core.inicio;

import dgtic.core.config.Configuracion;
import dgtic.core.repository.BaseDeDatosDaoImpl;
import dgtic.core.repository.IBaseDeDatosDao;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Inicio {
    public static void main(String[] args) {
        ConfigurableApplicationContext contexto
                =new AnnotationConfigApplicationContext(BaseDeDatosDaoImpl.class); // se puede declarar tambine la ruta del proyecto "dgtic.core"
        IBaseDeDatosDao datos = contexto.getBean("baseDeDatosDao", IBaseDeDatosDao.class);
        System.out.println(datos.getEstudiantes("ico"));

        contexto.close();
    }
}
