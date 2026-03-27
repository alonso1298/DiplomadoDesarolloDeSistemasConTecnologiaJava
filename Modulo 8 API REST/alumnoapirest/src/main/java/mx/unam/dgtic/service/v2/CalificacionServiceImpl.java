package mx.unam.dgtic.service.v2;

import mx.unam.dgtic.dto.CalificacionDto;
import mx.unam.dgtic.entities.Alumno;
import mx.unam.dgtic.entities.Calificacion;
import mx.unam.dgtic.repositories.IAlumnoRepository;
import mx.unam.dgtic.repositories.ICalificacionRepository;
import mx.unam.dgtic.service.interfaces.ICalificacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CalificacionServiceImpl implements ICalificacionService {
    @Autowired
    private ICalificacionRepository calificacionRepository;

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Calificacion> obtenerTodos() {
        return List.of();
    }

    @Override
    public Calificacion obtenerCalificacionPorId(Long id) {
        return null;
    }

    @Override
    public List<Calificacion> obtenerCalificacionesPorAlumnoId(Long id) {
        return List.of();
    }

    @Override
    public Calificacion guardar(Long alumnoId, Calificacion calificacion) {
        return null;
    }

    @Override
    public Calificacion actualizarCompleto(Long id, Calificacion calificacion) {
        return null;
    }

    @Override
    public Calificacion actualizarParcial(Long id, Calificacion calificacion) {
        return null;
    }

    @Override
    public Calificacion eliminar(Long id) {
        return null;
    }

    private CalificacionDto mapToDto(Calificacion calificacion) {
        return modelMapper.map(calificacion, CalificacionDto.class);
    }

    private Calificacion mapToEntity(CalificacionDto calificacionDto) {
        Alumno alumno = alumnoRepository.findById(calificacionDto.getIdAlumno()).get();
        Calificacion calificacion = mapToEntity(calificacionDto);
        calificacion.setAlumno(alumno);
        return calificacion;
    }
}
