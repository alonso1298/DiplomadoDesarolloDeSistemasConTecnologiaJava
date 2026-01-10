package unam.diplomado.pixup.colonia.api.dto;

import jakarta.enterprise.context.ApplicationScoped;
import unam.diplomado.pixup.colonia.domain.Colonia;

@ApplicationScoped
public class ColoniaMapper {

    public ColoniaDTO toDto(Colonia colonia){
        return new ColoniaDTO(
                colonia.getId(), colonia.getNombre(), colonia.getCp(),
                colonia.getMunicipio().getNombre(),
                colonia.getMunicipio().getEstado().getNombre()
        );
    }
}
