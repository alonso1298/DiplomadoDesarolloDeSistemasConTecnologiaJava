package mx.unam.dgtic.service;

import mx.unam.dgtic.dto.AlumnoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

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
}
