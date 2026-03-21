package mx.unam.dgtic.controllers;

import mx.unam.dgtic.entities.Alumno;
import mx.unam.dgtic.service.interfaces.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumno")
public class AlumnoRestController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping("/")
    public ResponseEntity<List<Alumno>> getAlumnos(){
        return ResponseEntity.ok(alumnoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumno(@PathVariable Long id){
        return ResponseEntity.ok(alumnoService.obtenerAlumnoPorId(id));
    }

    @PostMapping("/")
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno){
        Alumno alumnoNuevo = alumnoService.guardar(alumno);
        return ResponseEntity.status( HttpStatus.CREATED ).body(alumnoNuevo);
        //Alumno alumnoNuevo = alumnoService.guardar(alumno);
        // return ResponseEntity.ok(alumnoNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id,
                                               @RequestBody Alumno alumnoNuevo) {
        return ResponseEntity.ok(alumnoService.actualizarCompleto(id, alumnoNuevo));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Alumno> updateParcialAlumno(
            @PathVariable Long id, @RequestBody Alumno alumnoNuevo){
        return ResponseEntity.ok(alumnoService.actualizarParcial(id, alumnoNuevo));
    }

    @DeleteMapping
}
