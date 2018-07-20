<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Video Content</title>
    <link href="/static/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div id="wrapper">

    <div id="header">


        <p>Video Content<br>
        <div align="center"><h1>Hello ${login}</h1></div>
        </p>
    </div>
    <div id="content">


        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul id="groupList" class="nav navbar-nav">
                        <li>
                            <button type="button" id="admin" class="btn btn-default navbar-btn">Show all users</button>
                        </li>
                        <li>
                            <button type="button" id="add_content" class="btn btn-default navbar-btn">Add content
                            </button>
                        </li>
                        <li>
                            <button type="button" id="category" class="btn btn-default navbar-btn">Categorys</button>
                        </li>
                        <li>
                            <button type="button" id="language" class="btn btn-default navbar-btn">Languages</button>
                        </li>


                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Category <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/">All</a></li>
                                <c:forEach items="${categorys}" var="category">
                                    <li><a href="/category/${category.id}">${category.name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Language <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/">All</a></li>
                                <c:forEach items="${languages}" var="language">
                                    <li><a href="/language/${language.id}">${language.name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>


                        <li><c:url value="/logout" var="logoutUrl"/>
                            <form action="${logoutUrl}" method="POST">
                                <input class="btn btn-default navbar-btn" type="submit" value="LogOut"/>
                            </form>
                        </li>

                    </ul>


                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <table class="table table-striped">
            <thead>
            <tr>
                <td></td>
                <td><b>Title</b></td>
                <td><b>Description</b></td>
                <td><b>Language</b></td>
                <td><b>Category</b></td>
                <td><b>Url</b></td>
                <td></td>
            </tr>
            </thead>
            <c:forEach items="${contents}" var="contents">
                <tr>
                    <td>

                    </td>
                    <td>${contents.title}</td>
                    <td>${contents.description}</td>
                    <c:choose>
                        <c:when test="${contents.language ne null}">
                            <td>${contents.language.name}</td>
                        </c:when>
                        <c:otherwise>
                            <td>Default</td>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${contents.category ne null}">
                            <td>${contents.category.name}</td>
                        </c:when>
                        <c:otherwise>
                            <td>Default</td>
                        </c:otherwise>
                    </c:choose>


                    <td><a href="${contents.url}">${contents.url}</a></td>
                    <td>

                        <c:url value="/delete" var="deleteContent"/>
                        <form action="${deleteContent}" method="POST">
                            <button type="submit" id="delete" value="${contents.id}" name="contents"
                                    class="btn btn-default navbar-btn">Delete
                            </button>
                        </form>
                    </td>
                    <td>


                        <button type="submit" id="update_content" value="${contents.id}" name="contents"
                                class="btn btn-default navbar-btn">Update
                        </button>


                    </td>

                </tr>
            </c:forEach>
        </table>

        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${allPages ne null}">
                    <c:forEach var="i" begin="1" end="${allPages}">
                        <li><a href="/?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                    </c:forEach>
                </c:if>
                <c:if test="${byCategoryPages ne null}">
                    <c:forEach var="i" begin="1" end="${byCategoryPages}">
                        <li><a href="/category/${categoryId}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a>
                        </li>
                    </c:forEach>
                </c:if>


                <c:if test="${byLanguagePages ne null}">
                    <c:forEach var="i" begin="1" end="${byLanguagePages}">
                        <li><a href="/language/${languageId}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a>
                        </li>
                    </c:forEach>
                </c:if>


            </ul>
        </nav>
    </div>

</div>


<script>


    $('#add_content').click(function () {
        window.location.href = '/content_add_page';
    });
    $('#add_category').click(function () {
        window.location.href = '/category_add_page';
    });
    $('#add_language').click(function () {
        window.location.href = '/language_add_page';
    });
    $('#update_content').click(function () {
        window.location.href = '/update_page';
    });

    $('#admin').click(function () {
        window.location.href = '/admin';
    });
    $('#category').click(function () {
        window.location.href = '/categorys';
    });
    $('#language').click(function () {
        window.location.href = '/languages';
    });


</script>


</body>
</html>