package mx.unam.dgtic.controllers.front;

import mx.unam.dgtic.dto.AlumnoDto;
import mx.unam.dgtic.service.WebClientAlumnoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    private WebClientAlumnoDtoService webClientAlumnoDtoService;

    @GetMapping("/")
    public String getTodosVista(Model modelo){
        // Consumo de web client debe ser a travez de un servicio
        List<AlumnoDto> alumnos = webClientAlumnoDtoService
                .getTodosVista()
                .collectList()
                .block();
        modelo.addAttribute("alumnos", alumnos);
        return "vista/todosVista";
    }
}
