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
                    <h1>Access denied for ${login}!</h1>

                    <c:url value="/logout" var="logoutUrl" />
                    <p><a href="/">Click to back Menu </a></p>
                </div>
    </div>
</div>
</body>
</html>