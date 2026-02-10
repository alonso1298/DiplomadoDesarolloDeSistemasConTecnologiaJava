package dgtic_core.service;

import dgtic_core.model.DetalleVenta;
import dgtic_core.repository.DetalleVentaDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DetalleVentaServicio {

    @Autowired
    DetalleVentaDaoImpl detalleVentaDao;

    public void guardar(DetalleVenta detalleVenta) throws SQLException{
        detalleVentaDao.guardar(detalleVenta);
    }

    public void eliminar(int id) throws SQLException{
        detalleVentaDao.eliminar(id);
    }
}
