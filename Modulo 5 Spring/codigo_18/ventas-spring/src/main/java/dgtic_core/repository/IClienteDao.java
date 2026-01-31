package dgtic_core.repository;

import dgtic_core.model.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface IClienteDao {

    List<Cliente> lista() throws SQLException;
    Integer guardar(Cliente cliente) throws SQLException;
    Integer actualizar(Cliente cliente) throws SQLException;
    Integer aeliminar(Integer id) throws SQLException;

}
