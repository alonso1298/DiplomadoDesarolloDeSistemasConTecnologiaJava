package dgtic.core.model.dto.venta;

import dgtic.core.model.dto.producto.ProductoDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormularioItemsDTO {
    private String nombreCliente;
    private Long id_cliente;
    private ProductoDTO productoDTO;
    private List<ProductoDTO> listaCompra=new ArrayList<>();
    private String total="0.00";

}
