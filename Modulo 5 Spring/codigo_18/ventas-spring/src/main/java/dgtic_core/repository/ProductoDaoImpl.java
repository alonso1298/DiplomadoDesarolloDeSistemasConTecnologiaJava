package dgtic_core.repository;

import dgtic_core.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return List.of();
    }

    @Override
    public void guardar(Producto producto) throws SQLException {

    }
}
