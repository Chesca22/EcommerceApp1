package Controller;

import DAO.AdminDAO;
import DAO.userDAO;
import Models.Users;
import Utility.DBConnection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


    @WebServlet(value = "/admin_login")
    public class AdminLoginServlet extends HttpServlet {


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.sendRedirect("admin.jsp");
        }
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("text/html;charset=UTF-8");

            try  ( PrintWriter out = response.getWriter()) {


                //  collecting the email and password submitted by user
                String username = request.getParameter("login-username");
                String password = request.getParameter("login-password");

                try {
                    AdminDAO udao = new AdminDAO(DBConnection.getConnection());
                    Users users = udao.AdminLogin(username, password);

                    if (users != null){
                        //  that is we have our user object
                        // out.print("user login");
                        request.getSession().setAttribute("auth",users);
                        response.sendRedirect("CRUD.jsp");

                    }
                    else {
                        out.print("user login failed");
                        response.sendRedirect("admin.jsp");
                    }

                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                    //    response.sendRedirect("cart.jsp");
                }
            }
        }


}
