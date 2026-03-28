package mx.unam.dgtic.controllers.front;

import mx.unam.dgtic.dto.AlumnoDto;
import mx.unam.dgtic.entities.Alumno;
import mx.unam.dgtic.service.WebClientAlumnoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public String getDetalleAlumnoVista(Model modelo, @PathVariable Long id){
        AlumnoDto alumnoDto = webClientAlumnoDtoService.getAlumnoById(id).block();
        modelo.addAttribute("alumno", alumnoDto);
        return "vista/detalleAlumno";
    }

    //GET: /web/nuevo --> Vista -> HTML forma para dar el alta
    // POST: /web/alumno/
    @GetMapping("/nuevo/")
    public String mostrarFormulario(Model model){
        model.addAttribute("alumno", new AlumnoDto());
        return "vista/formulario";
    }

    //POST /web/nuevo/alumno/ recibir @modelAtribute de alumno DT
    // utilizara el servicio de webClient
    @PostMapping("/nuevo/alumno/")
    public String guardarAlumno(@ModelAttribute("alumno") AlumnoDto alumnoDto){
        webClientAlumnoDtoService.guardarAlumno(alumnoDto).block();
        return "redirect:/web/";
    }

    // Formulario para edicion
    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditar(Model modelo, @PathVariable Long id){
        AlumnoDto alumno = webClientAlumnoDtoService.getAlumnoById(id).block();
        modelo.addAttribute("alumno", alumno);
        return "vista/actualizarAlumno";
    }

    // Mandar llamar
    @PostMapping("/actualizar/")
    public String modificarAlumno(@ModelAttribute("alumno") AlumnoDto alumno){
        webClientAlumnoDtoService.actualizarAlumno(alumno.getId(),alumno).block();
        return "redirect:/web/";
    }
}
