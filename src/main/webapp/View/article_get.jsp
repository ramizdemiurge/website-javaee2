<%@ page import="java.util.ArrayList" %>
<%@ page import="Models.dbclasses.Article" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty username}">
    <c:if test="${not empty passwd}">
        <c:redirect url="/home"/>
    </c:if>
</c:if>

<c:set var="article" value="${sessionScope.article}"/>

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

<div class="uk-background-muted uk-padding uk-panel">
    <nav class="uk-navbar uk-navbar-container uk-margin">
        <div class="uk-navbar-left">
            <a class="uk-navbar-toggle" href="#">
                <span uk-navbar-toggle-icon></span> <span class="uk-margin-small-left">Menu</span>
            </a>
        </div>
    </nav>
    <c:if test="${not empty messages}">
        <div class="uk-grid">
            <div class="uk-width-1-1 ">

                <div class="uk-card uk-card-primary uk-card-small uk-card-body uk-light ">
                    <p>${messages}</p>
                </div>

            </div>
        </div>
    </c:if>
    <div uk-grid>
        <div class="uk-width-expand">
            <div class="uk-card uk-card-default uk-card-body">
                <article class="uk-article">

                    <h1 class="uk-article-title">${article.title}</h1>

                    <p class="uk-article-meta">Written by <a
                            href="${pageContext.request.contextPath}/users.html?login=${article.author}">${article.author}</a>
                        on ${article.date}.</p>

                    <p class="uk-text-lead">${article.lead_text}</p>

                    <p>${article.text}</p>

                    <div class="uk-grid-small uk-child-width-auto" uk-grid>
                        <div>
                            <a class="uk-button uk-button-text" href="${pageContext.request.contextPath}/index.html">Back
                                to main</a>
                        </div>
                    </div>
                </article>

            </div>
        </div>
        <div class="uk-width-auto">
            <div class="uk-card uk-card-default uk-card-body">
                <article class="uk-comment">
                    <header class="uk-comment-header uk-grid-medium uk-flex-middle" uk-grid>
                        <div class="uk-width-auto">
                            <img class="uk-comment-avatar" src="${pageContext.request.contextPath}/img/avatars/avatar.jpg" width="80" height="80"
                                 alt="">
                        </div>
                        <div class="uk-width-expand">
                            <h4 class="uk-comment-title uk-margin-remove"><a class="uk-link-reset" href="#">Author</a>
                            </h4>
                            <ul class="uk-comment-meta uk-subnav uk-subnav-divider uk-margin-remove-top">
                                <li><a href="#">12 days ago</a></li>
                                <li><a href="#">Reply</a></li>
                            </ul>
                        </div>
                    </header>
                    <div class="uk-comment-body">
                        <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor
                            invidunt
                            ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo
                            duo
                            dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum
                            dolor
                            sit amet.</p>
                    </div>
                </article>
            </div>
        </div>
    </div>
</div>


</div>


</body>
<c:import url="static/footer.html"/>
</html>