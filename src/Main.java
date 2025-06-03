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
        PreparedStatement myStamt = null;

        //Establecemos una conexion de prueba dentro de un try
        try {
            //Se pasan 3 parametros: URL, usuario y contraseña
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project",
                    "root", "Admin1234");
            System.out.println("Genial, nos conectamos");

            //Secuencia SQL
            String sql = ("INSERT INTO employees(first_name, pa_surname) VALUES(?, ?)");
            myStamt = myConn.prepareStatement(sql);
            //Values a insertar con la secuencia SQL
            myStamt.setString(1, "Johana");
            myStamt.setString(2, "Dorantes");

            //Ejecutamos las instrucciones para SQL
            int rowsAffected = myStamt.executeUpdate();

            //En caso de haber cambios, se informara con un print
            if(rowsAffected > 0){
                System.out.println("Se ha creado un nuevo empleado");
            }

        } catch (Exception e) { //Catch en caso de no lograr la conexion
            e.printStackTrace();
            System.out.println("Algo salio mal");
        }
    }
}