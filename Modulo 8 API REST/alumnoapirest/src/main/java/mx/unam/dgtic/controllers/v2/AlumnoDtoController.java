package mx.unam.dgtic.controllers.v2;

import mx.unam.dgtic.dto.AlumnoDto;
import mx.unam.dgtic.service.v2.interfaces.IAlumnoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/alumno")
public class AlumnoDtoController {

    @Autowired
    private IAlumnoDtoService alumnoDtoService;

    @GetMapping("/")
    public ResponseEntity<List<AlumnoDto>> getAlumnos(){
        return ResponseEntity.ok(alumnoDtoService.getAlumnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDto> getAlumnoById(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoDtoService.getAlumno(id));
    }

    @PostMapping("/")
    public ResponseEntity<AlumnoDto> createAlumno(@RequestBody AlumnoDto alumnoDto) {
        return ResponseEntity.ok(alumnoDtoService.createAlumno(alumnoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDto> updateAlumno(@PathVariable Long id,
                                                  @RequestBody AlumnoDto alumnoDto){
        return ResponseEntity.ok(alumnoDtoService.updateAlumno(id, alumnoDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<AlumnoDto> deleteAlumno(@PathVariable Long id){
        return ResponseEntity.ok(alumnoDtoService.deleteAlumno(id));
    }
}
