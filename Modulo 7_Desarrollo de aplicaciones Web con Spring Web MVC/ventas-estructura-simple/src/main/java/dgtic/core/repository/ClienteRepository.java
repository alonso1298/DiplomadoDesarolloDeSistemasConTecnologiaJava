package dgtic.core.repository;

import dgtic.core.model.dto.cliente.ClienteBusquedaDTO;
import dgtic.core.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    @Query("""
            SELECT c
                   FROM Cliente c
                   JOIN FETCH c.ventas p         
                   WHERE c.id_cliente = :id
            """)
    Optional<Cliente> findById(@Param("id") Long id);

    @Query("SELECT new dgtic.core.model.dto.cliente.ClienteBusquedaDTO(a.id_cliente,a.nombre)" +
            " FROM Cliente a WHERE a.nombre LIKE %?1% or a.email LIKE %?1%")
    List<ClienteBusquedaDTO> findClienteView(String dato);

    @Query("SELECT DISTINCT a.ciudad" +
            " FROM Cliente a")
    List<String> findCiudadView();

}
