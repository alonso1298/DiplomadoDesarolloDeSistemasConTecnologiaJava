package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "venta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;

    @JoinColumn(name = "id_cliente")
    @ManyToOne
    private Cliente cliente;

    private LocalDate fecha;
    private BigDecimal total;
    @OneToMany(mappedBy="venta",
            fetch = FetchType.LAZY,
                orphanRemoval = true)
    private Set<DetalleVenta> detalles=new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Venta{" +
                ", id_venta=" + id_venta +
                ", fecha=" + fecha +
                ", total=" + total +

                '}';
    }
}
