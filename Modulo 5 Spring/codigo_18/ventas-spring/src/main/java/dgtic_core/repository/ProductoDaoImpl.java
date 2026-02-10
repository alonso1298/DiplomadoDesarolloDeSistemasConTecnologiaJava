package dgtic_core.repository;

import dgtic_core.model.Producto;
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
public class ProductoDaoImpl implements IProductoDao{

    @Autowired
    DataSource cn;

    @Override
    public List<Producto> lista() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Producto p = Producto.builder()
                    .id_producto(rs.getInt(1))
                    .nombre(rs.getString(2))
                    .precio(rs.getDouble(3))
                    .stock(rs.getInt(4))
                    .build();
            productos.add(p);
        }
        return productos;
    }

    @Override
    public Producto buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FOM productos WHERE id_producto=?";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return null;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql = "INSERT INTO productos(nombre, precio, stock)" +
                "VALUES(?, ?, ?)";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, producto.getNombre());
        ps.setDouble(2, producto.getPrecio());
        ps.setInt(3, producto.getStock());
        ps.executeUpdate();
    }

    @Override
    public void actualizar(Producto producto) throws SQLException {
        String sql = "UPDATE productos set nombre=?, precio=?, stock=?" +
                "WHERE id_producto=?";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql);
        ps.setString(1, producto.getNombre());
        ps.setDouble(2, producto.getPrecio());
        ps.setInt(3, producto.getStock());
        ps.setInt(4, producto.getId_producto());
    }

    @Override
    public Integer eliminar(int id) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id_producto=?";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }


}
