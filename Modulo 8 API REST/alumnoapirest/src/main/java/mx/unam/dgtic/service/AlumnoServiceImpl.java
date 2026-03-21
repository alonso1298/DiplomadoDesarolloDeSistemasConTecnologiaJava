package mx.unam.dgtic.service;

import mx.unam.dgtic.entities.Alumno;
import mx.unam.dgtic.entities.Calificacion;
import mx.unam.dgtic.repositories.IAlumnoRepository;
import mx.unam.dgtic.service.interfaces.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> obtenerTodos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno obtenerAlumnoPorId(Long id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno no encontrado"));
    }

    @Override
    public Alumno guardar(Alumno alumno) {
        // trae calificaciones
        if (alumno.getCalificaciones() != null){
            for (Calificacion calificacion : alumno.getCalificaciones()) {
                calificacion.setAlumno(alumno);
            }
        }
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno actualizarCompleto(Long id, Alumno alumnoNuevo) {
        Alumno alumnoDb = alumnoRepository.findById(id)
                .orElseThrow(() -> new  RuntimeException("Alumno no encontrado con id: " + id));
        // forzando a actualizar todos los campos
        alumnoDb.setNombre(alumnoNuevo.getNombre());
        alumnoDb.setApellido(alumnoNuevo.getApellido());
        alumnoDb.setCorreo(alumnoNuevo.getCorreo());

        if (alumnoNuevo.getCalificaciones() != null){
            alumnoDb.setCalificaciones(new ArrayList<>(alumnoNuevo.getCalificaciones()));
            for (Calificacion calificacion : alumnoNuevo.getCalificaciones()){
                calificacion.setAlumno(alumnoDb);
            }
        }else {
            alumnoDb.setCalificaciones(null);
        }
        return alumnoRepository.save(alumnoDb);
    }

    @Override
    public Alumno actualizarParcial(Long id, Alumno cambios) {
        Alumno alumnoDb = alumnoRepository.findById(id)
                .orElseThrow(() -> new  RuntimeException("Alumno no encontrado con id: " + id));
        if(cambios.getNombre() != null) alumnoDb.setNombre(cambios.getNombre());
        if(cambios.getApellido() != null) alumnoDb.setApellido(cambios.getApellido());
        if(cambios.getCorreo() != null) alumnoDb. setCorreo(cambios. getCorreo());
        // no actualizamos calificaiones
        return alumnoRepository.save(alumnoDb);
    }

    @Override
    public Alumno eliminar(Long id) {
        Alumno alumnoDb = alumnoRepository.findById(id)
                .orElseThrow(() -> new  RuntimeException("Alumno no encontrado con id: " + id));
        alumnoRepository.delete(alumnoDb);
        return alumnoDb;
    }
}
