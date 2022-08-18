<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 11/08/2022
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="includes/header.jsp" %>
    <title>Register</title>
</head>
<body>
<%--<%@include file="includes/navBar.jsp" %>--%>

<%--hidden input--%>
<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">

<!-- Section: Design Block -->
<section class="text-center">
    <!-- Background image -->
    <div class="p-5 bg-image" style="
        background-image: url('https://mdbootstrap.com/img/new/textures/full/171.jpg');
        height: 300px;
        "></div>
    <!-- Background image -->

    <div class="card mx-4 mx-md-5 shadow-5-strong" style="
        margin-top: -100px;
        background: hsla(0, 0%, 100%, 0.8);
        backdrop-filter: blur(30px);
        ">
        <div class="card-body py-5 px-md-5">

            <div class="row d-flex justify-content-center">
                <div class="col-lg-8">
                    <h2 class="fw-bold mb-5">Sign up now</h2>
                    <form action="register" method="post">
                        <!-- 2 column grid layout with text inputs for the first and last names -->
                        <div class="row">
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" id="form3Example1" class="form-control" name="first_name"/>
                                    <label class="form-label" for="form3Example1">First name</label>
                                </div>
                            </div>
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" id="form3Example2" class="form-control" name="last_name"/>
                                    <label class="form-label" for="form3Example2">Last name</label>
                                </div>
                            </div>
                        </div>

                        <!-- Email input -->
                        <div class="form-outline mb-4">
                            <input type="email" id="form3Example3" class="form-control" name="user_email" required/>
                            <label class="form-label" for="form3Example3">Email address</label>
                        </div>

                        <!-- Password input -->
                        <div class="form-outline mb-4">
                            <input type="password" id="form3Example4" class="form-control" name="user_password" required />
                            <label class="form-label" for="form3Example4">Password</label>
                        </div>

                        <div class="form-outline mb-4">
                            <input type="password" id="form3Example5" class="form-control" name="user_password2" required />
                            <label class="form-label" for="form3Example4">Re-enter Password</label>
                        </div>

                        <!-- Submit button -->
                        <button type="submit" class="btn btn-primary btn-block mb-4" >
                            Sign up
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Section: Design Block -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">
<script type="text/javascript">
    var status = document.getElementById("status").value;
    if(status ==  "success"){
        swal("Congratulation!, Account created successfully");
        //
    }

</script>
</body>
</html>
