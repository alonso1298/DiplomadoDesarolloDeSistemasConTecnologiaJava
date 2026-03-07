package dgtic.core.service;

import dgtic.core.model.dto.CategoriaDTO;
import dgtic.core.model.dto.ProductoDTO;
import dgtic.core.repository.ICategoriaRepository;
import dgtic.core.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoService {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Autowired
    private IProductoRepository productoRepository;

    public List<CategoriaDTO> getCategorias(){
        return categoriaRepository.findAll()
                .stream()
                .map(c->new CategoriaDTO(c.getCategoria_id(),c.getNombre()))
                .toList();
    }
    public  List<ProductoDTO> getProdctosPorCategoria(Long categoriaId){
        return productoRepository.findProductoByCategoria(categoriaId);
    }
}
