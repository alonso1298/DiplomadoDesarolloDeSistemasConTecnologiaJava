package dgtic_core.service;

import dgtic_core.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteServicioTest {

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    DataSource conexion;

    @Test
    void cnn(){
        Exception ex=assertThrows(Exception.class, ()->{
            conexion.getConnection();
        });
        assertNotNull(ex.getMessage());
        System.out.println(ex.getMessage());
    }

    @Test
    void lista(){
        try {
            assertEquals(40, clienteServicio.listaCliente().size());
            System.out.println(clienteServicio.listaCliente().size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void insertar() throws SQLException {
        Cliente cliente = Cliente.builder()
                .nombre("Demo2")
                .ciudad("CDMX")
                .email("demo@demo.com")
                .telefono("3343-345")
                .build();
        Integer actual = clienteServicio.almacenar(cliente);
        assertEquals(11, actual, "Esperando " + 11 + " actual es " + actual);
    }
    @Test
    void actualizar() throws SQLException{
        Cliente cliente = Cliente.builder()
                .id_cliente(1)
                .nombre("DGTIC")
                .ciudad("CDMX")
                .email("demo@demo.com")
                .telefono("3343-345")
                .build();
        Integer actual = clienteServicio.actualizar(cliente);
        assertEquals(1, actual, "Esperando " + 1 + " actual es " + actual);
    }
    @Test
    void eliminar() throws SQLException {
        Integer actual=clienteServicio.eliminar(1);
        assertEquals(1, actual, "Esperando " + 1 + " actual es " + actual);
    }
    @Test
    void consultaId()throws SQLException{
        Cliente cliente = clienteServicio.consultaId(2);
        assertEquals("Monterry", cliente.getCiudad(), "No es la misma ciudad");
    }
    @Test
    void pruebaLogica() throws SQLException {
        //Trae los datos de todos los clientes, para llenar una tabla
        List<Cliente> lista = clienteServicio.listaCliente();
        
    }

}