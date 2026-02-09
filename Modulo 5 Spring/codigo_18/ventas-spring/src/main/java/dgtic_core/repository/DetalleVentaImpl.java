package dgtic_core.repository;

import dgtic_core.model.DetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DetalleVentaImpl implements IDetalleVentaDao{

    @Autowired
    DataSource cn;

    @Override
    public List<DetalleVenta> lista() throws SQLException {
        List<DetalleVenta> detalleVentas = new ArrayList<>();
        String sql = "SELECT * FROM detalle_venta";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            DetalleVenta detalleVenta = DetalleVenta.builder()
                    .cantidad(rs.getInt(1))
                    .idDetalle(rs.getInt(2))
                    .idProducto(rs.getInt(3))
                    .idVenta(rs.getInt(4))
                    .precioUnitario(rs.getDouble(5))
                    .build();
        }
        return detalleVentas;
    }

    @Override
    public void guardar(DetalleVenta detalleVenta) throws SQLException {
        String sql = "INSERT INTO detalle_venta(cantidad, id_detalle, id_producto, id_venta, precio_unitario)" +
                "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, detalleVenta.getCantidad());
        ps.setInt(2, detalleVenta.getIdProducto());
        ps.setInt(3, detalleVenta.getIdVenta());
        ps.setDouble(4, detalleVenta.getPrecioUnitario());
        ps.executeUpdate();

    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM detalle_venta WHERE id_detalle=?";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            DetalleVenta detalleVenta = DetalleVenta.builder()
                    .idDetalle(rs.getInt(1))
                    .cantidad(rs.getInt(2))
                    .idProducto(rs.getInt(3))
                    .idVenta(rs.getInt(4))
                    .precioUnitario(rs.getDouble(5))
                    .build();

        }
    }
}
