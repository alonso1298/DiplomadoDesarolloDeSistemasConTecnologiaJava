package dgtic.core.spring_boot;

import dgtic.core.spring_boot.model.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {
	@Autowired
	Persona persona;

	@Test
	void contextLoads() {
		System.out.println(persona);
	}

	@Test
	void comparacion(){
		assertEquals("Persona1", persona.getNombre(), "Cadenas diferentes");
	}

}
