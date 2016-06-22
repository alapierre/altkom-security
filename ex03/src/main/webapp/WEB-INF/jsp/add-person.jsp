<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dodawnanie osoby</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

</head>
<body>



<div class="container">

        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Dodawanie Osoby</h3>
            </div>
            <div class="panel-body">
                <form:form class="form" commandName="person" action="/person/save" method="post">



                    <div class="form-group">
                        <form:errors path="name"></form:errors>
                        <label for="name">Imię i nazwisko</label>
                        <form:input path="name" class="form-control" />
                    </div>

                    <div class="form-group">
                        <form:errors path="age"></form:errors>
                        <label for="age">Wiek</label>
                        <form:input path="age" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="salary">Wynagrodzenie</label>
                        <form:input path="salary" class="form-control"/>
                    </div>

                    <form:hidden path="id"/>

                    <button type="submit" class="btn btn-default">Zapisz</button>

                </form:form>
            </div>
        </div>





    </div>


</body>
</html>
