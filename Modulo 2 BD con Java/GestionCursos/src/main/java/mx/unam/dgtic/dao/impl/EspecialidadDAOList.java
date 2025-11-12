package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.EspecialidadDAO;
import mx.unam.dgtic.dominio.Especialidad;

import java.util.ArrayList;
import java.util.List;

public class EspecialidadDAOList implements EspecialidadDAO {

    private List<Especialidad> especialidades = new ArrayList<Especialidad>();

    public EspecialidadDAOList() {
        especialidades.add(new Especialidad(100, "Química"));
        especialidades.add(new Especialidad(102, "Artes"));
        especialidades.add(new Especialidad(120, "Música"));
    }

    @Override
    public List<Especialidad> listarTodos() {
        return especialidades;
    }

    @Override
    public Especialidad buscarPorId(int id) {
        return null;
    }

    @Override
    public int guardar(Especialidad especialidad) {
        return 0;
    }

    @Override
    public void actualizar(Especialidad especialidad) {

    }

    @Override
    public void eliminar(int id) {

    }
}
