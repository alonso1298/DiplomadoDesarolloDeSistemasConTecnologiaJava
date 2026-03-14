package dgtic.core.controller;

import dgtic.core.model.dto.cliente.ClienteDTO;
import dgtic.core.model.dto.venta.FormularioDTO_0;
import dgtic.core.service.cliente.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@Controller
//@RequestMapping("agregar-venta")
public class AgregarVentaController_0 {

    @Autowired
    ClienteService clienteService;

    @GetMapping("ver-agregar-venta")
    public String agregarVenta(Model model){
        model.addAttribute("contenido","Registrar Ventas");
        model.addAttribute("cliente",new ClienteDTO());

        return "ventas/registro-ventas";
    }
    @PostMapping("buscar-cliente-tabla-registro")
    public String buscarTabla(@Valid @ModelAttribute("cliente") ClienteDTO cliente
            , BindingResult result, Model model, RedirectAttributes flash) {
        ClienteDTO cl=clienteService.findById(cliente.getId_cliente());
        model.addAttribute("contenido","Registrar Ventas");
        //model.addAttribute("cliente",new ClienteDTO());
        model.addAttribute("datos",cl);
        model.addAttribute("formulario",new FormularioDTO_0());
        return "ventas/registro-ventas";
    }
    @PostMapping("agregar-items")
    public String agregarItems(@ModelAttribute FormularioDTO_0 formulario,
                               Model model){
        formulario.getItems().forEach(i ->
                System.out.println(i.getNombre())
        );
        return "redirect:/principal";
    }

    @GetMapping("agregar-fragmento/{index}")
    public String getFragmento(@PathVariable int index,Model model){
        model.addAttribute("index", index);
        return "plantillas/items::items";
    }

}
