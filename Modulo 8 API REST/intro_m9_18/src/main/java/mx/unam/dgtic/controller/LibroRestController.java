package mx.unam.dgtic.controller;

import mx.unam.dgtic.model.Libro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController // A diferencia de @Controller que es para MVC este es para APIs Rest donde maneja las solicitudes HTTP
@RequestMapping("/api/v1/libreria") // Se establece el mapeo para el controlador (ruta base)
public class LibroRestController {
    private HashMap<Integer, Libro> libreria;

    public LibroRestController() {
        // simular BD con Hash map
        libreria = new HashMap<>();
        libreria.put(1, new Libro(1, "El senor de los anillos", "JR. Tolkien"));
        libreria.put(2, new Libro(2, "El metodo buller journall", "Ryder Carroll"));
    }

    @GetMapping("/")
    public String ping(){
        return "OK";
    }

    @GetMapping("/libro/")
    public HashMap<Integer, Libro> getTodos(){
        return libreria;
    }

    @GetMapping("/libro/{id}") // PathVariable
    public Libro getLibro(@PathVariable Integer id){
        return libreria.get(id);
    }
}
