package dgtic.core.controller;

import dgtic.core.model.dto.UsuarioDTO;
import dgtic.core.model.entity.UsuarioBd;
import dgtic.core.service.IUsuarioService;
import dgtic.core.util.Archivos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

@Controller
@RequestMapping(value = "utilerias")
public class UtilController {

    @Autowired
    private MessageSource mensaje;

    @Autowired
    private IUsuarioService usuarioService;

    @Value("${ejemplo.imagen.ruta}")
    private String archivoRuta;

    @GetMapping("error_particular_uno")
    public String getError(Model model) {
        throw new NumberFormatException();
    }

    @ExceptionHandler(NumberFormatException.class)
    public String errorRuntime(NumberFormatException e,
                               Model model) {
        String msg = mensaje.getMessage("Error.conversion.string.integer",
                null, Locale.getDefault());
        model.addAttribute("explicacion", msg);
        return "error-general";
    }

    @GetMapping("ver-usuario-v6")
    public String verUsuarioV6(Model model) {
        model.addAttribute("usuario", new UsuarioBd());
        model.addAttribute("contenido", "Ingresa los datos siguientes");
        return "utilerias/binding-v6";
    }

    @PostMapping("recibir-usuario-v6")
    public String recibirUsuario4(@Valid @ModelAttribute("usuario") UsuarioBd usuario,
                                  BindingResult bindingResult,
                                  Model model) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "utilerias/binding-v6";
        }
        model.addAttribute("usuario", usuario);
        String cadena = "";
        if (!usuario.getNombre().isEmpty() && !usuario.getCorreo().isEmpty()) {
            model.addAttribute("contenido", "Los datos que ingresas son:");
            cadena = "Tu nombre es: " + usuario.getNombre() + " y correo: " + usuario.getCorreo();
        }
        //usuarioService.guardar(usuario);
        //System.out.println(usuario);
        try {
            usuarioService.guardar(usuario);
        } catch (Exception e) {
            String msg = mensaje.getMessage("Error.base.duplicado",
                    null, LocaleContextHolder.getLocale());
            bindingResult.rejectValue("correo", "correo", msg);
            return "utilerias/binding-v6";
        }


        model.addAttribute("usuario", new UsuarioBd());
        model.addAttribute("contenido", "Los datos que ingresas son:");
        model.addAttribute("info", cadena);
        return "utilerias/binding-v6";

    }

    @GetMapping("redirecionar-sin-flash")
    public String redirecionarSinFlash(Model model){
        model.addAttribute("contenido","Se hizo un redireccionamiento");
        return "redirect:/principal";
    }
    @GetMapping("redirecionar-con-flash")
    public String redireccionConFlash(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("contenido","Se hizo un redireccionamiento");
        return "redirect:/principal";

    }
    @GetMapping("ver-subir-archivo")
    public String verArchivos(Model model){
        model.addAttribute("contenido", "Subir archivo");
        return "utilerias/subir-archivo";
    }
    @PostMapping("salvar-archivo")
    public String recibirFlujo(@RequestParam("imagenarchivo")MultipartFile multipartFile,
                               Model model){
        String imagenNombre=null;
        if(!multipartFile.isEmpty()){
            imagenNombre= Archivos.almacenar(multipartFile,archivoRuta);
            if(imagenNombre!=null){
                System.out.println("nombre de archivo: "+imagenNombre);
            }
        }
        model.addAttribute("alerts","Archivo almacenado");
        model.addAttribute("nombre",imagenNombre);
        return "utilerias/subir-archivo";
    }
}