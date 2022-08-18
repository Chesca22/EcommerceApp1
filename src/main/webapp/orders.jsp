<%@ page import="Models.Users" %>
<%@ page import="Models.Cart" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 09/08/2022
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Users auth = (Users) request.getSession().getAttribute("auth");
    if(auth != null){
        request.setAttribute("auth", auth);
    }

    ArrayList<Cart>cart_list = (ArrayList<Cart>)session.getAttribute("cart-list");
    if(cart_list != null){
        request.setAttribute("cart_list", cart_list);
    }
%>

<html>
<head>
    <%@ include file="includes/header.jsp" %>
     <title>orders</title>
</head>
<body>
<%@include file="includes/navBar.jsp" %>
<%@include file="includes/footer.jsp" %>
</body>
</html>
