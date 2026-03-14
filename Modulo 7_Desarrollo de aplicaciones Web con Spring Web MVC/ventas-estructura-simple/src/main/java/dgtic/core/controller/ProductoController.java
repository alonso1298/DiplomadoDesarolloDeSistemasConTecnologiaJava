package dgtic.core.controller;

import dgtic.core.model.dto.producto.ProductoDTO;
import dgtic.core.service.producto.ProductoService;
import dgtic.core.util.Archivos;
import dgtic.core.util.RenderPagina;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("productos")
@SessionAttributes("producto")
public class ProductoController {
    @Value("${ejemplo.imagen.ruta}")
    private String archivoRuta;

    @ModelAttribute("producto")
    public ProductoDTO crearProducto(){
        return new ProductoDTO();
    }

    @Autowired
    ProductoService productoService;

    @GetMapping("lista-productos")
    public String listaProductos(
            @RequestParam(name="page",defaultValue = "0")int page,
            Model model){
        Pageable pageable= PageRequest.of(page,5);
        Page<ProductoDTO> productoDTOS=productoService.findByPage(pageable);
        RenderPagina<ProductoDTO> renderPagina=
                new RenderPagina<>("lista-productos",productoDTOS);
        model.addAttribute("productos",productoDTOS);
        model.addAttribute("page",renderPagina);
        model.addAttribute("contenido","Lista de Productos");

        return "productos/lista-productos";
    }
    @GetMapping("ver-alta-producto")
    public String getAltaProducto(Model model){
        model.addAttribute("contenido","Nuevo Producto");
        return "productos/alta-producto";
    }
    @PostMapping("salvar-producto")
    public String salvarProducto(@Valid @ModelAttribute("producto")ProductoDTO productoDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model, SessionStatus sesion){
        if(bindingResult.hasErrors()){
            //model.addAttribute("producto",productoDTO);
            model.addAttribute("contenido","Verifica los errores siguientes");
            return "productos/alta-producto";
        }
        if(productoDTO.getImagen()==null){
            productoDTO.setImagen("imagen5.png");
        }
        productoService.save(productoDTO);
        sesion.setComplete();
        redirectAttributes.addFlashAttribute("alerts","Se modifico con éxito producto");
        return "redirect:/productos/lista-productos";
    }
    @PostMapping(value = "salvar-imagen")
    public String guardarImagen(@RequestParam("imagenarchivo") MultipartFile multipartFile
            , HttpSession session, Model model){
        ProductoDTO productoDTO = null;
        if (!multipartFile.isEmpty()) {
            String imagenNombre = Archivos.almacenar(multipartFile, archivoRuta);
            if (imagenNombre != null) {
                productoDTO = (ProductoDTO) session.getAttribute("producto");
                productoDTO.setImagen(imagenNombre);
            }
        }
        //model.addAttribute("producto", productoDTO);
        return "productos/modificar-producto";
    }
    @GetMapping("modificar-producto/{id}")
    public String modificarLos(@PathVariable("id") Long id,Model modelo){
        ProductoDTO productoDTO=productoService.findById(id);
        modelo.addAttribute("producto",productoDTO);
        modelo.addAttribute("contenido","Modificar Producto");
        return "productos/modificar-producto";
    }
    @GetMapping("eliminar-producto/{id}")
    public String eliminarLote(@PathVariable("id")Long id,
                               RedirectAttributes modelo){
        productoService.deleteById(id);
        modelo.addFlashAttribute("alerts","Se borro con éxito Producto");
        return "redirect:/productos/lista-productos";
    }

}
