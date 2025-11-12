package mx.unam.dgtic.dao;

import java.util.List;

public interface GenericDAO<T> {

    List<T> listarTodos();
    T buscarPorId(int id);
    int guardar(T t);
    void actualizar(T t);
    void eliminar(int id);
}
