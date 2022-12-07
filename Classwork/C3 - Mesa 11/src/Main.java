import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        //quiero conectarme a la base de datos.
        //Necesito saber de la misma.
        Connection connection = null;
        try {
            connection = getConnection();
            //preparar nuestro mensaje a la base de datos.
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS FIGURAS; \n " +
                            "CREATE TABLE FIGURAS (id INT PRIMARY KEY, figura VARCHAR(50), color VARCHAR(50)); \n" +
                            "INSERT INTO FIGURAS VALUES(1, 'circulo', 'rojo'); \n" +
                            "INSERT INTO FIGURAS VALUES(2, 'circulo', 'azul'); \n" +
                            "INSERT INTO FIGURAS VALUES(3, 'cuadrado', 'naranja'); \n" +
                            "INSERT INTO FIGURAS VALUES(4, 'cuadrado', 'amarillo');\n" +
                            "INSERT INTO FIGURAS VALUES(5, 'cuadrado', 'violeta');");
                    ResultSet rs=statement.executeQuery("SELECT * FROM FIGURAS \n" +
                            "WHERE color = 'rojo' AND figura = 'circulo' ");
            //rs.next() hace dos cosas 1. mueve el puntero interno del resultset.
            // 2. me indica si tengo un elemento. me arroja un boolean.
            while (rs.next()){
                System.out.println(rs.getString(2) + " " + rs.getString(3));
            }
        } catch(Exception e){
            //aqui podria ir un logger de tipo error.
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase11","sa", "sa");
    }
}