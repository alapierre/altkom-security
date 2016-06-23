<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista osób</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

</head>
<body>

    <div class="container">

        <table class="table table-striped">
            <th>Imię i nazwisko</th>
            <th>Wiek</th>
            <th>Operacje</th>
            <c:forEach items="${persons}" var="person">
                <tr>
                    <td><c:out value="${person.name}"/></td>
                    <td>${person.age}</td>
                    <td>
                        <sec:authorize ifAnyGranted="ROLE_MANAGER"><a href="/person/details?id=${person.id}">szczegóły</a></sec:authorize>
                        <sec:authorize ifAnyGranted="ROLE_MANAGER"><a href="/person/edit?id=${person.id}">edycja</a></sec:authorize>
                        <sec:authorize ifAnyGranted="ROLE_ADMIN">

                            <form method="post" action="/person/delete">
                                <input type="hidden" value="${person.id}" name="id">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button type="submit">Usuń</button>
                            </form>


                        </sec:authorize>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
