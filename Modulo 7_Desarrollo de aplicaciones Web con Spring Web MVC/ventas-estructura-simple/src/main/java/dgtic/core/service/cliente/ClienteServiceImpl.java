package dgtic.core.service.cliente;

import dgtic.core.exception.NotDataFoundException;
import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.cliente.ClienteBusquedaDTO;
import dgtic.core.model.dto.cliente.ClienteDTO;
import dgtic.core.model.entity.Cliente;
import dgtic.core.repository.ClienteRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream().map(Mapper::toClienteDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id) {
        Cliente cliente=clienteRepository.findById(id)
                .orElseThrow(() -> new NotDataFoundException("No existe el dato"));
        return Mapper.toClienteDTO(cliente);
    }

    @Override
    @Transactional
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente=null;
        if (clienteDTO.getId_cliente() != null) {
            cliente=Cliente.builder()
                    .id_cliente(clienteDTO.getId_cliente())
                    .nombre(clienteDTO.getNombre())
                    .email(clienteDTO.getEmail())
                    .telefono(clienteDTO.getTelefono())
                    .ciudad(clienteDTO.getCiudad())
                    .build();
        }else{
            cliente=Cliente.builder()
                    .nombre(clienteDTO.getNombre())
                    .email(clienteDTO.getEmail())
                    .telefono(clienteDTO.getTelefono())
                    .ciudad(clienteDTO.getCiudad())
                    .build();
        }
        return Mapper.toClienteDTO(clienteRepository.save(cliente));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(!clienteRepository.existsById(id)){
            throw new NotDataFoundException("No existe el dato");
        }
        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClienteDTO> findByPage(Pageable pageable) {
        List<ClienteDTO> list=clienteRepository.findAll().stream()
                .map(Mapper::toClienteDTO).toList();
        int start = Math.min((int)pageable.getOffset(), list.size());
        int end = Math.min((start + pageable.getPageSize()), list.size());
        return new PageImpl<>(list.subList(start,end),pageable, list.size());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteBusquedaDTO> findClienteView(String dato) {
        return clienteRepository.findClienteView(dato);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> findCiudadView() {
        return clienteRepository.findCiudadView();
    }
}
