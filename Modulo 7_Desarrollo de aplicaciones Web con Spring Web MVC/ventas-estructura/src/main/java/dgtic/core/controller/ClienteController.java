package dgtic.core.controller;

import dgtic.core.model.dto.dto.cliente.ClienteDTO;
import dgtic.core.service.cliente.IClienteService;
import dgtic.core.util.RenderPagina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

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
}
