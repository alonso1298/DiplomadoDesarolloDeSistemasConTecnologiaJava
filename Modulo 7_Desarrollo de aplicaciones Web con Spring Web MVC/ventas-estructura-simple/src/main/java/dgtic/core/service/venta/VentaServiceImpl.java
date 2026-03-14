package dgtic.core.service.venta;

import dgtic.core.exception.NotDataFoundException;
import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.cliente.ClienteDTO;
import dgtic.core.model.dto.detalleventa.DetalleVentaDTO;
import dgtic.core.model.dto.venta.FormularioItemsDTO;
import dgtic.core.model.dto.venta.VentaDTO;
import dgtic.core.model.entity.Cliente;
import dgtic.core.model.entity.Venta;
import dgtic.core.repository.ClienteRepository;
import dgtic.core.repository.VentaRepository;
import dgtic.core.service.cliente.ClienteService;
import dgtic.core.service.detalleventa.DetalleVentaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class VentaServiceImpl implements VentaService{
    private final VentaRepository ventaRepository;
    private final ClienteService clienteService;
    private final DetalleVentaService detalleVentaService;


    public VentaServiceImpl(VentaRepository ventaRepository, ClienteService clienteService, DetalleVentaService detalleVentaService) {
        this.ventaRepository = ventaRepository;
        this.clienteService = clienteService;
        this.detalleVentaService = detalleVentaService;
    }

    @Override
    public List<VentaDTO> findAll() {
        return ventaRepository.findAll().stream().map(Mapper::toVentaDTO).toList();
    }

    @Override
    public VentaDTO findById(Long id) {
        Venta venta=ventaRepository.findById(id)
                .orElseThrow(()->new NotDataFoundException("No existe el dato"));
        return Mapper.toVentaDTO(venta);
    }

    @Override
    public Venta findByIdReturnEntity(Long id) {
        return ventaRepository.findById(id).orElseThrow(()->new NotDataFoundException("No existe el dato"));
    }

    @Override
    public VentaDTO save(VentaDTO ventaDTO) {
        //buscar entity cliente
        Cliente cliente=Mapper.toCliente(
                clienteService.findById(ventaDTO.getCliente()));

        Venta vent=null;
        if(ventaDTO.getId_venta()==null){
            vent=Venta.builder()
                    .id_venta(ventaDTO.getId_venta())
                    .cliente(cliente)
                    .fecha(ventaDTO.getFecha())
                    .total(ventaDTO.getTotal())
                    .build();
        }
        if(vent!=null){
            ventaRepository.save(vent);
        }
        return Mapper.toVentaDTO(vent);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void registerSale(FormularioItemsDTO formulario) {
        VentaDTO ventaDTO=new VentaDTO();
        BigDecimal total = new BigDecimal(formulario.getTotal());
        LocalDate ahora = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        ventaDTO=VentaDTO.builder()
                .cliente(formulario.getId_cliente())
                .total(total.setScale(2, RoundingMode.HALF_UP))
                .fecha(ahora)
                .build();
        VentaDTO ventaDTOFinal=this.save(ventaDTO);
        //buscar la cantidad
        do{
            Long id_producto=formulario.getListaCompra().get(0).getId_producto();
            int cantidad= Math.toIntExact(formulario.getListaCompra().stream()
                    .filter(productoDTO -> Objects.equals(productoDTO.getId_producto(), id_producto))
                    .count());
            detalleVentaService.saveNative(
                    ventaDTOFinal.getId_venta(),
                    id_producto,
                    formulario.getListaCompra().get(0).getPrecio(),
                    cantidad);
            formulario.getListaCompra().removeIf(p-> Objects.equals(p.getId_producto(), id_producto));
        }while (!formulario.getListaCompra().isEmpty());





    }
}
