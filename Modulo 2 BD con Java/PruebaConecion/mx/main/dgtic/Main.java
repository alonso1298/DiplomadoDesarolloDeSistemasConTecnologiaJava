package mx.main.dgtic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/cursos";
        String USER = "root";
        String PASSWORD = "56457977Ac*";

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // throw new RuntimeException(e);
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }

    }
}
