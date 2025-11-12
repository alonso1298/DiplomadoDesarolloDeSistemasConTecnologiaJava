package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.InstructorDAO;
import mx.unam.dgtic.dominio.Especialidad;
import mx.unam.dgtic.dominio.Instructor;

import java.sql.*;

public class InstructorDAOImpl extends InstructorDAODB implements InstructorDAO {
    @Override
    public void insertarInstructorConEspecialidad(Instructor instructor, Especialidad especialidad) {
        String sqlInstructor = "INSERT INTO instructor  " +
                "(nombre, apellido_paterno, correo_electronico, id_especialidad) " +
                "VALUES (?,?,?,?)";

        String sqlEspecialidad = "INSERT INTO especialidad  " +
                "(nombre) VALUES (?)";

        try(
                Connection connection = conexionBD.getConnection()
        ){

            connection.setAutoCommit(false);

            try(PreparedStatement instructorStatement = connection.prepareStatement(sqlInstructor,
                    Statement.RETURN_GENERATED_KEYS);
                PreparedStatement especialidadStatement = connection.prepareStatement(sqlEspecialidad,
                        Statement.RETURN_GENERATED_KEYS);){

                especialidadStatement.setString(1, especialidad.getNombre());
                //especialidadStatement.setString(1, null);
                int resultado = especialidadStatement.executeUpdate();

                int especialidadId = getGeneratedId(especialidadStatement);
                //instructor.getEspecialidad().setId(especialidadId);

                instructorStatement.setString(1, instructor.getNombre());
                //instructorStatement.setString(1, null);
                instructorStatement.setString(2, instructor.getApellidoPaterno());
                instructorStatement.setString(3, instructor.getCorreoElectronico());
                instructorStatement.setInt(4, especialidadId);

                resultado = instructorStatement.executeUpdate();
                //return resultado;
                int instructorId = getGeneratedId(instructorStatement);
                instructor.setId(instructorId);
                instructor.setEspecialidad(especialidad);

                connection.commit();


            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getGeneratedId(PreparedStatement ps) throws SQLException {
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            return generatedKeys.getInt(1);
        }
        return 0;
    }
}
