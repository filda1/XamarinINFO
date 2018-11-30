<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>JSP Page</title>
        <!--
        <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/estilos.css" />
        -->
        <link rel="stylesheet" href="<c:url value="/public/css/estilos.css" />" />
        <script src="<c:url value="/public/js/funciones.js" />"></script>
    </head>
    <body>
        <h1 class="clase">#manosenelcódigo dddd</h1>
        <hr />
        <a href="javascript:void(0);" onclick="saludo();">haz clic</a>
        <hr/>
        <img src="<c:url value="/public/images/logo.png" />" />
        <hr />
            <a href="<c:url value="/otro.htm" />">ir a Otro</a>
    </body>
</html>
