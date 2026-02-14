package mx.unam.dgtic;

import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
	@DisplayName("NamedQuery: Buscar alumnos altos >= 1.70")
	void buscarAltosTest(){
		System.out.println(ALUMNO);
		System.out.println("Buscar alumnos altos que son >= 1.70");
		respositorioAlumno.buscarAltos().forEach(a->{
			System.out.println(a.getNombre() + " " + a.getPaterno()
				+ " " + a.getEstatura());
		});
	}

	@Test
	@DisplayName("NamedNativeQuery: Buscar alumnos altos mayor al promedio")
	void buscarAltosSqlTest(){
		System.out.println(ALUMNO);
		System.out.println("Buscar alumnos altos mayor al promedio que es "
			+ respositorioAlumno.estaturaPromedio());
		respositorioAlumno.buscarAltosMayorAlPromedio().forEach(a->{
			System.out.println(a.getNombre() + " " + a.getPaterno()
					+ " " + a.getEstatura());
		});
	}

	@ParameterizedTest
	@CsvSource({
			"DF, Ciudad de México",
			"NL, Nuevo León",
			"GT, Guanajuato",
			"GR, Guerrero"
	})
	void buscarPorEstadoCurpTest(String codigoEstado, String nombreEstado){
		System.out.println(ALUMNO);
		System.out.println(nombreEstado + " " + codigoEstado);

		System.out.println("Total de alumnos en el estado " + nombreEstado + " " +
				respositorioAlumno.contarPorEstadoCurp(codigoEstado));
		respositorioAlumno.buscarPorEstadoCurp(codigoEstado).forEach(a->{
			String estadoStr = (a.getEstado() != null) ? a.getEstado().getEstado() : "null";
			System.out.println(
					a.getNombre() + " " + a.getPaterno() + " "
					+ a.getCurp() + " " + estadoStr);
		});
	}
}
