package mx.unam.dgtic.ejemplosDAO;

import mx.unam.dgtic.dao.EspecialidadDAO;
import mx.unam.dgtic.dao.impl.EspecialidadDAODB;
import mx.unam.dgtic.dao.impl.EspecialidadDAOList;
import mx.unam.dgtic.dominio.Especialidad;

import java.util.List;

public class MainEspecialidadDAO {

    public static void imprimeLista(List<Especialidad> especialidades) {
        for (Especialidad especialidad : especialidades) {
            System.out.println(especialidad);
        }
    }

    public static void main(String[] args) {

        EspecialidadDAO especialidadDAO =  new EspecialidadDAODB(); //new EspecialidadDAOList();

        System.out.println("=====Lista de especialidades");
        List<Especialidad> especialidades = especialidadDAO.listarTodos();

        imprimeLista(especialidades);

        System.out.println("=====Especialidad por ID (3)");
        Especialidad especialidad = especialidadDAO.buscarPorId(3);
        System.out.println(especialidad);
        System.out.println("ID (25)");
        especialidad = especialidadDAO.buscarPorId(25);
        System.out.println(especialidad);

        System.out.println("=====Agregar Especialidad ");
        Especialidad nuevaEspecialidad = new Especialidad(0, "Arte");
        //especialidadDAO.guardar(nuevaEspecialidad);
        System.out.println(nuevaEspecialidad);
        imprimeLista(especialidadDAO.listarTodos());

        System.out.println("=====Editar Especialidad ");
        Especialidad diseno = especialidades.get(1);
        System.out.println(diseno);
        diseno.setNombre("Diseño editorial");
        especialidadDAO.actualizar(diseno);

        imprimeLista(especialidadDAO.listarTodos());

        System.out.println("=====Eliminar Especialidad ");
        especialidadDAO.eliminar(9);
        imprimeLista(especialidadDAO.listarTodos());



    }

}
