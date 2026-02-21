package mx.unam.dgtic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})
class M600ApplicationTests {

    final String ALUMNO ="Calderón Díaz Antoni Jair";
	@Test
	void contextLoads() {
        System.out.println(ALUMNO);
        System.out.println("Cargar esquema y datos");
	}

}
