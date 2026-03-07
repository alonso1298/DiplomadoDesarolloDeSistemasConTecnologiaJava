package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    @Column(name = "id_producto")
    private Long idProducto;

    private String nombre;
    private BigDecimal precio;
    private Integer stock;
    private String imagen;

    @OneToMany(mappedBy = "producto", orphanRemoval = true)
    private List<DetalleVenta> detalleVenta;
}
