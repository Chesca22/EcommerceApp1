package DAO;

import Models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.QueryClass.Order_query;

public class OrderDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet rs;
    public OrderDAO(Connection connection){
        this.connection = connection;

    }

    public boolean insertOrder(Order model) throws SQLException {
        boolean result = false;

        preparedStatement = this.connection.prepareStatement(Order_query);
        preparedStatement.setInt(1, model.getId());
        preparedStatement.setInt(2, model.getUid());
        preparedStatement.setInt( 3, model.getQuantity());
        preparedStatement.setString(4, model.getDate());
        preparedStatement.executeUpdate();
        result = true;

        return result;
    }

}
