package mx.unam.dgtic.service.v2;

import mx.unam.dgtic.dto.CalificacionDto;
import mx.unam.dgtic.entities.Alumno;
import mx.unam.dgtic.entities.Calificacion;
import mx.unam.dgtic.repositories.IAlumnoRepository;
import mx.unam.dgtic.repositories.ICalificacionRepository;
import mx.unam.dgtic.service.interfaces.ICalificacionDtoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionServiceDtoImpl implements ICalificacionDtoService {
    @Autowired
    private ICalificacionRepository calificacionRepository;

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CalificacionDto> findAll() {
        return calificacionRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public CalificacionDto findById(Long idCalificacion) {
        return null;
    }

    @Override
    public CalificacionDto create(CalificacionDto calificacionDto) {
        Calificacion calificacion = mapToEntity(calificacionDto);
        return mapToDto(calificacionRepository.save(calificacion));
    }

    @Override
    public CalificacionDto update(Long idCalificacion, CalificacionDto calificacionDto) {
        return null;
    }

    @Override
    public CalificacionDto updateParcial(Long idCalificacion, CalificacionDto calificacionDto) {
        return null;
    }

    @Override
    public void delete(Long idCalificacion) {

    }
    private CalificacionDto mapToDto(Calificacion calificacion) {
        return modelMapper.map(calificacion, CalificacionDto.class);
    }

    private Calificacion mapToEntity(CalificacionDto calificacionDto) {
        Alumno alumno = alumnoRepository.findById(calificacionDto.getIdAlumno()).get();
        Calificacion calificacion = modelMapper.map(calificacionDto, Calificacion.class);
        calificacion.setAlumno(alumno);
        return calificacion;
    }

}
