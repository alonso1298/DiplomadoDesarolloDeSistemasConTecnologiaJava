package mx.unam.dgtic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import mx.unam.dgtic.db.ConexionDB;

public class Main {
    public static void main(String[] args) {

        ConexionDB conexionDB = new ConexionDB();

        try {
            // Obtener una conexion a la base de datos a partir del DriveManager
            Connection conexion = conexionDB.getConnection();
            // Obtener un objeto Statement para realizar consultaas a la base de datos
            Statement statement = conexion.createStatement();

            // Realiza consuta y recibir los datos en un objeto ResultSet
            ResultSet resultado = statement.executeQuery("SELECT * FROM estudiante");
            // Recorrer el resultado
            while (resultado.next()){

                /**
                 *  Ejemplo resultado:
                 *
                 *  | id | nombre | apellido_paterno | correo_electronico | numero_cuenta |
                 *  | 1 |  Juan  |    Pérez         |   jperez@unam.mx   |   00112       |
                 *  ...
                 *  ...
                 *
                 * resultado.getInt("id") -> obtiene el valor entero de la columna llamada "id"
                 * resultado.getString("nombre") -> obtiene el valor de texto de la columna llamada "nombre"
                 *
                 */

                int idEstudiante = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String apellidoPaterno = resultado.getString("apellido");
                String correoElectronico = resultado.getString("correo_electronico");
                String numeroCuenta = resultado.getString("numero_cuenta");

                System.out.println(idEstudiante + ", " +
                        nombre + ", " + apellidoPaterno + ", " +
                        correoElectronico + ", " + numeroCuenta);

            }

            // Cerrar los objetos que se conectaron a la base de datos para liberar los recursos
            statement.close();
            conexion.close();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }
    }
}
