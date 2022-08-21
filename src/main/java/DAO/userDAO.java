package DAO;

<<<<<<< HEAD
import Models.Users;

import java.sql.*;

import static Constants.QueryClass.Login_query;
=======
import Constants.QueryClass;
import Models.Users;
import Utility.DBConnection;

import java.sql.*;

import static Constants.QueryClass.reg1;
>>>>>>> origin/master

public class userDAO {

    private Connection connection;
<<<<<<< HEAD
=======
    private String query;
>>>>>>> origin/master
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
<<<<<<< HEAD
              preparedStatement =this.connection.prepareStatement(Login_query);
=======
              preparedStatement =this.connection.prepareStatement(reg1);
>>>>>>> origin/master
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
