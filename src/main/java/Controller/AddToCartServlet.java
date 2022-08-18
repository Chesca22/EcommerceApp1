package Controller;

import Models.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet (value ="/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");


        try {
            PrintWriter out = response.getWriter();
            ArrayList<Cart> cartList = new ArrayList<>();

            int id = Integer.parseInt(request.getParameter("id"));
            Cart crt = new Cart();
            crt.setId(id);
            crt.setQuantity(1);


            HttpSession session = request.getSession();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

            if (cart_list == null) {
                cartList.add(crt);
                session.setAttribute("cart-list", cartList);
                response.sendRedirect("index.jsp");
            } else {
                cartList = cart_list;
                boolean exist = false;

                for (Cart c : cartList) {
                    if (c.getId() == id) {
                        exist = true;
                        out.println("<h3 style='color:crimsom; text-align:center'> Item already exists in cart.<a href='cart.jsp'>Go to cart page</a></h3>");
                    }
                }
                    if(!exist){
                        cartList.add(crt);
                        response.sendRedirect("index.jsp");

                }
            }

        } catch (IOException |NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

}
