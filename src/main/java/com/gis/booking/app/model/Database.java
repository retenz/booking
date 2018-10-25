
package com.gis.booking.app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static String driverClassName ="org.apache.derby.jdbc.ClientDriver";
    private static String URL= "jdbc:derby://localhost:1527/MovieTheaters";
    private static Database instance= new Database();
    
    public static Database getinstance() 
    {
        return instance; 
    }
        
    public Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName(driverClassName); 
        return DriverManager.getConnection(URL);
    }
  
    
    }
