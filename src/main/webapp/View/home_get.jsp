<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/uikit.min.css"/>
    <script src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.servletContext.contextPath}/js/uikit.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feed</title>
</head>
<body>
<div>
    <div class="uk-background-muted uk-padding uk-panel">
        <c:choose>
            <c:when test="${empty Datas[1]}">
                Welcome: ${username}
            </c:when>
            <c:otherwise>
                Welcome: ${Datas[1]} (${username})
            </c:otherwise>
        </c:choose>
        <a href=exit>Exit</a>.<br>Registration date: ${Datas[0]}
    </div>
</div>
</body>
<c:import url="static/footer.html" />
</html>
