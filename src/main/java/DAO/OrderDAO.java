package DAO;

import Models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< HEAD
import static Constants.QueryClass.Order_query;

public class OrderDAO {
    private Connection connection;
=======
public class OrderDAO {
    private Connection connection;
    private String query;
>>>>>>> origin/master
    private PreparedStatement preparedStatement;
    private ResultSet rs;
    public OrderDAO(Connection connection){
        this.connection = connection;

    }

    public boolean insertOrder(Order model) throws SQLException {
        boolean result = false;

<<<<<<< HEAD
        preparedStatement = this.connection.prepareStatement(Order_query);
=======
        query = "insert into Orders (p_id, u_id, o_quantity, o_date) values(?,?,?,?)";
        preparedStatement = this.connection.prepareStatement(query);
>>>>>>> origin/master
        preparedStatement.setInt(1, model.getId());
        preparedStatement.setInt(2, model.getUid());
        preparedStatement.setInt( 3, model.getQuantity());
        preparedStatement.setString(4, model.getDate());
        preparedStatement.executeUpdate();
        result = true;

        return result;
    }

}
