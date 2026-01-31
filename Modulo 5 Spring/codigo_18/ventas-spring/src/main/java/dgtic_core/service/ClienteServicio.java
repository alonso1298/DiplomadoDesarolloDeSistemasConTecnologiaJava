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

}
