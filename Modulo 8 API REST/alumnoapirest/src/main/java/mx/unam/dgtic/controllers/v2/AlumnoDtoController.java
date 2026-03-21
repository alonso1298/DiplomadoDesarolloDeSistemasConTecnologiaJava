package mx.unam.dgtic.controllers.v2;

import mx.unam.dgtic.dto.AlumnoDto;
import mx.unam.dgtic.service.v2.interfaces.IAlumnoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
