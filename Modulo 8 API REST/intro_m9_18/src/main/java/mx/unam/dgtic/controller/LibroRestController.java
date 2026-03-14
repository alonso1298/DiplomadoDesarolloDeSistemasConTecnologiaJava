package mx.unam.dgtic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // A diferencia de @Controller que es para MVC este es para APIs Rest
@RequestMapping("/api/v1/libreria") // Se establece el mapeo para el controlador
public class LibroRestController {

    @GetMapping("/")
    public String ping(){
        return "OK";
    }

}
