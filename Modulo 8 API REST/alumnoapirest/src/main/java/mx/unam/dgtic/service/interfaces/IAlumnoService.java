package mx.unam.dgtic.service.interfaces;

import mx.unam.dgtic.entities.Alumno;

import java.util.List;

public interface IAlumnoService {
    List<Alumno> obtenerTodos(); // GET
    Alumno obtenerAlumnoPorId(Long id); // GET
    Alumno guardar(Alumno alumno); // POST
    Alumno actualizarCompleto(Long id, Alumno alumno); // PUT
    Alumno actualizarParcial(Long id, Alumno alumno); // PATCH
    Alumno eliminar(Long id); // DELETE
}
