package mx.unam.dgtic;

import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.testng.annotations.Test;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableMongoRepositories(basePackages = "mx.unam.dgtic")
public class M605101FindMongoTest {

    final String ALUMNO = "ALONSO SAGRERO GRANADOS";
    final String ID = "66ef0dd83567dbd62d9714eb";
    final String PATERNO = "RIOS";

    @Autowired
    IAlumnoRepository repositorioAlumno;

    @Test
    @DisplayName("Buscar todos los alumnos Mongo")
    void buscarTodosTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar todos los alumnos Mongo");

        System.out.println("Total de alumnos en Mongo" + repositorioAlumno.count());
        repositorioAlumno.findAll().forEach(System.out::println);
    }
}
