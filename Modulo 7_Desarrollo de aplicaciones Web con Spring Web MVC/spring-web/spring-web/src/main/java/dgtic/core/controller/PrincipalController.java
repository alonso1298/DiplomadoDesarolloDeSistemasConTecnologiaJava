package dgtic.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        String cadena="Tu edad es: "+edad + " y tu nombre es: " + nombre;
        model.addAttribute("contenido",cadena);
        return "spring/pathvariable";
    }
    @GetMapping("requestparam")
    public String getRequestParam(@RequestParam(value = "dato", required = false) String informacion
            , Model model) {
        String cadena = "Sin información";
        if (informacion != null) {
            cadena = " La información es:" + informacion;
        }
        model.addAttribute("contenido", cadena);
        model.addAttribute("info", cadena);
        return "spring/requestParam";
    }
    @GetMapping("requestparam-v")
    public String getRequesParamV(@RequestParam(value = "dato", required = false)String informacion,
                                  @RequestParam(value = "diplomado", required = false)String diplo,
                                  Model model){
        String cadena = "Sin información";
        if (informacion != null) {
            cadena = " La información es:" + informacion+ " diplomado "+diplo;
        }
        model.addAttribute("contenido", cadena);
        model.addAttribute("error",cadena);
        return "spring/requestParam";
    }
    
}
