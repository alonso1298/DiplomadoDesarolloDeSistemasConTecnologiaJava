package dgtic.core.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaisDTO {
    private Long id_pais;
    private String nombre;
}
