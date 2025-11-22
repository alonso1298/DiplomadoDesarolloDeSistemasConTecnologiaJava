package mx.unam.dgtic.dao;

import mx.unam.dgtic.entities.Pelicula;

import java.util.List;

public class PeliculaDAO implements ICineCRUD<Pelicula> {
    @Override
    public List<Pelicula> findAll() {
        return List.of();
    }

    @Override
    public Pelicula findById(String id) {
        return null;
    }

    @Override
    public void save(Pelicula pelicula) {

    }

    @Override
    public void update(Pelicula pelicula) {

    }

    @Override
    public void delete(String id) {

    }
}
