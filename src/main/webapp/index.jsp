<%@ page import="Utility.DBConnection" %>
<%@ page import="Models.Users" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page import="Models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="Models.Cart" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 08/08/2022
  Time: 03:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
Users auth = (Users)request.getSession().getAttribute("auth");
if(auth != null){
request.setAttribute("auth", auth);
}

    ProductDAO prodDAO = new ProductDAO(DBConnection.getConnection());
    List<Product> products = prodDAO.getAllProducts();

    ArrayList<Cart>cart_list = (ArrayList<Cart>)session.getAttribute("cart-list");
    if(cart_list != null){
        request.setAttribute("cart_list", cart_list);
    }


%>

<html>
<head>
    <title>welcome page </title>
    <%@include file="includes/header.jsp" %>
</head>

<body>
<%@include file="includes/navBar.jsp" %>

<<<<<<< HEAD

<div class="container-fluid mt-3 px-5">
    <div class="card-header my-3" style="background-color: gray; padding:13px"> All Products</div>
    <div class="row justify-content-start">
=======
<div class="container" >
    <div class="card-header my-3" style="background-color: gray; padding:13px"> All Products</div>

    <div class="row mt-3 d-flex justify-content-between">
>>>>>>> origin/master
        <%
            if(!products.isEmpty()){
                for(Product p:products){ %>

<<<<<<< HEAD
                    <div class="col-md-3 mb-2">
                        <div class="card">
                           <img style="width: auto; height: 200px;" class="card-img-top" src="product-images/<%= p.getImage()%>" alt="card image">
                            <div class="card-body">
                                <h2 class="card-title"><%= p.getName()%></h2>
                                <h4 class="card-subtitle">Price: <%= p.getPrice()%> </h4>
                                <h6 class="category">Category: <%= p.getCategory()%></h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a href="add-to-cart?id=<%= p.getId()%>" class="btn btn-dark">Add to cart</a>
                                    <a href="orderNow?quantity=1&id=<%= p.getId()%>" class="btn btn-primary">Buy Now</a>
                   </div>
                            </div>
                        </div>
                    </div>

        <%  }
        } %>
    </div>
</div>

=======
        <div class="col-md-3 my-3">
            <div class="card w-100">
                <img class="card-img-top" src="product-images/<%= p.getImage()%>" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title"><%= p.getName() %></h5>
                    <h6 class="price">Price: $<%= p.getPrice()%></h6>
                    <h6 class="category">Category: <%= p.getCategory()%></h6>
                    <div class="mt-3 d-flex justify-content-between">
                        <a href="add-to-cart?id=<%= p.getId()%>" class="btn btn-dark">Add to cart</a>
                        <a href="orderNow?quantity=1&id=<%= p.getId()%>" class="btn btn-primary">Buy Now</a>
                    </div>

                </div>
            </div>
        </div>
    </div>
              <%  }
            } %>



</div>
</div>


>>>>>>> origin/master
</body>
</html>
