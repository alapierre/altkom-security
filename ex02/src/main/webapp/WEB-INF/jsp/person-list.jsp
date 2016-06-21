<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-06-21
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista osób</title>
</head>
<body>

    <table border="1">
        <th>Imię i nazwisko</th>
        <th>Wiek</th>
        <th>Operacje</th>
        <c:forEach items="${persons}" var="person">
            <tr>
                <td>${person.name}</td>
                <td>${person.age}</td>
                <td>
                    <sec:authorize ifAnyGranted="ROLE_MANAGER"><a href="/person/details?id=${person.id}">szczegóły</a></sec:authorize>
                    <sec:authorize ifAnyGranted="ROLE_ADMIN"><a href="/person/delete?id=${person.id}">usuń</a></sec:authorize>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
