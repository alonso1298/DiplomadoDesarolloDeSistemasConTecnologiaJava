package mx.unam.dgtic.service;

import mx.unam.dgtic.entities.Alumno;
import mx.unam.dgtic.entities.Calificacion;
import mx.unam.dgtic.repositories.IAlumnoRepository;
import mx.unam.dgtic.repositories.ICalificacionRepository;
import mx.unam.dgtic.service.interfaces.ICalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CalificacionServiceImpl implements ICalificacionService {

    @Autowired
    ICalificacionRepository calificacionRepository;

    @Autowired
    IAlumnoRepository alumnoRepository;

    @Override
    public List<Calificacion> obtenerTodos() {
        return calificacionRepository.findAll();
    }

    @Override
    public Calificacion obtenerCalificacionPorId(Long id) {
        return calificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificacion no encontrada"));
    }

    @Override
    public List<Calificacion> obtenerCalificacionesPorAlumnoId(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        return alumno.getCalificaciones();
    }

    @Override
    public Calificacion guardar(Long alumnoId, Calificacion calificacion) {
        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id:" + alumnoId));
        calificacion.setAlumno(alumno); // completar con alumno por integridad referencial
        return calificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion actualizarCompleto(Long idAlumno, Calificacion nueva) {
        Calificacion calificacionDb = calificacionRepository.findById(idAlumno)
                .orElseThrow(() -> new RuntimeException("Calificacion no encontrada con id:" ));
        calificacionDb.setCurso(nueva.getCurso());
        calificacionDb.setNota(nueva.getNota());
        if (nueva.getAlumno() != null){
            Alumno alumno = alumnoRepository.findById(idAlumno)
                    .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id:" + idAlumno));
            calificacionDb.setAlumno(alumno);
        }
        return calificacionRepository.save(calificacionDb);
    }

    @Override
    public Calificacion actualizarParcial(Long id, Calificacion calificacion) {
        return null;
    }

    @Override
    public Calificacion eliminar(Long id) {
        return null;
    }
}
