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
        //Declaramos 3 variables para la conexion a la BD, e importamos sus bibliotecas
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;

        //Establecemos una conexion de prueba dentro de un try
        try {
            //Se pasan 3 parametros: URL, usuario y contraseña
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project",
                    "root", "Admin1234");
            System.out.println("Genial, nos conectamos");

            //Hacemos una consulta a la BD
            //Objeto Statement
            myStamt = myConn.createStatement();
            //Sentencia SQL para consultar todos los valores de la tabla employees
            myRes = myStamt.executeQuery("SELECT * FROM employees");

            //Imprime todos los valores del campo first_name de la tabla consultada
            while(myRes.next()){
                System.out.println(myRes.getString("first_name"));
            }

        } catch (Exception e) { //Catch en caso de no lograr la conexion
            e.printStackTrace();
            System.out.println("Algo salio mal");
        }
    }
}