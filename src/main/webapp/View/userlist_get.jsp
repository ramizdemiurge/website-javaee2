<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:set var="users" value="${sessionScope.users}"/>


<html lang="ru">
<head>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/uikit.min.css"/>
    <script src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.servletContext.contextPath}/js/uikit.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Servlet</title>
</head>
<body>
<div  class="uk-background-fixed" style="background-image: url(${pageContext.servletContext.contextPath}/img/background.jpg);">
    <div class="uk-padding uk-panel">


        <div class=" uk-panel" style="background-color: #ffffff" uk-sticky>
            <ul class="uk-subnav uk-subnav-pill" uk-margin>
                <li><a href="${pageContext.request.contextPath}/index.html">Main</a></li>
                <li class="uk-active"><a href="${pageContext.request.contextPath}/users.html">Users</a></li>
                <li><a href="#">About</a></li>
            </ul>
        </div>

        <br>

        <div uk-grid>
            <div class="uk-width-expand">
                <div class="uk-card uk-card-default uk-card-body">
                    <article class="uk-article">
                        <h1 class="uk-article-title">Userlist</h1>
                        <table class="uk-table uk-table-striped">
                            <thead>
                            <tr>
                                <th>Username</th>
                                <th>Name</th>
                                <th>Reg Date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${users}" var="user">
                            <tr>
                                <th><a href="${pageContext.request.contextPath}/users.html?login=${user.username}">${user.username}</a></th>
                                <th>${user.name}</th>
                                <th>${user.regDate}</th>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="uk-grid-small uk-child-width-auto" uk-grid>
                            <div>
                                <a class="uk-button uk-button-text" href="${pageContext.request.contextPath}/index.html">Back
                                    to main</a>
                            </div>
                        </div>
                    </article>
                </div>
            </div>
        </div>
        <c:import url="static/footer.html"/>
    </div>
</div>

</body>
</html>