package mx.unam.dgtic.controller;

import mx.unam.dgtic.model.Libro;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;

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

    //@GetMapping("/libro/")
    @GetMapping(path = "/libro/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<Integer, Libro>> getTodos(){
        //return libreria;
        return new ResponseEntity<>(libreria, HttpHeaders.EMPTY ,HttpStatus.OK); // 200
    }

    @GetMapping("/libro/{id}") // PathVariable
    public ResponseEntity<Libro> getLibro(@PathVariable Integer id){
        //return libreria.get(id);
        Libro libro = libreria.get(id);
        if (libro != null){
            return ResponseEntity.ok(libro);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/libro/")
    public Libro agregarLibro(@RequestBody Libro libro){ // Se utiliza @RequestBody, ya que en post los datos se mandan en el cuerpo
        int id = 1;
        while (libreria.containsKey(id)) id++;
        libro.setId(id);
        libreria.put(id, libro); // simula insert
        return libreria.get(id);
    }

    @PutMapping("/libro/{id}")
    public Libro actualizaLibro(@PathVariable Integer id, @RequestBody Libro libro){
        if (libreria.containsKey(id)){
            libro.setId(id);
            libreria.replace(id, libro);
        }else {
            return null;
        }
        return libreria.get(id);
    }

    @PatchMapping("/libro/{id}")
    public Libro parcheoLibro(@PathVariable Integer id, @RequestBody Libro libro){
        Libro libroBD = libreria.get(id);
        if (libroBD == null){
            return null; // STATUS CODE 404
        }
        if (libro.getTitulo() != null) libroBD.setTitulo(libro.getTitulo());
        if (libro.getTitulo() != null) libroBD.setAutor(libro.getAutor());

        libreria.replace(id, libroBD);
        return libreria.get(id);
    }

    @DeleteMapping("/libro/{id}")
    public Libro eliminarLibro(@PathVariable Integer id){
        Libro libro = libreria.get(id);
        if (libro != null){
            libreria.remove(id);
            return libro;
        }else {
            // return 404
            return null;
        }
    }
}
