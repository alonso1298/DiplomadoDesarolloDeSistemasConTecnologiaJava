package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    private String nombre;
    private String email;
    private String telefono;
    private String ciudad;

    @OneToMany(mappedBy = "cliente",
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Venta> ventas = new ArrayList<>();

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", ventas=" + ventas +
                '}';
    }
}
