<%@ page import="Models.Users" %>
<%@ page import="Models.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page import="Utility.DBConnection" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 09/08/2022
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);


    Users auth = (Users) request.getSession().getAttribute("auth");
    if(auth != null){
        request.setAttribute("auth", auth);
    }

    ArrayList<Cart>cart_list = (ArrayList<Cart>)session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if(cart_list != null){
        ProductDAO pDAO = new ProductDAO(DBConnection.getConnection());
        cartProduct = pDAO.getCartProducts(cart_list);
        double total = pDAO.getTotalCartPrice(cart_list);
        request.setAttribute("cart_list", cart_list);
        request.setAttribute("total", total);

    }
%>

<html>
<head>
    <%@include file="includes/header.jsp" %>
    <title>cart</title>
    <style type="text/css">
        .table tbody td {
            vertical-align: middle;
        }
        .btn-decre, .btn-incre{
            box-shadow: none;
            font-size: 25px;
            color: darkblue;

        }
    </style>
</head>
<body>
<%@include file="includes/navBar.jsp" %>
 <div class="container" style="margin-top:70px;">
         <table class="table table-length">
         <thead>
         <tr>
             <th scope="col">Name</th>
             <th scope="col">Category</th>
             <th scope="col">Price</th>
             <th scope="col">Buy Now</th>
             <th scope="col">Cancel</th>
         </tr>
         </thead>
         <tbody>

         <% if(cart_list != null) {
          for(Cart c : cartProduct){
         %>

         <tr>
             <td><%= c.getName() %></td>
             <td><%= c.getCategory()%></td>
             <td>$ <%=dcf.format(c.getPrice()) %>  </td>

             <td>
                 <form action="orderNow" method="post" class="form-inline">
                     <input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
                     <div class="form-group d-flex justify-content-between w-50">
                         <a class="btn btn-sm btn-decre" href="quantity_dec_inc?action=dec&id=<%= c.getId() %>"><i class="fas fa-minus-square"></i></a>
                         <input type="text" name="quantity" class="form-control w-50" value="<%= c.getQuantity() %>" readonly>
                         <a class="btn btn-sm btn-incre" href="quantity_dec_inc?action=inc&id=<%= c.getId() %>"><i class="fas fa-plus-square"></i></a>

                     </div>
                     <button type="submit" class="btn btn-primary btn-sm">Buy</button>
                 </form>
             </td>
             <td><a class="btn btn-sm btn-danger" href="remove_from_cart?id=<%= c.getId()%>"> Remove </a></td>
         </tr>
         <% }
    } %>

         </tbody>
     </table>
     <div class="d-flex py-3"><h3>Total Price: $ ${ (total >0)?dcf.format(total):0 } </h3>  <a class="mx btn btn-primary" href="#">  Check out</a> </div>

 </div>

</body>
</html>
