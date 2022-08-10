package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;

    private DBConnection() {
        try {
            class.forName("com.mysql.cj.jdbc.Diver");

            String url = "jdbc:mysql://localhost:3306/CompanyDB";
            String username = "root";
            String password = "francisca";

            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);

        }
    }
}
