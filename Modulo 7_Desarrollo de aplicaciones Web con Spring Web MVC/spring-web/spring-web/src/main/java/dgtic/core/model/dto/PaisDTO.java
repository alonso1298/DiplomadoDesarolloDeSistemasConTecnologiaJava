package dgtic.core.model.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaisDTO {
    private Long id_pais;
    private String nombre;
    @OneToMany(mappedBy = "pais",
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
}
