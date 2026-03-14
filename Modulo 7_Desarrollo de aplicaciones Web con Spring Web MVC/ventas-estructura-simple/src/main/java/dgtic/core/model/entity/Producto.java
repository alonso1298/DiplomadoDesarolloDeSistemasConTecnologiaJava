package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    private String nombre;
    private BigDecimal precio;
    private Integer stock;
    private String imagen;

    @OneToMany(mappedBy = "producto",
            orphanRemoval = true)
    private List<DetalleVenta> detalleVentaList;


    @Override
    public String toString() {
        return "Producto{" +
                "id_producto=" + id_producto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", imagen=" + imagen +
                '}';
    }
}
