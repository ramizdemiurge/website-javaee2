<%@ page import="java.util.ArrayList" %>
<%@ page import="Models.dbclasses.Article" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty username}">
    <c:if test="${not empty passwd}">
        <c:redirect url="/home"/>
    </c:if>
</c:if>

<%
    ArrayList<Article> articleList;
    articleList = Article.InitArticles();
%>

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
                <%
                    for (Article article: articleList)
                    {
                %>
                <article class="uk-article">

                    <h1 class="uk-article-title"><a class="uk-link-reset" href="${pageContext.request.contextPath}/view.html?id=<%=article.getId()%>"><%=article.getTitle()%></a></h1>

                    <p class="uk-article-meta">Written by <a href="#"><%=article.getAuthor()%></a> on <%=article.getDate()%>.</p>

                    <p class="uk-text-lead"><%=article.getLead_text()%></p>

                    <p><%=article.getText()%></p>

                    <div class="uk-grid-small uk-child-width-auto" uk-grid>
                        <div>
                            <a class="uk-button uk-button-text" href="${pageContext.request.contextPath}/view.html?id=<%=article.getId()%>">Read more</a>
                        </div>
                        <div>
                            <a class="uk-button uk-button-text" href="#">5 Comments</a>
                        </div>
                    </div>
                </article>
                <hr class="uk-divider-icon">
                <%
                    }
                %>
            </div>
        </div>


        <div class="uk-width-auto">
            <div class="uk-card uk-card-default uk-card-body">
                <c:import url="static/loginForm.html" />
            </div>
            <div class="uk-width-auto">
                <div class="uk-card uk-card-default uk-card-body uk-margin-top">
                    <c:import url="static/regForm.html" />
                </div>
            </div>
        </div>
    </div>


</div>


</body>
<c:import url="static/footer.html" />
</html>