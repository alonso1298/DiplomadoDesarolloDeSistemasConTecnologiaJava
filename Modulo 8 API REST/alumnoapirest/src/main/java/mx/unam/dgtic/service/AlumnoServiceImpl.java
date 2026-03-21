package mx.unam.dgtic.service;

import mx.unam.dgtic.entities.Alumno;
import mx.unam.dgtic.repositories.IAlumnoRepository;
import mx.unam.dgtic.service.interfaces.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> obtenerTodos() {
        return List.of();
    }

    @Override
    public Alumno obtenerAlumnoPorId(Long id) {
        return null;
    }

    @Override
    public Alumno guardar(Alumno alumno) {
        return null;
    }

    @Override
    public Alumno actualizarCompleto(Long id, Alumno alumno) {
        return null;
    }

    @Override
    public Alumno actualizarParcial(Long id, Alumno alumno) {
        return null;
    }

    @Override
    public Alumno eliminar(Long id) {
        return null;
    }
}
