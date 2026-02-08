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
    public Integer guardar(Producto producto) throws SQLException {
        String sql = "INSERT INTO productos(nombre, precio, stock)" +
                "VALUES(?, ?, ?)";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, producto.getNombre());
        ps.setDouble(2, producto.getPrecio());
        ps.setInt(3, producto.getStock());
        int p = ps.executeUpdate();

        return p;
    }


}
