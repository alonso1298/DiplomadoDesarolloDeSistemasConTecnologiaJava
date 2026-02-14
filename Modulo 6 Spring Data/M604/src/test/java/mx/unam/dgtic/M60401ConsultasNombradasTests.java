package mx.unam.dgtic;

import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class M60401ConsultasNombradasTests {

	final String ALUMNO = "SAGRERO GRANADOS ALONSO";

	@Autowired
	IAlumnoRepository respositorioAlumno;

	@Test
	@DisplayName("Buscar alumnos altos >= 1.70")
	void buscarAltosTest(){
		System.out.println(ALUMNO);
		System.out.println("Buscar alumnos altos que son >= 1.70");
		respositorioAlumno.buscarAltos().forEach(a->{
			System.out.println(a.getNombre() + " " + a.getPaterno()
				+ " " + a.getEstatura());
		});
	}

}
