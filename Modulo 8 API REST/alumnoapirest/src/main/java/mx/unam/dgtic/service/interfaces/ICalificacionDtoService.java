package mx.unam.dgtic.service.interfaces;

import mx.unam.dgtic.dto.CalificacionDto;

import java.util.List;

public interface ICalificacionDtoService {
    public List<CalificacionDto> findAll();
    public CalificacionDto findById(Long idCalificacion);
    public CalificacionDto create(CalificacionDto calificacionDto);
    public CalificacionDto update(Long idCalificacion, CalificacionDto calificacionDto);
    public CalificacionDto updateParcial(Long idCalificacion, CalificacionDto calificacionDto);
    public void delete(Long idCalificacion);
}
