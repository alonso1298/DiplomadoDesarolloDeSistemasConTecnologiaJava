package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Grupo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IGrupoRepository extends CrudRepository<Grupo, Integer> {

    Grupo findByGrupo(String grupo);

    // Relacion N:N
    List<Grupo> findByAlumnosMatricula(String matricula);
}
