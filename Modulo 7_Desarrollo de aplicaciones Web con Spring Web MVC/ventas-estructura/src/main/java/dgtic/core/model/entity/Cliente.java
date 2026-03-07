package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    //agregar validacion
    private String nombre;
    private String email;
    private String ciudad;
    private String telefono;
    @OneToMany(mappedBy = "cliente",
        orphanRemoval = true, // Como se tiene una realcion de uno a muchos y si se remueve cliente se tiene que remover todas las ventas
        fetch = FetchType.LAZY)
    private List<Venta> ventas = new ArrayList<>();
}
