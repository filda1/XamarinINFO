
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"  %>


<html>
    <head>
        <meta charset="UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Recuperacion de datos URL</h1>
        <ul>
            <li> Id :<c:out value="${id}" /></li>
            <li> Id 2 : <c:out value="${id2}" /></li>
        </ul>
    </body>
</html>
