package mx.unam.dgtic;

import mx.unam.dgtic.entities.Pelicula;
import mx.unam.dgtic.service.PeliculaService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PeliculaService service = new PeliculaService();

        // Insert
        Pelicula nueva = new Pelicula();
        nueva.setTitulo("Batman 2025");
        nueva.setDuracion(150);
        nueva.setClasificacion("PG-13");
        service.crearPelicula(nueva);

        // Select
        service.obtenerPeliculas().forEach(
                p -> System.out.println(p.getTitulo())
        );

        // Update
        Pelicula p = service.obtenerPelicula(1);
        p.setTitulo("Avengers: Endgame (Extended)");
        service.actualizarPelicula(p);

        // Delete
        service.eliminarPelicula(3);
    }
}