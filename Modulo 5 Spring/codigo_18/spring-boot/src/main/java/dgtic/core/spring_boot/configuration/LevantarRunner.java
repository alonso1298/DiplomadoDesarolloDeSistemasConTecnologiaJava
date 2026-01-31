package dgtic.core.spring_boot.configuration;

import dgtic.core.spring_boot.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LevantarRunner implements CommandLineRunner {

    @Autowired
    private Persona persona;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(persona);
    }
}
