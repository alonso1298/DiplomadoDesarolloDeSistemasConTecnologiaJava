package mx.unam.dgtic;

import mx.unam.dgtic.entities.Alumno;
import mx.unam.dgtic.entities.Calificacion;
import mx.unam.dgtic.repositories.IAlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DataTestAlumno {
    @Autowired
    IAlumnoRepository alumnoRepository;

    @Test
    void testInsertAlumno(){
        Alumno alumno = new Alumno(null, "Jose", "Hernandez", "j@gmail.com", null);
        Alumno guardado = alumnoRepository.save(alumno);
        System.out.println(guardado);
        // asserts
        assertNotNull(guardado.getId());
    }

    @Test
    void testInsertaAlumnoSinCals(){
        Alumno alumno = new Alumno(
                null,
                "Daniel",
                "Solar",
                "daniel@gmail.com",
                new ArrayList<>()
        );
        Alumno guardado = alumnoRepository.save(alumno);
        System.out.println(guardado);
        assertNotNull(guardado.getId());
        assertNotNull(guardado);
        assertEquals("Daniel", guardado.getNombre());
        //
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(guardado.getId());
        assertNotNull(alumnoOptional.isPresent());
    }

    @Test
    void testInsertarConCalificacion(){
        Alumno alumno = new Alumno(
                null,
                "Ariadna",
                "Grande",
                "ag@gmail.com",
                null
        );
        Calificacion cal1 = new Calificacion(null, "Java", 10.0, alumno);
        Calificacion cal2 = new Calificacion(null, "Historia", 8.0, alumno);
        Calificacion cal3 = new Calificacion(null, "Deportes", 7.0, alumno);
        alumno.setCalificaciones(List.of(cal1, cal2, cal3));
        Alumno guardado = alumnoRepository.save(alumno);
        System.out.println(guardado);
        // asserts
        assertNotNull(guardado.getId());
        assertNotNull(guardado.getCalificaciones());
        assertEquals(3, guardado.getCalificaciones().size());

        Optional<Alumno> alumnoOptional = alumnoRepository.findById(guardado.getId());
        assertTrue(alumnoOptional.isPresent());
        assertEquals(3, alumnoOptional.get().getCalificaciones().size());
        assertEquals("Ariadna", alumnoOptional.get().getNombre());

        //Verifica las 3 calificaciones
        // Iterar con streams
    }

    @Test
    void testObtenerTodos(){
        // insertar alumnos de Unit test
        List<Alumno> alumnos = alumnoRepository.findAll();
        assertNotNull(alumnos);
        assertTrue(alumnos.size() > 0);
        System.out.println(alumnos);
    }
}
