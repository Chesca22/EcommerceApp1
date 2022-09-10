<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 11/08/2022
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>




<nav class="navbar navbar-expand-lg bg-light">

    <div class="container">
        <a class="navbar-brand" href="admin.jsp" style="font-size:xx-small"><i class="fab fa-4x">E-Shopping</i></a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cart.jsp">Cart<span class="badge badge-danger px-1"> ${ cart_list.size()}</span></a>
                </li>

                <%

                if(auth != null) { %>

                    <li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
                    <li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a></li>

              <%  } else { %>
                <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
                <% }
            %>
            </ul>
        </div>
    </div>
</nav>
<!-- Navbar -->

<style>
    /* Color of the links BEFORE scroll */
    .navbar-scroll .nav-link,
    .navbar-scroll .navbar-toggler-icon,
    .navbar-scroll .navbar-brand {
        color: white;
        /*color: #262626;*/
    }

    /* Color of the navbar BEFORE scroll */
    .navbar-scroll {
        background-color:darkblue;


        /*background-color: #FFC017;*/
    }

    /* Color of the links AFTER scroll */
    .navbar-scrolled .nav-link,
    .navbar-scrolled .navbar-toggler-icon,
    .navbar-scroll {
        color: #262626;
    }

 .navbar-brand {
        color: slategray;
        font-family: "Noto Sans Old Italic";
        font-size:unset;
        height: 2rem;
    }
</style>