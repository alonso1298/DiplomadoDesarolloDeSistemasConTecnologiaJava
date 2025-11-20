package mx.unam.dgtic.dao;

import java.util.List;

public interface BookStoreDAO<T> {
    List<T> findAll();
    T findById(String isbn);
    void save(T book);
    void update(T book);
    void delete(String isbn);
}
