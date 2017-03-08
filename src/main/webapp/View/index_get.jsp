<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty username}">
    <c:if test="${not empty passwd}">
        <c:redirect url="/home"/>
    </c:if>
</c:if>

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

                    <h1 class="uk-article-title"><a class="uk-link-reset" href="">Heading</a></h1>

                    <p class="uk-article-meta">Written by <a href="#">Ramiz</a> on 9 Marth 2017. Posted in <a href="#">Blog</a></p>

                    <p class="uk-text-lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip.</p>

                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

                    <div class="uk-grid-small uk-child-width-auto" uk-grid>
                        <div>
                            <a class="uk-button uk-button-text" href="#">Read more</a>
                        </div>
                        <div>
                            <a class="uk-button uk-button-text" href="#">5 Comments</a>
                        </div>
                    </div>

                </article>
            </div>
        </div>

        <div class="uk-width-auto">
            <div class="uk-card uk-card-default uk-card-body">
                <form action="index.html" method="post">
                    <fieldset class="uk-fieldset">
                        <legend class="uk-legend">Enter</legend>
                        <div class="uk-margin">
                            <div class="uk-inline"><span class="uk-form-icon" uk-icon="icon: user"></span> <input
                                    class="uk-input" type="text" placeholder="Login" name="login">
                            </div>
                        </div>
                        <div class="uk-margin">
                            <div class="uk-inline">
                                <span class="uk-form-icon uk-form-icon-flip" uk-icon="icon: lock"></span> <input
                                    class="uk-input" type="password" placeholder="Password" name="passwd">
                            </div>
                        </div>
                        <p uk-margin>
                            <button class="uk-button uk-button-primary" type="submit" value="SignIn">Sign In</button>
                        </p>
                    </fieldset>
                </form>
            </div>
            <div class="uk-width-auto">
                <div class="uk-card uk-card-default uk-card-body uk-margin-top">
                    <form action="reg" method="post">
                        <fieldset class="uk-fieldset">
                            <legend class="uk-legend">Register</legend>
                            <div class="uk-margin">
                                <div class="uk-inline"><span class="uk-form-icon" uk-icon="icon: user"></span> <input
                                        class="uk-input" type="text" placeholder="Login" name="login">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <div class="uk-inline"><span class="uk-form-icon" uk-icon="icon: mail"></span> <input
                                        class="uk-input" type="text" placeholder="E-mail" name="email">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <div class="uk-inline"><span class="uk-form-icon" uk-icon="icon: lock"></span> <input
                                        class="uk-input" type="password" placeholder="Password" name="passwd">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <div class="uk-inline"><span class="uk-form-icon" uk-icon="icon: lock"></span> <input
                                        class="uk-input" type="password" placeholder="Confirmation" name="passwd2">
                                </div>
                            </div>
                            <p uk-margin>
                                <button class="uk-button uk-button-primary" type="submit" value="SignUp">Sign Up
                                </button>
                            </p>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>


</div>

<div class="uk-background-muted uk-padding uk-panel">
</div>

<footer>

    <div class="uk-background-muted uk-padding uk-panel">
        <hr class="uk-divider-icon">
        <p class="uk-text-small">Created by <a href="https://ramizdemiurge.github.io/">Ramiz Abdullayev</a>. Licensed
            under <a href="http://www.apache.org/licenses/LICENSE-2.0">Apache License Version 2.0</a></p></div>
</footer>
</body>
</html>