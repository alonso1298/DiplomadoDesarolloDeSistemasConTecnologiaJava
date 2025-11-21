package mx.unam.dgtic.dao;

import java.util.List;

public interface BookStoreDAO<T, K> {
    List<T> findAll();
    T findById(K id);
    void save(T entity);
    void update(T entity);
    void delete(K id);
}
