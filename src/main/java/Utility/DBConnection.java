package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private static Connection connection;

    public static Connection getConnection () throws ClassNotFoundException, SQLException {



            Class.forName("com.mysql.cj.jdbc.Driver");
          connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/CommerceDB", "root", "francisca");

          //  System.out.println("connected");


        return connection;
    }






}
