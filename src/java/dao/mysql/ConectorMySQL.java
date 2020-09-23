/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.abstractfactory.ConectorAbstrato;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tiago
 */
public class ConectorMySQL implements ConectorAbstrato{
    private static Connection connection = null;
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/cadastro";
    private static String USER = "root";
    private static String PASS = "root";
    
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
                System.out.println("Exception in getLocalConeection() " + e.getMessage());
            }
            
            return connection;
        }
    }
    
}
