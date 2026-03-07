package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pais")
@Getter
@Setter
@NoArgsConstructor
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pais;
    private String nombre;
    @OneToMany(mappedBy = "pais",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Ciudad> ciudad;

    public Pais(String nombre) {
        this.nombre = nombre;
    }
}
