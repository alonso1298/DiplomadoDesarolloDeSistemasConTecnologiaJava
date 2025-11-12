package mx.unam.dgtic.ejemplosDAO;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.dao.InstructorDAO;
import mx.unam.dgtic.dao.impl.InstructorDAODB;
import mx.unam.dgtic.dao.impl.InstructorDAOImpl;
import mx.unam.dgtic.dominio.Especialidad;
import mx.unam.dgtic.dominio.Instructor;

import java.util.List;

public class MainInstructorDAO {

    public static void imprimeLista(List<Instructor> instructores) {
        for (Instructor instructor : instructores) {
            System.out.println(instructor);
        }
    }

    public static void main(String[] args) {

        GenericDAO<Instructor> instructorGenericDAO = new InstructorDAODB();
        /*
        System.out.println("====Lista de instructores");
        List<Instructor> instructores = instructorGenericDAO.listarTodos();
        for (Instructor instructor : instructores) {
            System.out.println(instructor);
        }

        System.out.println("====Instructor por ID (5)");
        Instructor instructor = instructorGenericDAO.buscarPorId(5);
        System.out.println(instructor);

        System.out.println("====Nuevo Instructor");

        Especialidad cienciasSociales = new Especialidad();
        cienciasSociales.setId(4);

        Instructor nuevoInstructor = new Instructor(
                0,
                "Jaime",
                "Rodríguez",
                "jrodriguez@unam.mx",
                cienciasSociales
        );
        //instructorGenericDAO.guardar(nuevoInstructor);
        imprimeLista(instructorGenericDAO.listarTodos());


        System.out.println("====Actualiza Instructor");
        Instructor actualizaInstructor = instructores.get(1);
        actualizaInstructor.setCorreoElectronico("sofia.valle@unam.mx");
        instructorGenericDAO.actualizar(actualizaInstructor);
        imprimeLista(instructorGenericDAO.listarTodos());

        System.out.println("====Eliminar Instructor");
        instructorGenericDAO.eliminar(7);
        imprimeLista(instructorGenericDAO.listarTodos());
        */

        System.out.println("====Inserta instructor y Especialidad");
        Especialidad musica = new Especialidad(0, "Música");
        Instructor jorge = new Instructor(
                0,
                "Jorge",
                "Rodríguez",
                "jorge.rodriguez@unam.mx",
                null
        );

        InstructorDAO instructorDAO = new InstructorDAOImpl();
        instructorDAO.insertarInstructorConEspecialidad(jorge, musica);

    }
}
