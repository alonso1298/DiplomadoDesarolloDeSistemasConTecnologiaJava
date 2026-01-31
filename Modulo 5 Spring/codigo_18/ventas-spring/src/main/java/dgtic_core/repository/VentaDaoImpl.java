package dgtic_core.repository;

import dgtic_core.model.Cliente;
import dgtic_core.model.Venta;
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
public class VentaDaoImpl implements IVentaDao {
    @Autowired
    private DataSource cn;



    @Override
    public List<Venta> listar() throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "select * from "+
                "ventas a join clientes b on a.id_cliente=b.id_cliente;";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Venta venta = Venta.builder()
                    .id_venta(rs.getInt(1))
                    .fecha(rs.getDate(3))
                    .total(rs.getDouble(4))
                    .build();
            Cliente cliente=Cliente.builder()
                    .id_cliente(rs.getInt(5))
                    .nombre(rs.getString(6))
                    .email(rs.getString(7))
                    .telefono(rs.getString(8))
                    .ciudad(rs.getString(9))
                    .build();
            venta.setCliente(cliente);
            ventas.add(venta);
        }
        return ventas;
    }

    @Override
    public Integer guardar(Venta venta) throws SQLException {
        String sql = "INSERT INTO ventas(id_cliente,fecha,total) VALUES (?,?,?)";
        //cn.getConnection().setAutoCommit(true);
        PreparedStatement ps = cn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,venta.getCliente().getId_cliente());
        java.sql.Date sqlDate = new java.sql.Date(venta.getFecha().getTime());
        ps.setDate(2,sqlDate);
        ps.setDouble(3,venta.getTotal());
        int id = ps.executeUpdate();
        ResultSet rs= ps.getGeneratedKeys();
        rs.next();
        System.out.println(rs.getInt(1));

        return id;
    }

    @Override
    public Integer actualizar(Venta venta) throws SQLException {
        String sql = "UPDATE ventas SET id_cliente=?, fecha=?,total=? WHERE id_venta=?";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,venta.getCliente().getId_cliente());
        ps.setDate(2,new java.sql.Date(venta.getFecha().getTime()));
        ps.setDouble(3,venta.getTotal());
        ps.setInt(4,venta.getId_venta());
        return ps.executeUpdate();
    }
    @Override
    public Integer eliminar(Integer id) throws SQLException {
        String sql = "DELETE FROM ventas WHERE id_venta = ?";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,id);
        return ps.executeUpdate();
    }

    @Override
    public Venta consultaId(Integer id) throws SQLException  {
        Venta venta=null;
        String sql = "SELECT * FROM venta a,cliente b WHERE id_venta=?"+
                " a.id_cliente=b.id_cliente";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            venta = Venta.builder()
                    .id_venta(rs.getInt(1))
                    .fecha(rs.getDate(3))
                    .total(rs.getDouble(4))
                    .build();
            Cliente cliente=Cliente.builder()
                    .id_cliente(rs.getInt(5))
                    .nombre(rs.getString(6))
                    .email(rs.getString(7))
                    .ciudad(rs.getString(8))
                    .build();
            venta.setCliente(cliente);
        }
        return venta;
    }
}
