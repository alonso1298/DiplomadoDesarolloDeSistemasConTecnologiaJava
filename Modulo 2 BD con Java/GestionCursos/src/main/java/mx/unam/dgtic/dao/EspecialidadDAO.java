package mx.unam.dgtic.dao;

import mx.unam.dgtic.dominio.Especialidad;

import java.util.List;

public interface EspecialidadDAO {

    List<Especialidad> listarTodos();
    Especialidad buscarPorId(int id);
    int guardar(Especialidad especialidad);
    void actualizar(Especialidad especialidad);
    void eliminar(int id);

}
