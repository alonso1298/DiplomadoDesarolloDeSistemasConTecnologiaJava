package unam.diplomado.pixup.colonia.api.dto;

import jakarta.enterprise.context.ApplicationScoped;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.domain.Municipio;

@ApplicationScoped
public class ColoniaMapper {

    public ColoniaDTO toDto(Colonia colonia){
        return new ColoniaDTO(
                colonia.getId(), colonia.getNombre(), colonia.getCp(),
                colonia.getMunicipio().getNombre(),
                colonia.getMunicipio().getEstado().getNombre()
        );
    }

    public Colonia toColonia(ColoniaRequestDTO coloniaRequestDTO){
        Colonia colonia = new Colonia();
        colonia.setNombre(coloniaRequestDTO.nombre());
        colonia.setCp(coloniaRequestDTO.cp());
        colonia.setMunicipio(new Municipio());
        colonia.getMunicipio().setId(coloniaRequestDTO.municipio());
        return colonia;
    }
}
