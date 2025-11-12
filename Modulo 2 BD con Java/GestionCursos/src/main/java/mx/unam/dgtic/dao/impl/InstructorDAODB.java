package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.GenericDAO;
import mx.unam.dgtic.db.ConexionBD;
import mx.unam.dgtic.dominio.Especialidad;
import mx.unam.dgtic.dominio.Instructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstructorDAODB implements GenericDAO<Instructor> {

    protected ConexionBD conexionBD;

    public InstructorDAODB() {
        conexionBD = new ConexionBD();
    }

    @Override
    public List<Instructor> listarTodos() {

        String sql = "SELECT i.id i_id, i.nombre i_nombre, i.apellido_paterno i_apellido, i.correo_electronico i_correo, e.id e_id, e.nombre e_nombre FROM instructor i JOIN especialidad e ON i.id_especialidad = e.id ORDER BY i.id";

        List<Instructor> instructores = new ArrayList<Instructor>();

        try (
                Connection conexion = conexionBD.getConnection();
                Statement statement = conexion.createStatement();
        ){
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Instructor instructor = new Instructor();
                instructor.setId(rs.getInt("i_id"));
                instructor.setNombre(rs.getString("i_nombre"));
                instructor.setApellidoPaterno(rs.getString("i_apellido"));
                instructor.setCorreoElectronico(rs.getString("i_correo"));

                Especialidad especialidad = new Especialidad();
                especialidad.setId(rs.getInt("e_id"));
                especialidad.setNombre(rs.getString("e_nombre"));

                instructor.setEspecialidad(especialidad);

                instructores.add(instructor);
            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }
        return instructores;
    }

    @Override
    public Instructor buscarPorId(int id) {
        String sql = "SELECT i.id i_id, i.nombre i_nombre, i.apellido_paterno i_apellido, i.correo_electronico i_correo, e.id e_id, e.nombre e_nombre FROM instructor i JOIN especialidad e ON i.id_especialidad = e.id WHERE i.id = ?";

        Instructor instructor = new Instructor();

        try (
                Connection conexion = conexionBD.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        ){

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                instructor = new Instructor();
                instructor.setId(rs.getInt("i_id"));
                instructor.setNombre(rs.getString("i_nombre"));
                instructor.setApellidoPaterno(rs.getString("i_apellido"));
                instructor.setCorreoElectronico(rs.getString("i_correo"));

                Especialidad especialidad = new Especialidad();
                especialidad.setId(rs.getInt("e_id"));
                especialidad.setNombre(rs.getString("e_nombre"));

                instructor.setEspecialidad(especialidad);

            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }
        return instructor;
    }

    @Override
    public int guardar(Instructor instructor) {
        String sql = "INSERT INTO instructor  " +
                "(nombre, apellido_paterno, correo_electronico, id_especialidad) " +
                "VALUES (?,?,?,?)";

        try(
                Connection conexion = conexionBD.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
        ){

            preparedStatement.setString(1, instructor.getNombre());
            preparedStatement.setString(2, instructor.getApellidoPaterno());
            preparedStatement.setString(3, instructor.getCorreoElectronico());
            preparedStatement.setInt(4, instructor.getEspecialidad().getId());

            int resultado = preparedStatement.executeUpdate();
            //return resultado;


            // Get the id
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                int id = generatedKeys.getInt(1);
                instructor.setId(id);
                return id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

        return 0;
    }

    @Override
    public void actualizar(Instructor instructor) {
        String sql = "UPDATE instructor SET " +
                "nombre = ?, apellido_paterno = ?, id_especialidad = ?, correo_electronico = ? WHERE id = ?";


        try(
                Connection conexion = conexionBD.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        ){
            preparedStatement.setString(1, instructor.getNombre());
            preparedStatement.setString(2, instructor.getApellidoPaterno());
            preparedStatement.setInt(3, instructor.getEspecialidad().getId());
            preparedStatement.setString(4, instructor.getCorreoElectronico());
            preparedStatement.setInt(5, instructor.getId());

            int updated = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM instructor WHERE id = ?";

        try(
                Connection conexion = conexionBD.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        ){
            preparedStatement.setInt(1, id);
            int deleted =  preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
