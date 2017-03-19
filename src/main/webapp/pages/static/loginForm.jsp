<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url value="/j_spring_security_check" var="loginUrl" />
<form action="${loginUrl}" method="post">
    <fieldset class="uk-fieldset">
        <legend class="uk-legend">Enter</legend>
        <div class="uk-margin">
            <div class="uk-inline"><span class="uk-form-icon" uk-icon="icon: user"></span> <input
                    class="uk-input" type="text" placeholder="Login" name="j_username">
            </div>
        </div>
        <div class="uk-margin">
            <div class="uk-inline">
                <span class="uk-form-icon uk-form-icon-flip" uk-icon="icon: lock"></span> <input
                    class="uk-input" type="password" placeholder="Password" name="j_password">
            </div>
        </div>
        <p uk-margin>
            <button class="uk-button uk-button-primary" type="submit" value="SignIn">Sign In</button>
        </p>
    </fieldset>
</form>