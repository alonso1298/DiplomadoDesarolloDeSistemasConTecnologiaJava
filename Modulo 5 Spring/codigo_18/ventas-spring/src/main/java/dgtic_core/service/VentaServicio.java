package dgtic_core.service;

import dgtic_core.model.Venta;
import dgtic_core.repository.IVentaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class VentaServicio {
    @Autowired
    private IVentaDao ventasDao;


    public List<Venta> listasVentas() throws SQLException {
        return ventasDao.listar();
    }
    public Integer almacenar(Venta venta) throws SQLException{
        return ventasDao.guardar(venta);
    }
    public Integer actualizar(Venta venta)throws SQLException{
        return ventasDao.actualizar(venta);
    }
    public Integer eliminar(Integer id)throws SQLException{
        return ventasDao.eliminar(id);
    }
    public Venta consultaId(Integer id) throws SQLException {
        return ventasDao.consultaId(id);
    }
}
