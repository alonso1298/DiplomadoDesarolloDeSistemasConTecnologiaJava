package mx.unam.dgtic.service;

import mx.unam.dgtic.dao.PeliculaDAO;
import mx.unam.dgtic.entities.Pelicula;

import java.util.List;

public class PeliculaService {
    private final PeliculaDAO peliculaDAO = new PeliculaDAO();

    public void crearPelicula(Pelicula p) {
        peliculaDAO.save(p);
    }

    public List<Pelicula> obtenerPeliculas() {
        return peliculaDAO.findAll();
    }

    public Pelicula obtenerPelicula(int id) {
        return peliculaDAO.findById(id);
    }

    public void actualizarPelicula(Pelicula p) {
        peliculaDAO.update(p);
    }

    public void eliminarPelicula(int id) {
        peliculaDAO.delete(id);
    }
}
