<%@ page import="java.util.ArrayList" %>
<%@ page import="Models.dbclasses.Article" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty username}">
    <c:if test="${not empty passwd}">
        <c:redirect url="/home"/>
    </c:if>
</c:if>

<c:set var="articles" value="${sessionScope.articles}"/>

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

        <c:if test="${not empty messages}">
            <div class="uk-alert-primary" uk-alert>
                <a class="uk-alert-close" uk-close></a>
                <p>${messages}</p>
            </div>
        </c:if>


        <div class=" uk-panel" style="background-color: #ffffff" uk-sticky>
            <ul class="uk-subnav uk-subnav-pill" uk-margin>
                <li class="uk-active"><a href="${pageContext.request.contextPath}/index.html">Main</a></li>
                <li><a href="${pageContext.request.contextPath}/users.html">Users</a></li>
                <li><a href="#">About</a></li>
            </ul>
        </div>

        <br>

        <div uk-grid>
            <div class="uk-width-expand">
                <div class="uk-card uk-card-default uk-card-body">
                    <c:forEach items="${articles}" var="article">
                        <article class="uk-article">
                            <h1 class="uk-heading-line"><a class="uk-link-reset"
                                                           href="${pageContext.request.contextPath}/index.html?article=<c:out value="${article.id}"/>"><span>
                                <c:out value="${article.title}"/></span></a></h1>

                            <p class="uk-article-meta">Written by <a
                                    href="${pageContext.request.contextPath}/index.html?user=<c:out value="${article.author}"/>"><c:out
                                    value="${article.author}"/></a> on <c:out value="${article.date}"/>.</p>

                            <p class="uk-text-lead"></p>

                            <p><c:out value="${article.lead_text}"/></p>

                            <div class="uk-grid-small uk-child-width-auto" uk-grid>
                                <div>
                                    <a class="uk-button uk-button-text"
                                       href="${pageContext.request.contextPath}/index.html?article=<c:out value="${article.id}"/>">Read
                                        more</a>
                                </div>
                                <div>
                                    <a class="uk-button uk-button-text"
                                       href="${pageContext.request.contextPath}/index.html?article=<c:out value="${article.id}"/>">5
                                        Comments</a>
                                </div>
                            </div>
                        </article>
                    </c:forEach>
                    <ul class="uk-pagination">
                        <li><a href="#"><span class="uk-margin-small-right" uk-pagination-previous></span> Previous</a>
                        </li>
                        <li class="uk-margin-auto-left"><a href="#">Next <span class="uk-margin-small-left"
                                                                               uk-pagination-next></span></a></li>
                    </ul>
                </div>
            </div>


            <div class="uk-width-auto">
                <div class="uk-card uk-card-default uk-card-body">
                    <c:import url="static/loginForm.html"/>
                </div>
                <div class="uk-width-auto">
                    <div class="uk-card uk-card-default uk-card-body uk-margin-top">
                        <c:import url="static/regForm.html"/>
                    </div>
                </div>
            </div>

        </div>
        <c:import url="static/footer.html"/>
    </div>
</div>


</body>
</html>