package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Perfil;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPerfilRepository extends CrudRepository<Perfil, Long> {

    List<Perfil> findByBiografiaLike(String patron);
    List<Perfil> findByInteresesLike(String patron);
    List<Perfil> findByHabilidadesLike(String patron);

    // Relacion 1:1
    Perfil findByAlumnoMatricula(String matricula);
    List<Perfil> findByAlumnoCurpLike(String patron);




}
