package dao.sqlserver;

import dao.abstractfactory.ConectorAbstrato;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tiago
 */
public class ConectorSQLServer implements ConectorAbstrato
{
    private static Connection connection = null;
    private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String URL = "jdbc:sqlserver://localhost\\TIAGO-S145\\SQLEXPRESS:1433;databaseName=cadastro";
    private static String USER = "sa";
    private static String PASS = "sqldba";

    @Override
    public Connection conectar() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Class.forName(DRIVER);// Register jdbc driver

                System.out.println("****Connect to Database****");

                //4. open a connection
                connection = DriverManager.getConnection(URL, USER, PASS);

                System.out.println("DataBase connect to: " + connection.getMetaData().getDriverName());
                System.out.println("URL: " + connection.getMetaData().getURL());

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Exception in getLocalConeection() " + e.getMessage());
            }
            
            return connection;
        }
    }
    
    public void setConnectionClose() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
}
