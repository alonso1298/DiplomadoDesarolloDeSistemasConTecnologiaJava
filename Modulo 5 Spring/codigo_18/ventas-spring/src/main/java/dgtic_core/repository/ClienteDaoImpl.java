package dgtic_core.repository;

import dgtic_core.model.Cliente;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteDaoImpl implements IClienteDao{

    @Override
    public List<Cliente> list() throws SQLException {
        return List.of();
    }

}
