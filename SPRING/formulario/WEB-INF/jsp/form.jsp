<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario desde Spring WEB MVC</h1>
        
        <form:form>
            
            <p>
                <form:label path="nombre">Nombre</form:label>
                <form:input path="nombre" />
            </p>
            
            <p>
                <form:label path="correo">E-Mail</form:label>
                <form:input path="correo" />
            </p>
            <p>
                <form:label path="edad">Edad</form:label>
                <form:input path="edad" />
            </p>
            <hr>
            <form:button>Enviar</form:button>
        </form:form>
        
    </body>
</html>
