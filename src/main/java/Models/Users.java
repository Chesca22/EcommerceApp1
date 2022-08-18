package Models;

import lombok.Data;


@Data
public class Users {
    private int id;
    private String firstName;
    private String LastName;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
