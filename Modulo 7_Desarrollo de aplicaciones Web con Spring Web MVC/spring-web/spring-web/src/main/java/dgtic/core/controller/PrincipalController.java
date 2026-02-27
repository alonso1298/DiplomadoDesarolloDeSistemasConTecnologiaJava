package dgtic.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "spring")
public class PrincipalController {
    @RequestMapping(value = "requestmapping", method = RequestMethod.GET)
    public String mappingCLase(Model model){
        model.addAttribute("contenido", "@RequestMapping Clase");
        return "spring/requestmapping";
    }
    @GetMapping("getmapping")
    public String getMapping(Model model){
        model.addAttribute("contenido", "@Getmapping en metodo");
        return "spring/getmapping";
    }
    @GetMapping("parametros-uno/{edad}")
    public String getParamatroUno(@PathVariable("edad")int edad,
                                  Model model){
        String cadena="Tu edad es: "+edad;
        model.addAttribute("contenido",cadena);
        if(edad==1){
            return "redirect:/spring/getmapping";
        }else{
            return "spring/pathVariable";
        }
    }
    
    @GetMapping("parametros-dos/{edad}/{nombre}")
    public String getParametrosDos(@PathVariable("edad")int edad,
                                   @PathVariable("nombre")String nombre,
                                   Model model){
        String cadena="Tu edad es: "+edad + " y tu nombre es: ";
        model.addAttribute("contenido",cadena);
        return "spring/pathvariable";
    }
}
