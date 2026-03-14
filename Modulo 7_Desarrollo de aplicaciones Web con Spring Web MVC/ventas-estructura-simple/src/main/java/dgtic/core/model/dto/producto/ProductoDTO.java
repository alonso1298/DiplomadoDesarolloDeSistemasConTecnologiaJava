package dgtic.core.model.dto.producto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {
    private Long id_producto;
    @NotBlank
    private String nombre;

    @Digits(integer = 7,fraction = 2)
    @DecimalMin(value = "0.0",inclusive = false)
    private BigDecimal precio;
    @Min(1)
    @Max(999)
    private Integer stock;

    private String imagen;

    public ProductoDTO(Long id_producto, String nombre) {
        this.id_producto = id_producto;
        this.nombre=nombre;
    }

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
