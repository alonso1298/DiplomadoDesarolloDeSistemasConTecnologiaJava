package mx.unam.dgtic.service.interfaces;

import mx.unam.dgtic.dto.CalificacionDto;

import java.util.List;

public interface ICalificacionDtoService {
    public List<CalificacionDto> findAll();
    public CalificacionDto findById(Long id);
    public CalificacionDto create(CalificacionDto calificacionDto);
    public CalificacionDto update(Long id, CalificacionDto calificacionDto);
    public void delete(Long id);
}
