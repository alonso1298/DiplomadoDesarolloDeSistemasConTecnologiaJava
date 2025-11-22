package mx.unam.dgtic.dao;

import java.util.List;

public interface ICineCRUD<T> {
    List<T> findAll();
    T findById(String id);
    void save(T pelicula);
    void update(T pelicula);
    void delete(String id);
}
