package mx.unam.dgtic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})
class M600ApplicationTests {

	final String ALUMNO = "SAGRERO GRANADOS ALONSO";
	@Test
	void contextLoads() {
		System.out.printf(ALUMNO);
		System.out.println("Cargar esquema y datos");
	}

}
