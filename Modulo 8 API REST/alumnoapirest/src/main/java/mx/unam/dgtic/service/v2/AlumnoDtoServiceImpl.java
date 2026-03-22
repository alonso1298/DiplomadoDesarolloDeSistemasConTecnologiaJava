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
        return alumnoRepository.findAll().stream()
                .map(this::entityToDto)
                .toList();
    }

    @Override
    public AlumnoDto getAlumno(Long id) {
        return entityToDto(alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado")));
    }

    @Override
    public AlumnoDto createAlumno(AlumnoDto alumnoDto) {
        Alumno alumno = modelMapper.map(alumnoDto, Alumno.class);
        Alumno alumnoNuevo = alumnoRepository.save(alumno);
        return entityToDto(alumnoNuevo);
    }

    @Override
    public AlumnoDto updateAlumno(Long id, AlumnoDto alumnoDto) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        alumnoDto.setId(alumno.getId());
        //updateAlumnoFromDto(alumno, alumnoDto);
        alumno = dtoToEntity(alumnoDto);
        alumnoRepository.save(alumno);
        return entityToDto(alumno);
    }

    @Override
    public AlumnoDto deleteAlumno(Long id) {
        Alumno alumnoDB = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        alumnoRepository.delete(alumnoDB);
        return entityToDto(alumnoDB);
    }

    private AlumnoDto entityToDto(Alumno alumno) {
        AlumnoDto alumnoDto = modelMapper.map(alumno, AlumnoDto.class);
        // alumno sstream --> convertir DOuble, averag().
        alumnoDto.setPromedio(alumno.calcularPromedio());
        return alumnoDto;
    }

    private Alumno dtoToEntity(AlumnoDto alumnoDto) {
        return modelMapper.map(alumnoDto, Alumno.class);
    }

    private void updateAlumnoFromDto(Alumno alumno, AlumnoDto alumnoDto) {
        modelMapper.map(alumnoDto, alumno);
    }
}
