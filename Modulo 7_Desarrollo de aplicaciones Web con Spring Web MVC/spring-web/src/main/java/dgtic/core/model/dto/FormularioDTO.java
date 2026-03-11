package dgtic.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormularioDTO {
    private Long categoriaId;
    private Long productoId;

    @Override
    public String toString() {
        return "FormularioDTO{" +
                "categoriaId=" + categoriaId +
                ", priductoId=" + productoId +
                '}';
    }
}
