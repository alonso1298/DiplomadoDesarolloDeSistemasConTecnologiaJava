package mx.unam.dgtic.controllers.v2;

import mx.unam.dgtic.dto.CalificacionDto;
import mx.unam.dgtic.service.v2.CalificacionServiceDtoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/calificacion")
public class CalificacionDtoRestController {

    @Autowired
    private CalificacionServiceDtoImpl calificacionService;

    @GetMapping("/")
    public ResponseEntity<List<CalificacionDto>> getCalificacionDto(){
        return ResponseEntity.ok(calificacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalificacionDto> getCalificacionDto(@PathVariable Long id){
        return ResponseEntity.ok(calificacionService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<CalificacionDto> createCalificacionDto(@RequestBody CalificacionDto calificacionDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(calificacionService.create(calificacionDto));
    }
}
