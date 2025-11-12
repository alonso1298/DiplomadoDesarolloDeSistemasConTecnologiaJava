package mx.unam.dgtic.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBD {

    // Datos de conexion a la base de datos
    String URL = "";
    String USER = "";
    String PASSWORD = "";

    public ConexionBD() {

        // Objeto para cargar las propiedades de conxion a la BD
        // que se encuentra en resources/db.properties
        Properties props = new Properties();
        try {
            // Cargar el archivo db.properties a partir del classpath
            props.load(
                    getClass().getClassLoader()
                            .getResourceAsStream("db.properties")
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Asignar los valores definidos en el archivo a las variables
        URL = props.getProperty("db.url");
        USER = props.getProperty("db.user");
        PASSWORD = props.getProperty("db.password");
    }

    public ConexionBD(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    public Connection getConnection() throws  SQLException {

        // Obtener una conexion a la base de datos a partir del DriverManager
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }


}
