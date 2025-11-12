package mx.unam.dgtic.dao;

import mx.unam.dgtic.dominio.Especialidad;
import mx.unam.dgtic.dominio.Instructor;

public interface InstructorDAO extends GenericDAO<Instructor> {
    void insertarInstructorConEspecialidad(Instructor instructor, Especialidad especialidad);
}
