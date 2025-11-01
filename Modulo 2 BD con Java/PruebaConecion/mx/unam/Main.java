package mx.unam;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/cursos";
        String user = "root";
        String password = "56457977Ac*";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }

    }
}
