package mx.unam.dgtic.service;

import mx.unam.dgtic.dto.AlumnoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebClientAlumnoDtoService {
    @Autowired
    private WebClient webClient;

    public Flux<AlumnoDto> getTodosVista(){
        return webClient.get()
                .uri("/")
                .retrieve()
                .bodyToFlux(AlumnoDto.class);
    }

    public Mono<AlumnoDto> getAlumnoById(Long id){
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(AlumnoDto.class);
    }

    public Mono<AlumnoDto> guardarAlumno(AlumnoDto alumnoDto){
        return webClient.post()
                .uri("/")
                .bodyValue(alumnoDto)
                .retrieve()
                .bodyToMono(AlumnoDto.class);
    }

    //GET: /web/nuevo --> Vista -> HTML forma para dar el alta
    // POST: /web/alumno/
    @GetMapping("/web/nuevo/")
    public String mostrarFormulario(Model model){
        model.addAttribute("alumno", new AlumnoDto());
        return "vista/formulario";
    }
}
