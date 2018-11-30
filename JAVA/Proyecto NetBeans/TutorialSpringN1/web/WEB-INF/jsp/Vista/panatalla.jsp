<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>JSP Page</title>     
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

    </head>
    <body>
        <h1>Soy Imagen, soy Boostrapt, soy Llamado a otra pagina!</h1>
        
        <div class="container">
          <div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
               <div class="card-header">Header</div>
                <div class="card-body">
                <h5 class="card-title">Primary card title</h5>
                   <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                 </div>
              </div>
        </div>
        
        <hr>
        
            <a href="<c:url value="principal.htm" />">ir a Otro</a>

        </hr>
        
    </body>
</html>
