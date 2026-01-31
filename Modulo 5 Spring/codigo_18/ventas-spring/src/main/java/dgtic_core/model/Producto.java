package dgtic_core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    private Integer id_producto;
    private String nombre;
    private Double precio;
    private Integer stock;
    
}
