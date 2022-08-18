package DAO;

import Models.Users;

import java.sql.*;

import static Constants.QueryClass.AdminLogin_query;
import static Constants.QueryClass.AdminRegister_query;


public class AdminDAO {
    private PreparedStatement preparedStatement;
    private ResultSet rs;
    private Connection connection;

    public  AdminDAO(Connection connection) {
        this.connection = connection;
    }


    public Users AdminLogin(String username, String password){
        Users users = null;
        try{
            //checking to see if user exist in the database
            // preparedStatement = this
            preparedStatement =this.connection.prepareStatement(AdminLogin_query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();

            if(rs.next()){
                users = new Users();
                users.setId(rs.getInt("id"));
                users.setFirstName(rs.getString("firstName"));
                users.setLastName(rs.getString("LastName"));
                users.setEmail(rs.getString("username"));

            }

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return users;
    }




    public Users adminRegistration(String firstName, String lastName, String username, String password1) throws SQLException {
        Users users = new Users();

        preparedStatement = this.connection.prepareStatement(AdminRegister_query);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, username);
        preparedStatement.setString(4, password1);
        rs = preparedStatement.executeQuery();


            return users;


    }
}


