<%-- 
    Document   : login
    Created on : 8 jun. 2024, 13:22:11
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <style>
            .center-content {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .card {
                width: 100%;
                max-width: 500px;
            }
            .form-group {
                margin-bottom: 1rem;
            }
        </style>
    </head>
    <body>
        <%@include file="menu1.jsp"%>
        <%
            String men = "";
            if (request.getAttribute("mensaje") != null) {
                men = (String) request.getAttribute("mensaje");
            }
        %>
        <div class="center-content">
            <div class="card border-primary">
                <div class="card-header text-center">Iniciar Sesión</div>
                <div class="card-body">
                    <form action="control" method="post">
                        <input type="hidden" name="opc" value="5">
                        <div class="form-group">
                            <img src="imagen2/foto_candado.jpg" class="img-fluid mx-auto d-block mb-2" alt="Candado">
                        </div>
                        <div class="form-group">
                            <label for="usr">Usuario</label>
                            <input type="text" class="form-control" id="usr" name="usr" required>
                        </div>
                        <div class="form-group">
                            <label for="pas">Clave</label>
                            <input type="password" class="form-control" id="pas" name="pas" required>
                        </div>
                        <div class="form-group text-center">
                            <input type="submit" class="btn btn-success" value="Iniciar Sesión">
                        </div>
                        <div class="form-group text-center text-danger">
                            <%= men %>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
