package dgtic_core.service;

import dgtic_core.model.Cliente;
import dgtic_core.repository.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClienteServicio {
    @Autowired
    private IClienteDao clienteDao;

    public List<Cliente> listaCliente() throws SQLException {
        return clienteDao.lista();
    }
    public int almacenar(Cliente cliente) throws SQLException{
        return clienteDao.guardar(cliente);
    }
    public int actualizar(Cliente cliente) throws SQLException{
        return clienteDao.actualizar(cliente);
    }
    public int eliminar(Integer id) throws SQLException{
        return clienteDao.aeliminar(id);
    }
    public Cliente consultaId(Integer id) throws SQLException {
        return clienteDao.consultaId(id);
    }
}
