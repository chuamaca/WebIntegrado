<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href="css/all.css" rel="stylesheet" type="text/css" crossorigin="anonymous"/>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-custom-purple">

               <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="control?opc=1"><i class="fas fa-home"></i>Alumnos<span class="sr-only">(current)</span></a>
                    </li>
                                     
                    <li>
                        <a class="nav-link" href="./control?opc=1">Boleta de Nota</a>
                    </li> 
                    <li>
                        <a class="nav-link" href="./control?opc=5">crud de Alumnos</a>
                    </li> 

                </ul>
               </nav>


</body>
</html>
