package mx.unam.dgtic.controllers;

import mx.unam.dgtic.entities.Calificacion;
import mx.unam.dgtic.service.interfaces.ICalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/calificacion")
public class CalificacionRestController {

    @Autowired
    private ICalificacionService calificacionService;

    @GetMapping("/")
    public ResponseEntity<List<Calificacion>> obtenerCalificaciones(){
        return ResponseEntity.ok(calificacionService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calificacion> obtenerCalificacion(@PathVariable Long id){
        return ResponseEntity.ok(calificacionService.obtenerCalificacionPorId(id));
    }

    @PostMapping("/")
    public ResponseEntity<Calificacion> insert(@RequestBody Calificacion calificacion){
        Calificacion nueva = calificacionService.guardar(null, calificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> actualizar(@PathVariable Long id, @RequestBody Calificacion calificacion){
        return ResponseEntity.ok(calificacionService.actualizarCompleto(id, calificacion));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Calificacion> actualizarParcial(@RequestBody Calificacion calificacion, @PathVariable Long id){
        return ResponseEntity.ok((calificacionService.actualizarParcial(id, calificacion)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Calificacion> eliminar(@PathVariable Long id){
        return ResponseEntity.ok(calificacionService.eliminar(id));
    }
    // paginado
}
