package mx.unam.dgtic.impl;

import mx.unam.dgtic.dao.IFiguraDAO;
import mx.unam.dgtic.db.ConexionDB;
import mx.unam.dgtic.domain.Figura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FiguraDAODB implements IFiguraDAO {

    private ConexionDB conexionDB;

    public FiguraDAODB(){
        conexionDB = new ConexionDB();
    }

    @Override
    public List<Figura> listarTodos() {
        String sql = "SELECT * FOM figura ORDER BY id";
        List<Figura> figuras = new ArrayList<>();
        try (
                Connection conexion = conexionDB.getConnection();
                Statement statement = conexion.createStatement();

        ) {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Figura figura = new Figura();
                figura.setId(rs.getInt("id"));
                figura.setNombre(rs.getString("nombre"));
                figura.setDescripcion(rs.getString("descripcion"));
                figura.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));
                figura.setPrecio(rs.getDouble("precio"));
                figura.setIdFabricante(rs.getInt("id_fabricante"));
                figura.setIdEdicion(rs.getInt("id_edicion"));
                figuras.add(figura);
            }

        } catch (SQLException e) {
            // throw new RuntimeException(e);
            System.out.println("Error a conectar con la base de datos");
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return figuras;
    }

    @Override
    public Figura buscarPorId(int id) {
        String sql = "SELECT id, nombre FROM especialidad WHERE id = ?";
        Figura figura = null;

        try (
                Connection conexion = conexionDB.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        ){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                figura = new Figura();
                figura.setId(rs.getInt("id"));
                figura.setNombre(rs.getString("nombre"));
                figura.setDescripcion(rs.getString("descripcion"));
                figura.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));
                figura.setPrecio(rs.getDouble("precio"));
                figura.setIdFabricante(rs.getInt("id_fabricante"));
                figura.setIdEdicion(rs.getInt("id_edicion"));
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar figura por ID");
            e.printStackTrace();
        }

            return figura;
        }
    @Override
    public int guardar(Figura figura) {
        String sql = "INSERT INTO figura(nombre, descripcion, fecha_lanzamiento, precio, id_fabricante, id_edicion) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = conexionDB.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, figura.getNombre());
            ps.setString(2, figura.getDescripcion());
            ps.setDate(3, new java.sql.Date(figura.getFechaLanzamiento().getTime()));
            ps.setDouble(4, figura.getPrecio());
            ps.setInt(5, figura.getIdFabricante());
            ps.setInt(6, figura.getIdEdicion());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                figura.setId(id);
                return id;
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar figura");
            e.printStackTrace();
        }

            return 0;
        }

    @Override
    public void actualizar(Figura figura) {
        String sql = "UPDATE figura SET nombre=?, descripcion=?, fecha_lanzamiento=?, precio=?, id_fabricante=?, id_edicion=? WHERE id=?";

        try (Connection conexion = conexionDB.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, figura.getNombre());
            ps.setString(2, figura.getDescripcion());
            ps.setDate(3, new java.sql.Date(figura.getFechaLanzamiento().getTime()));
            ps.setDouble(4, figura.getPrecio());
            ps.setInt(5, figura.getIdFabricante());
            ps.setInt(6, figura.getIdEdicion());
            ps.setInt(7, figura.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar figura");
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM figura WHERE id = ?";
        try (Connection conexion = conexionDB.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar figura");
            e.printStackTrace();
        }
    }
}
