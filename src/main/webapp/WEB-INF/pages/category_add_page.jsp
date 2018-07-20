<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Video Content</title>
        <link href="/static/css/style.css" rel="stylesheet"  type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div id="wrapper">

        <div id="header">


            <p >Video Content</p>
        </div>
        <div class="container">

            <form role="form" class="form-horizontal" action="/category/add" method="post">
                        <h3>New category</h3>
                <input class="form-control form-group" type="text" name="name" placeholder="Name">


                    <input type="submit" class="btn btn-primary" value="Add">
                <input type="button"  class="btn btn-default navbar-btn" value="Go to Main Menu" onClick='location.href="/"'>
            </form>
        </div>



    </div>


    </body>
</html>