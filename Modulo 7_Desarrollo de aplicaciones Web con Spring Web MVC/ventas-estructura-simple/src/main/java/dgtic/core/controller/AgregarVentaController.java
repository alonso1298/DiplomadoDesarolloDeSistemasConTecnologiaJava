package dgtic.core.controller;

import dgtic.core.model.dto.producto.ProductoDTO;
import dgtic.core.model.dto.cliente.ClienteDTO;
import dgtic.core.model.dto.venta.FormularioItemsDTO;
import dgtic.core.service.cliente.ClienteService;
import dgtic.core.service.producto.ProductoService;
import dgtic.core.service.venta.VentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("agregar-venta")
@SessionAttributes("venta")
public class AgregarVentaController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ProductoService productoService;

    @Autowired
    VentaService ventaService;

    @GetMapping("ver-agregar-venta")
    public String agregarVenta(Model model) {
        model.addAttribute("contenido", "Registrar Ventas");
        model.addAttribute("venta", new FormularioItemsDTO());
        return "ventas/registro-ventas";
    }

    @PostMapping("buscar-cliente-tabla-registro")
    public String buscarTabla(@ModelAttribute("venta") FormularioItemsDTO formulario
            , BindingResult result, Model model, RedirectAttributes flash) {
        ClienteDTO cl = clienteService.findById(formulario.getId_cliente());
        model.addAttribute("contenido", "Registrar Ventas");
        //model.addAttribute("cliente",new ClienteDTO());
        model.addAttribute("datos", cl);
        model.addAttribute("producto", new ProductoDTO());
        return "ventas/registro-ventas";
    }

    @GetMapping(value = "buscar-producto-nombre/{dato}", produces = "application/json")
    public @ResponseBody List<ProductoDTO> buscarEspecie(@PathVariable String dato) {
        return productoService.findProductoView(dato);
    }

    @PostMapping("buscar-producto-tabla-registro")
    public String buscarTablaProducto(@Valid @ModelAttribute("venta") FormularioItemsDTO formulario
            , BindingResult result, Model model, RedirectAttributes flash) {
        ProductoDTO cl = productoService.findById(formulario.getProductoDTO().getId_producto());

        model.addAttribute("contenido", "Registrar Ventas");
        model.addAttribute("datos", "datos");
        formulario.getProductoDTO().setNombre("");
        formulario.setTotal(sumarVenta(formulario.getTotal(), cl));
        formulario.getListaCompra().add(cl);
        return "ventas/registro-ventas";
    }

    @GetMapping("eliminar-producto/{id}")
    public String eliminarLote(@PathVariable("id") Long id,
                               Model model) {
        FormularioItemsDTO elemento = (FormularioItemsDTO) model.getAttribute("venta");
        Iterator<ProductoDTO> iter = elemento.getListaCompra().iterator();
        while (iter.hasNext()) {
            ProductoDTO ob = iter.next();
            if (Objects.equals(id, ob.getId_producto())) {
                elemento.setTotal(restarVenta(elemento.getTotal(), ob));
                iter.remove();
                break;
            }
        }

        model.addAttribute("contenido", "Registrar Ventas");
        model.addAttribute("datos", "datos");
        return "ventas/registro-ventas";
    }
    @GetMapping("cerrar-venta")
    public String cerrarVenta(Model model){
        FormularioItemsDTO elemento = (FormularioItemsDTO) model.getAttribute("venta");
        ventaService.registerSale(elemento);
        return "redirect:/agregar-venta/ver-agregar-venta";
    }

    private String sumarVenta(String totalInicio, ProductoDTO producto) {
        BigDecimal total = new BigDecimal(totalInicio);
        total=total.add(producto.getPrecio());
        return total.setScale(2, RoundingMode.HALF_UP).toPlainString();

    }

    private String restarVenta(String totalInicio, ProductoDTO producto) {
        BigDecimal total = new BigDecimal(totalInicio);
        total=total.subtract(producto.getPrecio());
        return total.setScale(2, RoundingMode.HALF_UP).toPlainString();

    }

}
