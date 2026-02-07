package mx.unam.dgtic;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})
class M600ApplicationTests {

	final String ALUMNO = "SAGRERO GRANADOS ALONSO";
	@Test
	void contextLoads() {
		System.out.println(ALUMNO);
		System.out.println("Cargar esquema y datos");
	}

}
