package mx.unam.dgtic.service.v2.interfaces;

import mx.unam.dgtic.dto.AlumnoDto;

import java.util.List;

public interface IAlumnoDtoService {

    List<AlumnoDto> getAlumnos();
    AlumnoDto getAlumno(Long id);
    AlumnoDto createAlumno(AlumnoDto alumnoDto);
    AlumnoDto updateAlumno(AlumnoDto alumnoDto);
    AlumnoDto deleteAlumno(Long id);

}
