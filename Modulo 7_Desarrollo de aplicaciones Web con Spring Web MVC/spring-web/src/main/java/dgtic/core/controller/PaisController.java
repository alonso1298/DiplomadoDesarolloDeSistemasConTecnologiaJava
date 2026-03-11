package dgtic.core.controller;

import dgtic.core.model.entity.Ciudad;
import dgtic.core.model.entity.Pais;
import dgtic.core.repository.ICiudadRepository;
import dgtic.core.repository.IPaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PaisController {

    @Autowired
    IPaisRepository paisRepository ;

    @Autowired
    ICiudadRepository ciudadRepository;

    @GetMapping("/pagina1")
    public String pagina1(Model model){
        List<Pais> paises = paisRepository.findAll();
        model.addAttribute("paises", paises);
        return "pagina1";
    }
    @PostMapping("/pagina1")
    public String cargarCiudad(@RequestParam Long paisId, Model model){
        List<Pais> paises = paisRepository.findAll();
        List<Ciudad> ciudades = ciudadRepository.findByPaisId(paisId);

        model.addAttribute("paises", paises);
        model.addAttribute("ciudades", ciudades);

        return "pagina1";
    }
}
