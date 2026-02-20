package mx.unam.dgtic;

import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class M60501ConsultasNombradasGroupTests {

	final String ALUMNO = "SAGRERO GRANADOS ALONSO";

	@Autowired
	IAlumnoRepository respositorioAlumno;

	@Test
	@DisplayName("Buscar con DSTINCT")
	void buscarDistinctTest(){
		System.out.println(ALUMNO);
		System.out.println("Buscar con DISTINCT");
		respositorioAlumno.findDistinctNombre().forEach(System.out::println);

		System.out.println("Buscar con DSTINCT paterno");
		respositorioAlumno.findDistinctPaterno().forEach(System.out::println);

	}

	@Test
	@DisplayName ("Consultas con GROUP BY")
	void buscarGroupByTest() {
		System.out.println(ALUMNO);
		System.out.println("Contar por nombre");
		respositorioAlumno.contarPorNombre().forEach(cp->{
			System.out.println(cp.getCampo() + " " + cp.getConteo());
		});

		System.out.println("Contar por Anio");
		respositorioAlumno.contarPorAnio().forEach(cp->{
			System.out.println(cp.getCampo() + " " + cp.getConteo());
		});

		System.out.println("Contar por Sexo");
		respositorioAlumno.contarPorSexo().forEach(cp->{
			System.out.println(cp.getCampo() + " " + cp.getConteo());
		});
	}

	@ParameterizedTest
	@CsvSource({
			"'^.{10}M.{7}$', 'Buscar Mujeres'",
			"'^.{10}H.{7}$', 'Buscar Hombres'",
			"'^(?![A-Z]{4}\\d{6}[HM][A-Z]{5}\\d{2}).*$', 'CURP no válidos'"
	})
	@DisplayName("Buscar por CURP REGXP")
	void BuscarCurpRegextTest(String regex, String descripcion){
		System.out.println(ALUMNO);
		System.out.println(descripcion + " " + regex);
		respositorioAlumno.buscarByCurpRegex(regex).forEach(a->{
			System.out.println(a.getCurp() + " " + a.getNombre() + " " + a.getPaterno());
		});
	}
}
