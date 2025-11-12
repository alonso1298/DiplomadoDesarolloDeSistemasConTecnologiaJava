package mx.unam.dgtic;

import mx.unam.dgtic.dao.IFiguraDAO;
import mx.unam.dgtic.domain.Figura;
import mx.unam.dgtic.impl.FiguraDAODB;

import java.text.SimpleDateFormat;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        IFiguraDAO dao = new FiguraDAODB(); // o new FiguraDAOList();

        System.out.println("=== Listado de figuras ===");
        List<Figura> figuras = dao.listarTodos();
        figuras.forEach(System.out::println);

        // Agregar una figura
        Figura nueva = new Figura();
        nueva.setNombre("Spider-Man");
        nueva.setDescripcion("Figura de Marvel");
        nueva.setFechaLanzamiento(new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-15"));
        nueva.setPrecio(420.0);
        nueva.setIdFabricante(2);
        nueva.setIdEdicion(1);
        dao.guardar(nueva);

        System.out.println("\n=== Después de agregar ===");
        dao.listarTodos().forEach(System.out::println);
    }
}