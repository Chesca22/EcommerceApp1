package DAO;

import Models.Users;

import java.sql.*;

import static Constants.QueryClass.Login_query;

public class userDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet rs;
    public userDAO(Connection connection){
        this.connection = connection;

    }

    public Users userLogin(String email, String password){
        Users users = null;
        try{
            //checking to see if user exist in the database
             // preparedStatement = this
              preparedStatement =this.connection.prepareStatement(Login_query);
              preparedStatement.setString(1, email);
              preparedStatement.setString(2, password);
              rs = preparedStatement.executeQuery();

            if(rs.next()){
                users = new Users();
                users.setId(rs.getInt("id"));
                users.setFirstName(rs.getString("firstName"));
                users.setLastName(rs.getString("LastName"));
                users.setEmail(rs.getString("email"));

            }

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return users;
    }



}
