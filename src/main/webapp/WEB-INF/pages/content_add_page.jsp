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

            <form role="form" class="form-horizontal" action="/content/add" method="post">
                        <h3>New content</h3>
                <input class="form-control form-group" type="text" name="title" placeholder="Title">
                <input class="form-control form-group" type="text" name="description"  placeholder="Description">
                <select class="selectpicker form-control form-group" name="language">
                    <option value="-1">Default</option>
                    <c:forEach items="${languages}" var="language">
                        <option value="${language.id}">${language.name}</option>
                    </c:forEach>
                </select>
                <select class="selectpicker form-control form-group" name="category">
                    <option value="-1">Default</option>
                    <c:forEach items="${categorys}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
                        <input class="form-control form-group" type="text" name="url" placeholder="URL">

                    <input type="submit" class="btn btn-primary" value="Add">
                <input type="button"  class="btn btn-default navbar-btn" value="Go to Main Menu" onClick='location.href="/"'>
            </form>
        </div>


    </div>



    </body>
</html>