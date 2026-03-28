package mx.una.dgtic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/compus")
public class ComputadoresRestController {
    private Map<String, String> computadoras;

    public ComputadoresRestController(){
        computadoras = new HashMap<>();
        computadoras.put("comp1", "Computadora 1");
        computadoras.put("comp2", "Computadora 2");
        computadoras.put("comp3", "Computadora 3");
    }

    @RequestMapping("/listar")
    public ResponseEntity<Map<String, String>> listarComputadoras(){
        return ResponseEntity.ok(computadoras);
    }
}
