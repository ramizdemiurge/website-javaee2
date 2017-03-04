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
<div>
    <div class="uk-background-muted uk-padding uk-panel">
        <c:if test="${not empty messages}">
            <div uk-alert>${messages}</div>
        </c:if>
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
</div>
<div>
    <div class="uk-background-muted uk-padding uk-panel">
        <form action="reg.jsp" method="post">
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
                    <button class="uk-button uk-button-primary" type="submit" value="SignUp">Sign Up</button>
                </p>
            </fieldset>
        </form>
    </div>
</div>
<footer>

    <div class="uk-background-muted uk-padding uk-panel">
        <hr class="uk-divider-icon">
        <p class="uk-text-small">Created by <a href="https://ramizdemiurge.github.io/">Ramiz Abdullayev</a>. Licensed
            under <a href="http://www.apache.org/licenses/LICENSE-2.0">Apache License Version 2.0</a></p></div>
</footer>
</body>
</html>