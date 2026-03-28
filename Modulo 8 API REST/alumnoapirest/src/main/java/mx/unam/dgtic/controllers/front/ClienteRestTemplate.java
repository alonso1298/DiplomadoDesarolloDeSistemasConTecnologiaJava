package mx.unam.dgtic.controllers.front;

import mx.unam.dgtic.dto.AlumnoDto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/portal")
public class ClienteRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    private String url_base = "http://localhost:8080/api/v2/alumno/";

    @GetMapping("/home/")
    public String index(){
        return "index";
    }
    
    @GetMapping("/")
    public String getTodos() {
        List<AlumnoDto> alumnos = restTemplate.getForObject(url_base, List.class);
        LoggerFactory.getLogger(ClienteRestTemplate.class).info("Alumnos REST TEMPLATE" + alumnos.toString());
        return "todos";
    }
}
