package Controller;

import DAO.userDAO;
import Models.Users;
import Utility.DBConnection;
import com.mysql.cj.Session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value = "/user_login")
public class LoginServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
         response.setContentType("text/html;charset=UTF-8");

        try  ( PrintWriter out = response.getWriter()) {


           //  collecting the email and password submitted by user
            String email = request.getParameter("login-email");
            String password = request.getParameter("login-password");

                        try {
                userDAO udao = new userDAO(DBConnection.getConnection());
                Users users = udao.userLogin(email, password);

                if (users != null){
                      // out.print("user login");
                    request.getSession().setAttribute("auth",users);
                    response.sendRedirect("cart.jsp");

                }
                else {
                    out.print("user login failed");
                    response.sendRedirect("login.jsp");
                }

            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
        //    response.sendRedirect("cart.jsp");
            }
        }
    }
}
