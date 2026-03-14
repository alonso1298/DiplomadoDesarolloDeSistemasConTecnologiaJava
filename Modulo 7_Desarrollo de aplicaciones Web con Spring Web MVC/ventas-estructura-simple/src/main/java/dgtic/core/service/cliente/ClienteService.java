package dgtic.core.service.cliente;

import dgtic.core.model.dto.cliente.ClienteBusquedaDTO;
import dgtic.core.model.dto.cliente.ClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> findAll();
    ClienteDTO findById(Long id);
    ClienteDTO save(ClienteDTO clienteDTO);
    void deleteById(Long id);
    Page<ClienteDTO> findByPage(Pageable pageable);
    List<ClienteBusquedaDTO> findClienteView(String dato);
    List<String> findCiudadView();
}
