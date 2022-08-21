package DAO;

import Models.Cart;
import Models.Product;
import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import static Constants.QueryClass.*;

@Data
public class ProductDAO {
    private Connection connection;
=======
@Data
public class ProductDAO {
    private Connection connection;
    private String query;
>>>>>>> origin/master
    private PreparedStatement preparedStatement;
    private ResultSet rs;

      public ProductDAO(Connection connection){
        this.connection = connection;

    }

    public List<Product> getAllProducts(){
       List<Product> products = new ArrayList<Product>();
       try{
<<<<<<< HEAD
           preparedStatement = this.connection.prepareStatement(AllProduct_query);
=======
           query = "select * from Product";
           preparedStatement = this.connection.prepareStatement(query);
>>>>>>> origin/master
           rs= preparedStatement.executeQuery();
           while (rs.next()){
               Product row = new Product();
               row.setId(rs.getInt("id"));
               row.setName(rs.getString("name"));
               row.setCategory(rs.getString("category"));
               row.setPrice(rs.getDouble("price"));
               row.setImage(rs.getString("image"));

               products.add(row);
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return products;
    }

    public List<Cart> getCartProducts(ArrayList<Cart> cartList){
          List<Cart> products = new ArrayList<Cart>();

          try{
              if(cartList.size() >0){
                  for(Cart item:cartList){
<<<<<<< HEAD
                  preparedStatement = this.connection.prepareStatement(Product_query);
=======
                  query = "select * from Product where id=?";
                  preparedStatement = this.connection.prepareStatement(query);
>>>>>>> origin/master
                  preparedStatement.setInt(1,item.getId());
                  rs = preparedStatement.executeQuery();
                  while(rs.next()){
                      Cart row = new Cart();
                      row.setId(rs.getInt("id"));
                      row.setName(rs.getString("name"));
                      row.setCategory(rs.getString("category"));
                      row.setPrice(rs.getDouble("price") * item.getQuantity());
                      row.setQuantity(item.getQuantity());
                      products.add(row);
;                  }
              }
              }
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }

          return products;
    }

    public double getTotalCartPrice(ArrayList<Cart> cartList) throws SQLException {
          double sum=0;
          if(cartList.size()>0){
              for(Cart item:cartList){
<<<<<<< HEAD
                  preparedStatement = this.connection.prepareStatement(Price_query);
=======
                  query = "select price from Product where id=?";
                  preparedStatement = this.connection.prepareStatement(query);
>>>>>>> origin/master
                  preparedStatement.setInt(1, item.getId());
                  rs = preparedStatement.executeQuery();

                  while(rs.next()){
                      sum+=rs.getDouble("price")*item.getQuantity();
                  }
              }
          }

          return sum;
    }
    }
