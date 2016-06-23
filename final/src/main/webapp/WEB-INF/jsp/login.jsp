
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl">
<head>
    <title>Logowanie do aplikacji</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="resources/style.css" rel="stylesheet">


</head>
<body>

<div class="container">



    <form class="form-signin" action="/j_spring_security_check" method="post">
        <h2 class="form-signin-heading">Proszę się zalogować</h2>
        <c:if test="${param.error != null}">
            <div id="loginErrorMsg" class="alert alert-danger">
                Błędny login lub hasło
            </div>
        </c:if>

        <label for="user" class="sr-only">Login</label>
        <input id="user" type="text" name="user" class="form-control" placeholder="Login" required autofocus>
        <label for="pass" class="sr-only">Hasło</label>
        <input id="pass" type="password" name="pass" class="form-control" placeholder="Hasło" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </form>

</div> <!-- /container -->






</body>
</html>
