package mx.unam.dgtic;

import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class M60402ConsultasNombradasConJoinTests {

	final String ALUMNO = "SAGRERO GRANADOS ALONSO";

	@Autowired
	IAlumnoRepository respositorioAlumno;

	@Test
	@DisplayName("Buscar alumnos sin calificacion")
	void buscarSinCalificacionTest(){
		System.out.println(ALUMNO);
		System.out.println("Buscar alumnos altos que son >= 1.70");
		respositorioAlumno.buscarSinCalificacion().forEach(a->{
			System.out.println(a.getNombre() + " " + a.getPaterno()
				+ " " + a.getEstatura());
		});
	}
	@Test
	@DisplayName("Buscar alumnos con rerpbacion")
	void buscarAlumnosConReprobacion(){
		System.out.println(ALUMNO);
		System.out.println("Buscar alumnos CON reprobacion");
		respositorioAlumno.buscarConReprobacion().forEach(a->{
			System.out.println(a.getNombre() + " " + a.getPaterno()
					+ " " + a.getCurp());
			a.getCalificaciones().forEach(c->{
				if (c.getCalificacion() < 6){
					System.out.println(c.getMateria() + " " + c.getCalificacion());
				}
			});
		});
	}
	@Test
	@DisplayName("Buscar en mas de un grupo")
	void buscarAlumnoEnMultiplesGruposTest(){
		System.out.println(ALUMNO);
		System.out.println("Buscar en mas de un grupo");
		respositorioAlumno.buscarEnMultiplesGrupos().forEach(a->{
			System.out.println(a.getNombre() + " " + a.getPaterno()
					+ " " + a.getCurp());
			a.getGrupos().forEach(g->{
				System.out.println(g.getId() + " " + g.getGrupo());
			});
		});
	}
	@ParameterizedTest
	@CsvSource({
			"Guerrero, Primero",
			"Guerrero, Tercero",
			"Guanajuato, Primero",
			"Guanajuato, Tercero"
	})
	@DisplayName("Buscar grupo y estado")
	void buscarPorGrupoYEstado(String estado, String grupo){
		System.out.println(ALUMNO);
		System.out.println("Buscar un grupo " + grupo + "estado " + estado);
		respositorioAlumno.buscarGrupoAndEstado(grupo, estado).forEach(a->{
			System.out.println(a.getNombre() + " " + a.getPaterno()
					+ " " + a.getEstado());
			a.getGrupos().forEach(g->{
				System.out.println(g.getId() + " " + g.getGrupo());
			});
		});
	}
}
