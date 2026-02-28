package dgtic.core.controller;

import dgtic.core.converter.EnteroConverter;
import dgtic.core.converter.MayusculasConverter;
import dgtic.core.converter.VacioConverter;
import dgtic.core.model.dto.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
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
    // Desplegar Formulario
    @GetMapping("ver-formulario")
    public String verFormulario(Model model){
        model.addAttribute("contenido","Ingrese los datos siguientes");
        return "spring/requestparam-post";
    }
    @PostMapping("recibir-informacion")
    public String recibirDatos(
            @RequestParam(value = "nombre")String nombre,
            @RequestParam(value = "correo")String correo,
            Model model){
        String cadena="Sin información";
        if(!nombre.isEmpty() && !correo.isEmpty()){
            model.addAttribute("contenido","Los datos que ingresas son:");
            cadena="Tu nombre es: "+nombre+" y correo: "+correo;
        }
        model.addAttribute("info",cadena);
        return "spring/requestparam-post";
    }
    @GetMapping("ver-usuario")
    public String verUsuario(Model model){
        model.addAttribute("contenido","Ingresa los datos siguientes");
        return "spring/binding";
    }
    @PostMapping("recibir-usuario")
    public String recibirUsuario(UsuarioDTO usuario,Model model) {
        String cadena = "Sin información";
        if (!usuario.getNombre().isEmpty() && !usuario.getCorreo().isEmpty()) {
            model.addAttribute("contenido", "Los datos que ingresas son:");
            cadena = "Tu nombre es: " + usuario.getNombre() + " y correo: " + usuario.getCorreo() + " codigo postal: " + usuario.getCp();
        }
        model.addAttribute("info", cadena);
        return "spring/binding";
    }

    @GetMapping("ver-usuario-v2")
    public String verUsuarioV2(Model model){
        model.addAttribute("usuario",new UsuarioDTO());
        model.addAttribute("contenido","Ingresa los datos siguientes");
        return "spring/binding-v2";
    }
    @PostMapping("recibir-usuario-v2")
    public String recibirUsuario2(@ModelAttribute("usuario") UsuarioDTO usuario, Model model){
        String cadena = "Sin información";
        if (!usuario.getNombre().isEmpty() && !usuario.getCorreo().isEmpty()) {
            model.addAttribute("contenido", "Los datos que ingresas son:");
            cadena = "Tu nombre es: " + usuario.getNombre() + " y correo: " + usuario.getCorreo() + " codigo postal: " + usuario.getCp()
            + " telefono: " + usuario.getTelefono();
        }
        model.addAttribute("info", cadena);
        return "spring/binding-v2";
    }

    @GetMapping("ver-usuario-v3")
    public String verUsuarioV3(Model model){
        model.addAttribute("usuario",new UsuarioDTO());
        model.addAttribute("contenido","Ingresa los datos siguientes");
        return "spring/binding-v3";
    }
    @PostMapping("recibir-usuario-v3")
    public String recibirUsuario3(@Valid @ModelAttribute("usuario") UsuarioDTO usuario,
                                  BindingResult bindingResult,
                                  Model model){
        if(bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                System.out.println("Error: "+error.getDefaultMessage());
            }
            return "spring/binding-v3";
        }
        model.addAttribute("usuario",usuario);
        String cadena="";
        if(!usuario.getNombre().isEmpty() && !usuario.getCorreo().isEmpty()){
            model.addAttribute("contenido","Los datos que ingresas son:");
            cadena = "Tu nombre es: " + usuario.getNombre() + " correo: " + usuario.getCorreo() + " codigo postal: " + usuario.getCp()
                    + " y telefono: " + usuario.getTelefono();
        }
        model.addAttribute("contenido","Los datos que ingresas son:");
        model.addAttribute("info",cadena);
        return "spring/binding-v3";
    }

    @InitBinder("usuario")
    public void convertir(WebDataBinder binder){
        binder.registerCustomEditor(Integer.class,
                "edad", new EnteroConverter());
        binder.registerCustomEditor(String.class,
                "nombre",new MayusculasConverter());
        binder.registerCustomEditor(String.class,
                "correo", new VacioConverter());
    }
    @GetMapping("ver-usuario-v4")
    public String verUsuarioV4(Model model){
        model.addAttribute("usuario",new UsuarioDTO());
        model.addAttribute("contenido","Ingresa los datos siguientes");
        return "spring/binding-v4";
    }
    @PostMapping("recibir-usuario-v4")
    public String recibirUsuario4(@Valid @ModelAttribute("usuario") UsuarioDTO usuario,
                                  BindingResult bindingResult,
                                  Model model){
        if(bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                System.out.println("Error: "+error.getDefaultMessage());
            }
            return "spring/binding-v4";
        }
        model.addAttribute("usuario",usuario);
        String cadena="";
        if(!usuario.getNombre().isEmpty() && !usuario.getCorreo().isEmpty()){
            model.addAttribute("contenido","Los datos que ingresas son:");
            cadena = "Tu nombre es: " + usuario.getNombre() + " correo: " + usuario.getCorreo() + " codigo postal: " + usuario.getCp()
                    + " y telefono: " + usuario.getTelefono();
        }
        model.addAttribute("contenido","Los datos que ingresas son:");
        model.addAttribute("info",cadena);
        return "spring/binding-v4";
    }
}
