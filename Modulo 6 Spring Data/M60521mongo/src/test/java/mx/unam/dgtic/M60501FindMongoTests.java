package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;
import mx.unam.dgtic.repository.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Optional;


@SpringBootTest
class M60501FindMongoTests {
	final String ALUMNO = "OMAR MENDOZA GONZALEZ";
	final String ID = "19770626"; //66ef0dd83567dbd62d9714d8
	final String MATRICULA = "MT1";

	@Autowired
	AlumnoRepository repositorioAlumno;

	@Autowired
	MongoTemplate mongoTemplate;

	@Test
	void buscarTodosTest(){
		System.out.println(ALUMNO);
		System.out.println("Buscar todos los alumnos en MongoDB");
		System.out.println("Total de alumnos en MongoDB " + repositorioAlumno.count());
		repositorioAlumno.findAll().forEach(System.out::println);
	}

	@Test
	void buscarUnoTest(){
		System.out.println(ALUMNO);
		System.out.println("Buscar alumno por ID");

		Optional<Alumno> optional = repositorioAlumno.findById(ID);
		if(optional.isPresent()){
			Alumno a = optional.get();
			System.out.println("Nombre: " + a.getNombre() );
			System.out.println("Paterno: " + a.getPaterno() );
			System.out.println("Años: " + a.getEdad().getAnios() );
			System.out.println("Evaluaciones:");
			a.getEvaluaciones().forEach(e ->
							System.out.println(e.getMateria() + " " + e.getCalificacion() + " " + e.getFecha())
					);
		}
	}

}
