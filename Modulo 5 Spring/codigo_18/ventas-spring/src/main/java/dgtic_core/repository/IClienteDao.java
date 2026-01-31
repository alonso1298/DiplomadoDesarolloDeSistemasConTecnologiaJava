package dgtic_core.repository;

import dgtic_core.model.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface IClienteDao {

    List<Cliente> list() throws SQLException;

}
