package dgtic.core.controller;

import dgtic.core.model.dto.cliente.ClienteBusquedaDTO;
import dgtic.core.model.dto.cliente.ClienteDTO;
import dgtic.core.service.cliente.ClienteService;
import dgtic.core.util.RenderPagina;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("clientes")
//@SessionAttributes("cliente")
public class ClienteController {
    @Value("${ejemplo.imagen.ruta}")
    private String archivoRuta;

    @ModelAttribute("cliente")
    public ClienteDTO crearCliente() {
        return new ClienteDTO();
    }

    @Autowired
    ClienteService clienteService;

    @GetMapping("lista-clientes")
    public String listaProductos(
            @RequestParam(name = "page", defaultValue = "0") int page,
            Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ClienteDTO> clienteDTOS = clienteService.findByPage(pageable);
        RenderPagina<ClienteDTO> renderPagina =
                new RenderPagina<>("lista-clientes", clienteDTOS);
        model.addAttribute("clientes", clienteDTOS);
        model.addAttribute("page", renderPagina);
        model.addAttribute("contenido", "Lista de Clientes");

        return "clientes/lista-cliente";
    }

    @GetMapping("clientes-pdf")
    public String generarPdf(Model model) {
        List<ClienteDTO> clienteDTO = clienteService.findAll();
        model.addAttribute("datos", clienteDTO);
        model.addAttribute("ruta", archivoRuta);
        return "clientes/clientes-pdf";
    }

    @GetMapping("buscar-clientes-lista")
    public String buscarAutocompletar(Model model){
        ClienteDTO clienteDTO=new ClienteDTO();
        model.addAttribute("cliente",clienteDTO);
        model.addAttribute("contenido","Buscar Clientes por Nombre/Correo");
        return "clientes/modificar-cliente";
    }
    @GetMapping("eliminar-clientes-lista")
    public String aliminarAutocompletar(Model model){
        ClienteDTO clienteDTO=new ClienteDTO();
        model.addAttribute("cliente",clienteDTO);
        model.addAttribute("contenido","Buscar Clientes por Nombre/Correo para eliminar");
        return "clientes/eliminar-cliente";
    }

    @GetMapping("ver-alta-cliente")
    public String verAlta(Model model){
        model.addAttribute("selectciudad",clienteService.findCiudadView());
        model.addAttribute("datos",new ClienteDTO());
        model.addAttribute("contenido","Alta Cliente");
        return "clientes/alta_cliente";
    }

    @GetMapping(value = "buscar-cliente-nombre/{dato}", produces = "application/json")
    public @ResponseBody List<ClienteBusquedaDTO> buscarEspecie(@PathVariable String dato) {
        return clienteService.findClienteView(dato);
    }
    @PostMapping("buscar-cliente-tabla")
    public String buscarReservaconTabla(@Valid @ModelAttribute("cliente") ClienteDTO cliente
            , BindingResult result, Model model, RedirectAttributes flash) {
        ClienteDTO cl=clienteService.findById(cliente.getId_cliente());
        model.addAttribute("contenido","Alta Cliente");
        model.addAttribute("cliente",new ClienteDTO());
        model.addAttribute("selectciudad",clienteService.findCiudadView());
        model.addAttribute("datos",cl);
        return "clientes/modificar-cliente";
    }
    @PostMapping("buscar-cliente-tabla-eliminar")
    public String buscarTablaEliminar(@Valid @ModelAttribute("cliente") ClienteDTO cliente
            , BindingResult result, Model model, RedirectAttributes flash) {
        ClienteDTO cl=clienteService.findById(cliente.getId_cliente());
        model.addAttribute("contenido","Eliminar Cliente");
        model.addAttribute("cliente",new ClienteDTO());
        model.addAttribute("selectciudad",clienteService.findCiudadView());
        model.addAttribute("datos",cl);
        return "clientes/eliminar-cliente";
    }
    @PostMapping(value = "salvar-cliente")
    public String guardarCliente(@ModelAttribute("datos") ClienteDTO cliente,
                                 Model model){

        model.addAttribute("alerts","Se almaceno con éxito");
        model.addAttribute("contenido","Alta Cliente");
        if(cliente.getId_cliente()!=null){
            clienteService.save(cliente);
            model.addAttribute("datos",null);
            return "clientes/modificar-cliente";
        }else{
            clienteService.save(cliente);
            model.addAttribute("selectciudad",clienteService.findCiudadView());
            model.addAttribute("datos",new ClienteDTO());
            return "clientes/alta_cliente";
        }

    }
    @PostMapping(value = "eliminar-cliente")
    public String eliminarCliente(@ModelAttribute("datos") ClienteDTO clienteDTO,
                                  Model model){
        clienteService.deleteById(clienteDTO.getId_cliente());
        model.addAttribute("contenido","Buscar Clientes por Nombre/Correo para eliminar");
        model.addAttribute("alerts","Se elimino con éxito");
        model.addAttribute("datos",null);
        return "clientes/eliminar-cliente";

    }


}
