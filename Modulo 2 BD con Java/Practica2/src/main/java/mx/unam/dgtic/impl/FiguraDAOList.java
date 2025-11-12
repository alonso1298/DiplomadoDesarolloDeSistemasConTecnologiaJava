package mx.unam.dgtic.impl;

import mx.unam.dgtic.dao.IFiguraDAO;
import mx.unam.dgtic.domain.Figura;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FiguraDAOList implements IFiguraDAO {
    private List<Figura> figuras = new ArrayList<>();

    public FiguraDAOList() {
        figuras.add(new Figura(1, "Goku SSJ", "Figura articulada", new Date(), 350.0, 1, 1));
        figuras.add(new Figura(2, "Batman", "Figura oscura", new Date(), 280.0, 4, 2));
        figuras.add(new Figura(3, "Iron Man", "Figura metálica", new Date(), 450.0, 2, 3));
    }

    @Override
    public List<Figura> listarTodos() {
        return figuras;
    }

    @Override
    public Figura buscarPorId(int id) {
        for (Figura f : figuras) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    @Override
    public int guardar(Figura figura) {
        figuras.add(figura);
        return figura.getId();
    }

    @Override
    public void actualizar(Figura figura) {
        for (Figura f : figuras) {
            if (f.getId() == figura.getId()) {
                f.setNombre(figura.getNombre());
                f.setDescripcion(figura.getDescripcion());
                f.setPrecio(figura.getPrecio());
                f.setFechaLanzamiento(figura.getFechaLanzamiento());
                break;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        figuras.removeIf(f -> f.getId() == id);
    }
}
