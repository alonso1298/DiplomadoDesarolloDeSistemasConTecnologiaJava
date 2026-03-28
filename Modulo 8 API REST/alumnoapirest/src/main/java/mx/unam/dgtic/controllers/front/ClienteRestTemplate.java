package mx.unam.dgtic.controllers.front;

import mx.unam.dgtic.dto.AlumnoDto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/portal")
public class ClienteRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    // Esta URL deberia ser recuperada desde la properties
    private String url_base = "http://localhost:8080/api/v2/alumno/";

    @GetMapping("/home/")
    public String index(){
        return "index";
    }

    @GetMapping("/")
    public String getTodos(Model model) {
        List<AlumnoDto> alumnos = restTemplate.getForObject(url_base, List.class);
        LoggerFactory.getLogger(ClienteRestTemplate.class).info("Alumnos REST TEMPLATE" + alumnos.toString());
        model.addAttribute("alumnos", alumnos);
        return "todos";
    }

    @GetMapping("/{id}")
    public String getDetalleAlumno(Model model, @PathVariable Long id){
        AlumnoDto alumnoDto = restTemplate.getForObject(url_base+id, AlumnoDto.class);
        model.addAttribute("alumno", alumnoDto);
        return "detalle_alumno";
    }
}
