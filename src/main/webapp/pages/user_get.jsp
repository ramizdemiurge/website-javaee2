<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:set var="user" value="${sessionScope.user}"/>


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
            <div class="uk-child-width-1-2@m" uk-grid>
                <div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-media-top">
                            <img src="${pageContext.servletContext.contextPath}/img/avatars/${user.profile_photo}.jpg" alt="">
                            <div class="uk-card-badge uk-label">${user.username}</div>
                        </div>
                    </div>
                </div>
                <div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <c:choose>
                                <c:when test="${empty user.name}">
                                    <h1 class="uk-article-title">${user.username}</h1>
                                </c:when>
                                <c:otherwise>
                                    <h1 class="uk-article-title">${user.name}</h1>
                                </c:otherwise>
                            </c:choose>
                            <p>Registation date: ${user.regDate}</p>
                            <p>Email: <a href="mailto://${user.email}">${user.email}</a></p>
                        </div>
                    </div>
                </div>
            </div>



        </div>
        <c:import url="static/footer.html"/>
    </div>
</div>

</body>
</html>