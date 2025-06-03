import java.sql.*;
/* Creamos uno nuevo proyecto con Java y que nos agregue un simple codigo, solo para despues
borrarlo y quedarnos con la clase Main y empezar a trabajar.
Vamos a descargar el "mysql connector java" de la pagina https://dev.mysql.com/downloads/connector/j/
como sistema operativo seleccionamos "plataforma independiente", y descargamos el ZIP Archive
Una vez descargado descomprimimos y copiamos el archivo .jar en una nueva carpeta llamada "Conector".
Vamos a IntelliJ, menu File, Project Structure, Modules, Dependencias, clic en +, JARs or Directories, y
especificamos la ruta de la carpeta Conector y clic a Ok en todo
* */
public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;

        //Establecemos una conexion de prueba dentro de un try
        try {
            //Se pasan 3 parametros: URL, usuario y contraseña
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project",
                    "root", "Admin1234");
            System.out.println("Genial, nos conectamos");

            //Objeto Statement
            myStamt = myConn.createStatement();

            //Ejecutamos las instrucciones SQL para actualizar un email
            int rowsAffected = myStamt.executeUpdate(" UPDATE employees " +
                    " set email='johanador2@mail.com' " + " WHERE first_name = 'Johana' ");

            /*
            //Eliminacion de un empleado
            int rowsAffected = myStamt.executeUpdate(" DELETE FROM employees " +
                    "WHERE first_name = 'David' ");
             */

            //Despues de hacer el UPDATE hacemos la consulta de la tabla employees, obteniendo
            //solamente first_name y email, ordemadps por el campo pa_surname
            System.out.println("Empleados Actuales:");
            myRes = myStamt.executeQuery("SELECT * FROM employees ORDER BY pa_surname");
            while( myRes.next() ){
                System.out.println(myRes.getString("first_name") + "," + myRes.getString("email"));
            }

        } catch (Exception e) { //Catch en caso de no lograr la conexion
            e.printStackTrace();
            System.out.println("Algo salio mal");
        }
    }
}