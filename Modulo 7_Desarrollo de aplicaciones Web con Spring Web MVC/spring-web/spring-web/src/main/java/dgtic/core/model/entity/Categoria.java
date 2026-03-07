package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cateogria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    private String nombre;
}
