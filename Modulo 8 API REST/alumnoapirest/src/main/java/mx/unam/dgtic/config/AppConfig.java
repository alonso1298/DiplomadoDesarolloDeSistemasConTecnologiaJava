package mx.unam.dgtic.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient webClient(){
        // URL BASE del API REST Alumnos
        String urlBase = "http://localhost:8080/api/v2/alumno";
        return WebClient
                .builder()
                .baseUrl(urlBase)
                .build();
    }
}
