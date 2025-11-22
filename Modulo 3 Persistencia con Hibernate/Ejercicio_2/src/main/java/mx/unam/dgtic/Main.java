package mx.unam.dgtic;

import mx.unam.dgtic.dao.FuncionDAO;
import mx.unam.dgtic.dao.PeliculaDAO;
import mx.unam.dgtic.entities.Funcion;
import mx.unam.dgtic.entities.Pelicula;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        FuncionDAO funcionDAO = new FuncionDAO();

        Pelicula pelicula = peliculaDAO.findById(1);
        Funcion funcion = funcionDAO.findById(1);

        System.out.println(pelicula.toString());
        System.out.println(funcion.toString());
    }
}