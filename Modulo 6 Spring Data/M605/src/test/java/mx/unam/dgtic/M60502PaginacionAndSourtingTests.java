package mx.unam.dgtic;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.projection.IConteoPorCampo;
import mx.unam.dgtic.repository.IAlumnoJpaRepository;
import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class M60502PaginacionAndSourtingTests {

	private final String ALUMNO = "SAGRERO GRANADOS ALONSO";
	private final int PAGE_SIZE  = 5;

	@Autowired
	IAlumnoJpaRepository respositorioAlumno;

	@Test
	@DisplayName("Buscar con DSTINCT")
	void buscarDistinctTest(){
		System.out.println(ALUMNO);

		System.out.println("Pagina 1 ordenada por nombre");
		Pageable pageable = PageRequest.of(
				0, PAGE_SIZE, Sort.by("nombre")
						.descending());
		Page<Alumno> page = respositorioAlumno.findAll(pageable);
		page.forEach(System.out::println);

		System.out.println("Pagina 1 ordenada por paterno");
		pageable = PageRequest.of(
				0, PAGE_SIZE, Sort.by("paterno")
						.descending());
		page = respositorioAlumno.findAll(pageable);
		page.forEach(System.out::println);

		System.out.println("Pagina 1 ordenada por estatura");
		pageable = PageRequest.of(
				0, PAGE_SIZE, Sort.by("estatura")
						.descending());
		page = respositorioAlumno.findAll(pageable);
		page.forEach(System.out::println);
	}

	@ParameterizedTest
	@ValueSource(strings = {
			"nombre", "paterno", "estatura", "fnac"
	})
	@DisplayName("Paginacion y ordenacion por campo")
	void buscarDistinctTest(String campo){
		System.out.println(ALUMNO);

		System.out.println("Pagina 1 ordenada por nombre");
		System.out.println("Pagina 1 ordenada por " + campo);
		Pageable pageable = PageRequest.of(
				0, PAGE_SIZE, Sort.by(campo)
						.descending());
		Page<Alumno> page;
		page = respositorioAlumno.findAll(pageable);
		page.forEach(System.out::println);
	}

	@Test
	@DisplayName("Navegar Paginas")
	void buscarDistinctPagiansTest(String campo){
		System.out.println(ALUMNO);

		Pageable pageable = PageRequest.of(
				0, PAGE_SIZE, Sort.by("nombre")
						.descending());
		Page<Alumno> page;
		do {
			page = respositorioAlumno.findAll(pageable);
			System.out.println("Total de alumnos: " + page.getNumberOfElements());
			page.forEach(System.out::println);
			analizarPagina(page);
			pageable = page.nextPageable();
		}while (page.hasNext());
	}

	@ParameterizedTest
	@ValueSource(strings = {
			"nombre", "paterno", "estatura", "fnac"
	})
	@DisplayName("Ordenamiento por campo")
	void buscarAllOrdenamientoTest(String campo){
		System.out.println(ALUMNO);
		System.out.println("Ordenado por " + campo);

		Sort sort = Sort.by(Sort.Direction.DESC, campo);
		List<Alumno> alumnos = respositorioAlumno.findAll(sort);
		alumnos.forEach(System.out::println);
	}

	@ParameterizedTest
	@CsvSource({
			"fnac,DESC,nombre,ASC",
			"fnac,ASC,nombre,DESC",
			"estatura,DESC,paterno,ASC",
			"nombre,ASC,fnac,DESC"
	})
	@DisplayName("Paginacion y oredenamiento combinado")
	void paginacionDeOrdenamientoCombina(String campo1, String dir1,
										 String campo2, String dir2){
		System.out.println(ALUMNO);
		System.out.println("Pagina 1 ordenada por " + campo1 + " " + dir1
				+ " y " + campo2 + " " + dir2
		);

		Sort sort = Sort.by(
				new Sort.Order(Sort.Direction.valueOf(dir1), campo1),
				new Sort.Order(Sort.Direction.valueOf(dir2), campo2)
		);

		Pageable pageable = PageRequest.of(
				0, PAGE_SIZE, sort);
		Page<Alumno> page;
		respositorioAlumno.findAll(pageable).forEach(System.out::println);
	}

	@Test
	@DisplayName("Contar por nombre Paginado")
	void contarPorNombreTest(){
		System.out.println(ALUMNO);
		System.out.println("Contar pro nombre");

		Sort sort = Sort.by(Sort.Direction.DESC, "conteo");

		Pageable pageable = PageRequest.of(0, PAGE_SIZE, sort);

		Page<IConteoPorCampo> page = respositorioAlumno.contarPorNomabre(pageable);
		page.forEach(cp->{
			System.out.println(cp.getCampo() + " " + cp.getConteo());
		});
		analizarPagina(page);
	}

	private <T> void analizarPagina(Page<T> page){
		System.out.printf("Pagina %d/%d | Elementos: %d | total: %d%n",
				page.getNumber() + 1,
				page.getTotalPages(),
				page.getNumberOfElements(),
				page.getTotalElements()
		);
	}


}
