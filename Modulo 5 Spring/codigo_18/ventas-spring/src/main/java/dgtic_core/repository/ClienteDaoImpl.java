package dgtic_core.repository;

import dgtic_core.model.Cliente;
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
public class ClienteDaoImpl implements IClienteDao{

    @Autowired
    private DataSource cn;

    @Override
    public List<Cliente> lista() throws SQLException {

        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Cliente c = Cliente.builder()
                    .id_cliente(rs.getInt(1))
                    .nombre(rs.getString(2))
                    .telefono(rs.getString(4))
                    .ciudad(rs.getString(5))
                    .build();
            clientes.add(c);
        }
        return clientes;

    }

    @Override
    public Integer guardar(Cliente cliente) throws SQLException {
        String sql="INSERT INTO clientes(nombre, email, telefono, ciudad)" +
                " VALUES(?, ?, ?, ?)";
        PreparedStatement ps=cn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getEmail());
        ps.setString(3, cliente.getTelefono());
        ps.setString(4, cliente.getCiudad());
        int d = ps.executeUpdate();

        return d;
    }

    @Override
    public Integer actualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes set nombre=?, email=?, telefono=?, ciudad=? " +
                "WHERE id_cliente=?";
        PreparedStatement ps= cn.getConnection().prepareStatement(sql);
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getEmail());
        ps.setString(3, cliente.getTelefono());
        ps.setString(4, cliente.getCiudad());
        ps.setInt(5, cliente.getId_cliente());
        return ps.executeUpdate();
    }

}
