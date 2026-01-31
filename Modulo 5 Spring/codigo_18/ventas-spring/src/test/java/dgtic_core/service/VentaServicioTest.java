package dgtic_core.service;

import dgtic_core.model.Cliente;
import dgtic_core.model.Venta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VentaServicioTest {

    @Autowired
    VentaServicio ventaServicio;

    @Test
    void lista(){
        try {
            assertEquals(50, ventaServicio.listasVentas().size());
            System.out.println(ventaServicio.listasVentas().get(0).getCliente());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void guardar() throws ParseException, SQLException{

        Cliente cliente=Cliente.builder()
                .id_cliente(2)
                .nombre("Demo22")
                .email("demo@demo.com")
                .telefono("343-343")
                .ciudad("CDMX")
                .build();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fecha="2026-10-12";
        Date fechaFinal=formateador.parse(fecha);


        Venta venta=Venta.builder()
                .cliente(cliente)
                .fecha(fechaFinal)
                .total(343.22)
                .build();
        try {
            int d=ventaServicio.almacenar(venta);
            System.out.println(d);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}