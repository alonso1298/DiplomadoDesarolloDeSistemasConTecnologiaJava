package mx.unam.dgtic.dao;

import mx.unam.dgtic.domain.Figura;

import java.util.List;

public interface IFiguraDAO {
    List<Figura> listarTodos();
    Figura buscarPorId(int id);
    int guardar(Figura figura);
    void actualizar(Figura figura);
    void eliminar(int id);
}
