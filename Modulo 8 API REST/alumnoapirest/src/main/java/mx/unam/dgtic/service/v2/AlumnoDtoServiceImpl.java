package mx.unam.dgtic.service.v2;

import mx.unam.dgtic.dto.AlumnoDto;
import mx.unam.dgtic.entities.Alumno;
import mx.unam.dgtic.repositories.IAlumnoRepository;
import mx.unam.dgtic.service.v2.interfaces.IAlumnoDtoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoDtoServiceImpl implements IAlumnoDtoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<AlumnoDto> getAlumnos() {
        return List.of();
    }

    @Override
    public AlumnoDto getAlumno(Long id) {
        return null;
    }

    @Override
    public AlumnoDto createAlumno(AlumnoDto alumnoDto) {
        return null;
    }

    @Override
    public AlumnoDto updateAlumno(AlumnoDto alumnoDto) {
        return null;
    }

    @Override
    public AlumnoDto deleteAlumno(Long id) {
        return null;
    }

    public AlumnoDto entityToDto(Alumno alumno){
        AlumnoDto alumnoDto = modelMapper.map(alumno, AlumnoDto.class);
        // alumno sstream --> convertir DOuble, averag().
        alumnoDto.setPromedio()
    }
}
