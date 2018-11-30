<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario</h1>
        <form:form >
            <p>
                <form:label path="nombre"></form:label>
                <form:input path=""></form:input>
            </p>
             <p>
                <form:label path="correo"></form:label>
                <form:input path="correo"></form:input>
            </p>
             <p>
                <form:label path="edad"></form:label>
                <form:input path="edad"></form:input>
            </p>
            <hr> <form:button>Button</form:button> </hr>
        </form:form>
    </body>
</html>
