<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String[] datas = (String[]) request.getSession().getAttribute("Datas");
%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <link rel="stylesheet" href="css/uikit.min.css"/>
    <script src="js/jquery.js"></script>
    <script src="js/uikit.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feed</title>
</head>
<body>
<div>
    <div class="uk-background-muted uk-padding uk-panel">
        <%
            if (!(Objects.equals(datas[1], null)))
            {
        %>
        Welcome: ${Datas[1]} (${username})
        <%
        } else
        {
        %>
        Welcome: ${username}
        <%
            }
        %>
        <a href=exit.jsp>Exit</a>.<br>Registration date: ${Datas[0]}
    </div>
</div>
<footer>

    <div class="uk-background-muted uk-padding uk-panel">
        <hr class="uk-divider-icon">
        <p class="uk-text-small">Created by <a href="https://ramizdemiurge.github.io/">Ramiz Abdullayev</a>. Licensed
            under <a href="http://www.apache.org/licenses/LICENSE-2.0">Apache License Version 2.0</a></p>
    </div>
</footer>
</body>
</html>
