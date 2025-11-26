package mx.unam.dgtic.repository;

import java.util.List;

public interface AbstractFactory<T>{
    List<T> findAll();
    T finById(Object id);
    void save(T entity);
    void update(T entity);
    void delete(Object id);
}
