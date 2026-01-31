package dgtic_core.repository;

import dgtic_core.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}
