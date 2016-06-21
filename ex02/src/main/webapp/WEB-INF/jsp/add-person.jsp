<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-06-21
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawnanie osoby</title>
</head>
<body>

    <form:form commandName="person" action="/person/save" method="post">
        Nazwisko i imie: <form:input path="name"/><br>
        Wiek: <form:input path="age"/><br>
        <input type="submit" value="Zapisz">
    </form:form>

</body>
</html>
