package unam.diplomado.pixup.disco.api;

import jakarta.enterprise.context.ApplicationScoped;
import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.domain.Disquera;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

@ApplicationScoped
public class DiscoMapper {

    // ====== REQUEST → ENTITY ======
    public Disco toEntity(DiscoRequestDTO dto) {
        Disco disco = new Disco();
        disco.setTitulo(dto.getTitulo());
        disco.setPrecio(dto.getPrecio().floatValue()); // ✔ conversión
        disco.setExistencia(dto.getExistencia());      // ✔ nombre correcto

        Artista artista = new Artista();
        artista.setId(dto.getArtistaId());
        disco.setArtista(artista);

        Disquera disquera = new Disquera();
        disquera.setId(dto.getDisqueraId());
        disco.setDisquera(disquera);

        GeneroMusical genero = new GeneroMusical();
        genero.setId(dto.getGeneroId());
        disco.setGeneroMusical(genero);

        return disco;
    }

    // ====== ENTITY → RESPONSE ======
    public DiscoResponseDTO toResponseDTO(Disco disco) {
        return new DiscoResponseDTO(
                disco.getId(),
                disco.getTitulo(),
                disco.getPrecio(),
                disco.getExistencia()
        );
    }
}
