package mx.unam.dgtic.dao.impl;

import mx.unam.dgtic.dao.EspecialidadDAO;
import mx.unam.dgtic.db.ConexionBD;
import mx.unam.dgtic.dominio.Especialidad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadDAODB implements EspecialidadDAO {

    private ConexionBD conexionBD;

    public EspecialidadDAODB() {
        conexionBD = new ConexionBD();
    }

    @Override
    public List<Especialidad> listarTodos() {
        String sql = "SELECT id, nombre FROM especialidad ORDER BY id";
        List<Especialidad> especialidades = new ArrayList<Especialidad>();

        try (
            Connection conexion = conexionBD.getConnection();
            Statement statement = conexion.createStatement();
        ){

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Especialidad especialidad = new Especialidad();
                especialidad.setId(rs.getInt("id"));
                especialidad.setNombre(rs.getString("nombre"));

                especialidades.add(especialidad);
            }


        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }

        return especialidades;

    }

    @Override
    public Especialidad buscarPorId(int id) {
        String sql = "SELECT id, nombre FROM especialidad WHERE id = ?";
        Especialidad especialidad = null;

        try (
                Connection conexion = conexionBD.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        ){

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                especialidad = new Especialidad();
                especialidad.setId(rs.getInt("id"));
                especialidad.setNombre(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }

        return especialidad;
    }

    @Override
    public int guardar(Especialidad especialidad) {
        String sql = "INSERT INTO especialidad(nombre) VALUES (?)";
        try (
                Connection conexion = conexionBD.getConnection();
                // Agregar parámetro Statement.RETURN_GENERATED_KEYS
                // para obtener la llave primaria generada al insertar
                PreparedStatement preparedStatement = conexion.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
        ){
            // Asignar el parámetro nombre que viene en el objeto
            preparedStatement.setString(1, especialidad.getNombre());
            int resultado = preparedStatement.executeUpdate();

            // Obtener el ID
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                especialidad.setId(id);
                return id;
            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
            return 0;
        }

        return 0;
    }

    @Override
    public void actualizar(Especialidad especialidad) {
        String sql = "UPDATE especialidad SET nombre = ? WHERE id = ?";
        try (
                Connection conexion = conexionBD.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        ){
            // Asignar los parámetros
            preparedStatement.setString(1, especialidad.getNombre());
            preparedStatement.setInt(2, especialidad.getId());

            int resultado = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM especialidad WHERE id = ?";
        try (
                Connection conexion = conexionBD.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        ){
            // Asignar los parámetros
            preparedStatement.setInt(1, id);
            int resultado = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }

    }
}
