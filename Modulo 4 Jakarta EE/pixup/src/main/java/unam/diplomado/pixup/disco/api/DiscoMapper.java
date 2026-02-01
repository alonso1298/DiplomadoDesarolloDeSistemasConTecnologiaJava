package unam.diplomado.pixup.disco.api;

import jakarta.enterprise.context.ApplicationScoped;
import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.domain.Disquera;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

@ApplicationScoped
public class DiscoMapper {

    // Mapero de salida
    public DiscoRequestDTO toDto(Disco disco){
        return new DiscoRequestDTO(
                disco.getId(),
                disco.getTitulo(),
                disco.getPrecio(),
                disco.getArtista().getNombre(),
                disco.getDisquera().getNombre(),
                disco.getGeneroMusical().getDescripcion()
        );
    }
    // Mapeo de entrada
    public Disco toDisco(DiscoRequestDTO dto) {

        Artista artista = new Artista(dto.getArtistaId());
        Disquera disquera = new Disquera(dto.getDisqueraId());
        GeneroMusical genero = new GeneroMusical(dto.getGeneroId());

        return new Disco(
                null,
                dto.getTitulo(),
                dto.getPrecio(),
                artista,
                disquera,
                genero
        );
    }
}
