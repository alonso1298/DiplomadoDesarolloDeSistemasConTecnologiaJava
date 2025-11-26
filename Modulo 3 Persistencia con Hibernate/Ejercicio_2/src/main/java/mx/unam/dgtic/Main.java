package mx.unam.dgtic;

import mx.unam.dgtic.dao.FuncionDAO;
import mx.unam.dgtic.dao.PeliculaDAO;
import mx.unam.dgtic.entities.Pelicula;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        FuncionDAO funcionDAO = new FuncionDAO();

        Pelicula pelicula = peliculaDAO.findById(1);
        //Funcion funcion = funcionDAO.findById(1);

        // Metodos Extra con JPQL
        List<Pelicula> buscarPeliculaDuracion = peliculaDAO.findByDuracionMayor(100);
        List<Pelicula> bucarPeliculaNombre = peliculaDAO.findByName("coco");

        System.out.println(pelicula.toString());
        //System.out.println(funcion.toString());

        // Metodo extra
        System.out.println(buscarPeliculaDuracion);
        System.out.println(bucarPeliculaNombre);

    }
}