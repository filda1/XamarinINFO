<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
    </head>
    <body>
        <h1>Resultado de los datos</h1>
        <ul>
            <li>Nombre : <c:out value="${nombre}" /></li>
            <li>E-Mail : <c:out value="${correo}" /></li>
            <li>País : <c:out value="${pais}" /></li>
        </ul>
    </body>
</html>
