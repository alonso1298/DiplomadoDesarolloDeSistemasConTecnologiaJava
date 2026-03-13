package dgtic.core.controller;

import dgtic.core.model.dto.Formulario2DTO;
import dgtic.core.model.entity.Ciudad;
import dgtic.core.service.PaisCiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/utilerias")
public class PaisController {

    @Autowired
    private PaisCiudadService paisCiudadService;

    @GetMapping("/pagina1")
    public String mostrarDatos(@RequestParam("version") int version, Model model){

        model.addAttribute("contenido", "País - Capital");
        model.addAttribute("formulario", new Formulario2DTO());
        model.addAttribute("paises", paisCiudadService.getPaises());
        model.addAttribute("capitales", List.of());

        return version==1 ? "utilerias/paises" : "utilerias/paises_js";
    }
    @PostMapping("/buscar_pais")
    public String procesarFormulario(
            @ModelAttribute("formulario") Formulario2DTO formulario2DTO,
            Model model){

        model.addAttribute("paises", paisCiudadService.getPaises());

        if(formulario2DTO.getPaisId()!=null){
            model.addAttribute("capitales",
                    paisCiudadService.getCiudadPorPais(
                            Long.valueOf(formulario2DTO.getPaisId())
                    ));
        }else{
            model.addAttribute("capitales", List.of());
        }

        return "utilerias/paises";
    }
    @GetMapping("/ciudades/{idPais}")
    @ResponseBody
    public List<Ciudad> obtenerCiudades(@PathVariable Long idPais){
        return paisCiudadService.getCiudadPorPais(idPais);
    }
}
