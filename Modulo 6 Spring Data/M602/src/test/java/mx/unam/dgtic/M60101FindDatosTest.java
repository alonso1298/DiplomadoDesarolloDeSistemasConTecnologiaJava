package mx.unam.dgtic;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class M60101FindDatosTest {

    final String ALUMNO = "SAGRERO GRANADOS ALONSO";

    @Autowired
    IAlumnoRepository repositorioAlumno;

    @Test
    void buscarTodosTest(){
        System.out.println(ALUMNO);
        System.out.println("Listar todos los alumnos");

        Iterable<Alumno> alumnos = repositorioAlumno.findAll();
        alumnos.forEach(System.out::println);
    }

    @Test
    void buscarUnoTest(){
        String matricula = "4A";
        System.out.println(ALUMNO);
        System.out.println("Buscar alumno con matrcula " + matricula);

        Optional<Alumno> optional = repositorioAlumno.findById(matricula);
        if (optional.isPresent()){
            Alumno alumno = optional.get();
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Paterno: " + alumno.getPaterno());
            System.out.println("Fnac: " + alumno.getFnac());
            System.out.println("Estatura: " + alumno.getEstatura());
        }else {
            System.out.println(matricula + " no utilizada");
        }
    }

    @Test
    void buscarVariosTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar alumnos en una lista de matriculas");

        repositorioAlumno.findAllById(List.of("2A", "3B", "1F")).forEach(a -> {
            System.out.println(a.getMatricula() + " " + a.getNombre() + " " + a.getPaterno() + " " + a.getFnac() + " " + a.getEstatura());
        });
    }
}
