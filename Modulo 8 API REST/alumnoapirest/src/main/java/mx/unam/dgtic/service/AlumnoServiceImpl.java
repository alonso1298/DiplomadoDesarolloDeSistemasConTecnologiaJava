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
    public Alumno actualizarCompleto(Long id, Alumno alumno) {
        Alumno alumnoDb = alumnoRepository.findById(id)
                .orElseThrow(() -> new  RuntimeException("Alumno no encontrado con id: " + id));
        // forzando a actualizar todos los campos
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setCorreo(alumno.getCorreo());

        if (alumno.getCalificaciones() != null){
            alumnoDb.setCalificaciones(new ArrayList<>(alumno.getCalificaciones()));
            for (Calificacion calificacion : alumno.getCalificaciones()){
                calificacion.setAlumno(alumnoDb);
            }
        }else {
            alumnoDb.setCalificaciones(null);
        }
        return alumnoRepository.save(alumnoDb);
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
