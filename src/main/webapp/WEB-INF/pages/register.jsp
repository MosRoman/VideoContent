<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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


                            <div align="center">
                                <c:url value="/newuser" var="regUrl" />

                                <form action="${regUrl}" method="POST">
                                    Login:<br/><input class="btn btn-default navbar-btn" type="text" name="login"><br/>
                                    Password:<br/><input class="btn btn-default navbar-btn" type="password" name="password"><br/>

                                    <input class="btn btn-default navbar-btn" type="submit" value="Register" />

                                    <c:if test="${exists ne null}">
                                        <p>User already exists!</p>
                                    </c:if>
                                </form>

                            </div>
                    <input type="button"  class="btn btn-default navbar-btn" value="Go to Main Menu" onClick='location.href="/"'>
                </div>

    </div>
</body>
</html>
