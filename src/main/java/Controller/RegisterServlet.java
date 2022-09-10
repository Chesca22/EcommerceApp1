package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static Constants.QueryClass.RegisterUser_query;


@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

  //  private Connection connection;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        RequestDispatcher dispatcher = null;
        Connection connection = null;
       // PrintWriter out = response.getWriter();
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("user_email");
        String password1 = request.getParameter("user_password");

                try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CommerceDB?useSSL=false", "root",  "francisca");
            PreparedStatement pst = connection.prepareStatement(RegisterUser_query);

            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, email);
            pst.setString(4, password1);

            int rowCount = pst.executeUpdate();
            dispatcher = request.getRequestDispatcher("register.jsp");
            if(rowCount >0 ){
                request.setAttribute("status", "success");

            }

            else{
                request.setAttribute("status", "registration failed!, try again");
            }
            dispatcher.forward(request,response);

        } catch (ClassNotFoundException | SQLException | ServletException e) {
            throw new RuntimeException(e);
                }

                finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }


    }

}
