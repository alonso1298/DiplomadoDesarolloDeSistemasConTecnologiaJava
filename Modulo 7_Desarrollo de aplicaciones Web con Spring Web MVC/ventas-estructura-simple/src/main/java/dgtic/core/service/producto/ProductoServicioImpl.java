package dgtic.core.service.producto;

import dgtic.core.exception.NotDataFoundException;
import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.producto.ProductoDTO;
import dgtic.core.model.entity.Producto;
import dgtic.core.repository.ProductoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoServicioImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }



    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> findAll() {
        return productoRepository.findAll().stream().map(Mapper::toProductoDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoDTO findById(Long id) {
        Producto producto=productoRepository.findById(id)
                .orElseThrow(()->new NotDataFoundException("No existe el dato"));
        return Mapper.toProductoDTO(producto);
    }

    @Override
    @Transactional
    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto proc = null;
        if (productoDTO.getId_producto() != null) {
            proc = Producto.builder()
                    .id_producto(productoDTO.getId_producto())
                    .nombre(productoDTO.getNombre())
                    .precio(productoDTO.getPrecio())
                    .stock(productoDTO.getStock())
                    .imagen(productoDTO.getImagen())
                    .build();
        } else {
            proc = Producto.builder()
                    .nombre(productoDTO.getNombre())
                    .precio(productoDTO.getPrecio())
                    .stock(productoDTO.getStock())
                    .imagen(productoDTO.getImagen())
                    .build();
        }
        return Mapper.toProductoDTO(productoRepository.save(proc));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(!productoRepository.existsById(id)){
            throw new NotDataFoundException("No existe el dato");
        }
        productoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductoDTO> findByPage(Pageable pageable) {
        List<ProductoDTO> list=productoRepository.findAll().stream()
                .map(Mapper::toProductoDTO).toList();
        int start = Math.min((int)pageable.getOffset(), list.size());
        int end = Math.min((start + pageable.getPageSize()), list.size());
        return new PageImpl<>(list.subList(start,end),pageable, list.size());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> findProductoView(String dato) {
        return productoRepository.findProductoView(dato);
    }


}
