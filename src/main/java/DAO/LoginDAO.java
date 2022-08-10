package DAO;

import Models.Users;
import lombok.Data;

@Data
public class LoginDAO {

    public boolean Login(String email, String pssdword) {
        return true;
    }

    public String register(Users user){
        //return String;
    }

    public Users getUserbyId(int id){

    }


    public Users getUserbyEmail(String email){

    }


    public Users getUserbyUsername(String email){

    }


    }
