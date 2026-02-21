package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;
import mx.unam.dgtic.datos.Edad;
import mx.unam.dgtic.datos.Evaluacion;
import mx.unam.dgtic.repository.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class M60501FindMongoTests {
	final String ALUMNO = "ALONSO SAGRERO GRANADOS";
	final String ID = "112121998"; //66ef0dd83567dbd62d9714d8
	final String MATRICULA = "ASG";

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
	@Test
	void insertarUnoTest(){
		System.out.println(ALUMNO);
		System.out.println("Total de alumnos en MongoDB " + repositorioAlumno.count());
		System.out.println("Insertar Alumno");
		Alumno alumno = new
				Alumno(MATRICULA, "ALONSO", "SAGRERO", new Date(), 1.74);
		alumno.setId(ID);
		alumno.setEdad(new Edad(47, 8, 3));
		List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
		evaluaciones.add(new Evaluacion("JAVA", 9.1, new Date()));
		evaluaciones.add(new Evaluacion("SPRING", 8.9, new Date()));
		evaluaciones.add(new Evaluacion("POO", 9.9, new Date()));

		alumno.setEvaluaciones(evaluaciones);
		repositorioAlumno.save(alumno);

		Alumno guardado = repositorioAlumno.findById(ID).orElseThrow();
		System.out.println("Alumno Guardado " + guardado);

		System.out.println("Total de alumnos en MongoDB dspues de guardar "
				+ repositorioAlumno.count());
		repositorioAlumno.findAll().forEach(System.out::println);

	}
}
