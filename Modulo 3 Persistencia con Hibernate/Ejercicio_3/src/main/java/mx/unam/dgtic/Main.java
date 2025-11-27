package mx.unam.dgtic;

import mx.unam.dgtic.dao.*;
import mx.unam.dgtic.entities.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Instancia de DAOS
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        SalaDAO salaDAO = new SalaDAO();
        FuncionDAO funcionDAO = new FuncionDAO();
        BoletoDAO boletoDAO = new BoletoDAO();


        // CONSULTA POR ID
        System.out.println("=== Consultas por ID ===");
        Pelicula pelicula = peliculaDAO.findById(1);
        System.out.println("Pelicula ID 1: " + pelicula);

        Sala sala = salaDAO.findById(1);
        System.out.println("Sala ID 1: " + sala);

        Funcion funcion = funcionDAO.findById(1);
        System.out.println("Función ID 1: " + funcion);

        Boleto boleto = boletoDAO.findById(1);
        System.out.println("Boleto ID 1: " + boleto);


        // CONSULTAS JPQL EXTRA
        System.out.println("\n=== Consultas JPQL ===");

        List<Pelicula> peliculasLargas = peliculaDAO.findByDuracionMayor(150);
        System.out.println("Películas con duración > 150 min: " + peliculasLargas);

        List<Pelicula> peliculasPG = peliculaDAO.buscarPorClasificacion("PG-13");
        System.out.println("Películas PG-13: " + peliculasPG);

        List<Sala> salasGrandes = salaDAO.buscarPorCapacidadMinima(150);
        System.out.println("Salas > 150 butacas: " + salasGrandes);

        Sala salaPorNombre = salaDAO.buscarPorNombre("Sala 1 IMAX");
        System.out.println("Sala exacta: " + salaPorNombre);

        List<Funcion> funcionesHoy = funcionDAO.buscarPorFecha(LocalDate.of(2025, 2, 15));
        System.out.println("Funciones el 2025-02-15: " + funcionesHoy);

        List<Funcion> funcionesPelicula = funcionDAO.buscarPorPelicula(2);
        System.out.println("Funciones de película con ID 2: " + funcionesPelicula);

        List<Boleto> boletosTipoA = boletoDAO.buscarPorTipoAsiento("A");
        System.out.println("Boletos tipo A: " + boletosTipoA);


        // INSERTAR NUEVO REGISTRO
        System.out.println("\n=== Insertando nueva película ===");
        Pelicula nueva = new Pelicula();
        nueva.setTitulo("Nueva Película");
        nueva.setDuracion(120);
        nueva.setClasificacion("PG");

        peliculaDAO.save(nueva);
        System.out.println("Película insertada: " + nueva);


        // ACTUALIZAR
        System.out.println("\n=== Actualizando película ===");
        nueva.setDuracion(130);
        peliculaDAO.update(nueva);
        System.out.println("Película actualizada: " + nueva);


        // ELIMINAR
        System.out.println("\n=== Eliminando película ===");
        peliculaDAO.delete(nueva.getIdPelicula());
        System.out.println("Película eliminada.");

    }
}