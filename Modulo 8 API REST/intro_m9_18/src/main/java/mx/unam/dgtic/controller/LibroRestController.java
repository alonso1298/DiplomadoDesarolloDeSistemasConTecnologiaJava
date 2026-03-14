package mx.unam.dgtic.controller;

import mx.unam.dgtic.model.Libro;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/libro/")
    public Libro agregarLibro(@RequestBody Libro libro){ // Se utiliza @RequestBody ya que en post los datos se mandan en el cuerpo
        int id = 1;
        while (libreria.containsKey(id)) id++;
        libro.setId(id);
        libreria.put(id, libro); // simula insert
        return libreria.get(id);
    }
}
