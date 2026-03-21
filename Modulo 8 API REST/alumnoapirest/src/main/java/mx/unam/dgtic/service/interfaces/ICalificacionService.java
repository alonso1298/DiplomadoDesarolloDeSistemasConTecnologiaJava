package mx.unam.dgtic.service.interfaces;

import mx.unam.dgtic.entities.Calificacion;

import java.util.List;

public interface ICalificacionService {
    List<Calificacion> obtenerTodos();
    Calificacion obtenerCalificacionPorId(Long id);
    List<Calificacion> obtenerCalificacionesPorAlumnoId(Long id);
    Calificacion guardar(Long alumnoId, Calificacion calificacion);
    Calificacion actualizarCompleto(Long id, Calificacion calificacion);
    Calificacion actualizarParcial(Long id, Calificacion calificacion);
    Calificacion eliminar(Long id);

}
