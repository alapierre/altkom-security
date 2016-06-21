<%-- 
    Document   : home
    Created on : 2013-03-03, 14:57:19
    Author     : Adrian Lapierre <alapierre@softproject.com.pl>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${name}, hello World!</h1>

        zalogoawny: <sec:authentication property="principal.username"/><br>

        <a href="/spring_security_login?logout">logout</a>

        <br>

        <sec:authorize ifAnyGranted="ROLE_ADMIN">
            <a href="/admin/adminSite">menu administratora</a>
        </sec:authorize>

        <br>

        <sec:authorize url="/admin/adminSite">
            <a href="/admin/adminSite">menu administratora</a>
        </sec:authorize>


    </body>
</html>
