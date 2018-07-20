<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF=8"/>
    <title>Video Content</title>
    <link href="/static/css/style.css" rel="stylesheet"  type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
    <div id="wrapper">

            <div id="header">


                <p >Video Content</p>

            </div>
                <div id="content">


                    <nav class="navbar navbar-default">

                        <div class="container-fluid">
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" align="center">
                                <ul id="groupList" class="nav navbar-nav"  >



                                    <c:url value="/j_spring_security_check" var="loginUrl" />

                                    <li><form action="${loginUrl}" method="POST">
                                            Login:   <input class="btn btn-default navbar-btn" type="text" name="j_login" size="10">
                                         Password: <input class="btn btn-default navbar-btn" type="password" name="j_password" size="10">
                                        <input class="btn btn-default navbar-btn" type="submit" value="Enter" />

                                    </form></li>
                                    <li><input  class="btn btn-default navbar-btn" type="submit"   value="Register" onClick='location.href="/register"'></li>

                                       <%--<button type="button" id="register" class="btn btn-default navbar-btn">Register</button> </li>--%>
                                </ul>




                            </div><!-- /.navbar-collapse -->
                        </div><!-- /.container-fluid -->
                    </nav>
                    <div align="center">
                        <c:url value="/j_spring_security_check" var="loginUrl" />


                        <form action="${loginUrl}" method="POST">


                            <c:if test="${param.error ne null}">
                               <p> Wrong login or password!</p>
                            </c:if>

                            <c:if test="${param.logout ne null}">

                            </c:if>
                        </form>
                    </div>







                </div>
    </div>



<script>


    $('#register').click(function(){
        window.location.href="/register";
    });




</script>
</body>
</html>
