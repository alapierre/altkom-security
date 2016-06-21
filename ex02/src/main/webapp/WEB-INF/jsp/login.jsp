<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-06-21
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie do aplikacji</title>
</head>
<body>

    <c:if test="${param.error != null}">
        <div id="loginErrorMsg" class="alert alert-danger">
            Błędny login lub hasło
        </div>
    </c:if>

    <form action="/j_spring_security_check" method="post">
        Login: <input type="text" name="user"><br>
        Pass: <input type="password" name="pass"><br>
        <input type="submit" value="Zaloguj">
    </form>

</body>
</html>
