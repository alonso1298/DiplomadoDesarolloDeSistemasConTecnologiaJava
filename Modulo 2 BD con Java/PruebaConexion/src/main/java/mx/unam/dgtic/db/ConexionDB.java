package mx.unam.dgtic.db;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConexionDB {

    // Datos de conexion a la base de datos
    String URL = "";
    String USER = "";
    String PASSWORD = "";

    public ConexionDB(){

        //Objeto para ccargar las propiedades de conexion a la BD
        // que se encuentra en resoource/db.prooperties
        Properties props = new Properties();
        try {
            // Carga el archivo db.pproperties a partir del classpath
            props.load(
                    getClass().getClassLoader()
                            .getResourceAsStream("db.properties")
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Asignar los varoles definidos en el archivo a las variables
        this.URL = props.getProperty("db.url");
        this.USER = props.getProperty("db.user");
        this.PASSWORD = props.getProperty("db.password");
    }

    public ConexionDB(String URL, String USER, String PASSWORD) {
        // Asignar los varoles definidos en el archivo a las variables
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        // Obtener una conexion a la base de datos a partir del DriveManager
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}

