<%-- 
    Document   : pagRegistra
    Created on : 20 abr. 2024, 13:41:31
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>

    <center>
        <h2>Registro</h2>


        <form action="control" action="post">



            <input type="hidden" name="opc" value="1">

            <table border="1" class="table table-info">
                <tr><td>Cliente<td> <input class="form-control" name="cliente" required>
                <tr><td>Monto<td> <input class="form-control" name="monto" required>
                <tr><td>Meses<td> <input class="form-control" name="mes" required>
                <tr><td><input class="btn btn-success" type="submit">
            </table>



        </form>
    </center>
</body>
</html>
