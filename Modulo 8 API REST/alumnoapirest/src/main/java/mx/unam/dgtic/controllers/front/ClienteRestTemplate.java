package mx.unam.dgtic.controllers.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/portal")
public class ClienteRestTemplate {

    @GetMapping("/")
    public String index(){
        return "index"
    }
}
