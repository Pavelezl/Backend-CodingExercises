package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
    private static final String SQL_DROP_CREATE_PACIENTES="DROP TABLE IF EXISTS " +
            "PACIENTES; CREATE TABLE PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY," +
            "NOMBRE VARCHAR(100)," + "APELLIDO VARCHAR(100)" + "DNI VARCHAR(100)" +
            "FECHA_INGRESO DATE" +
            "DOMICILIO_ID)";

    private static final String SQL_DROP_CREATE_DOMICILIOS="DROP TABLE IF EXISTS " +
            "DOMICILIOS; CREATE TABLE DOMICILIOS (ID INT AUTO_INCREMENT PRIMARY KEY," +
            " CALLE VARCHAR(100)," +
            " NUMERO INT," +
            " LOCALIDAD VARCHAR(100)," +
            " PROVINCIA VARCHAR(100)" +
            ")";

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jbdc:h2:∼/pablovelez","sa","sa");
    }

    public static void crearTablas(){
        Connection connection=null;
        try{
            connection=getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE_DOMICILIOS);
            statement.execute(SQL_DROP_CREATE_PACIENTES);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

}
