<%-- 
    Document   : pagEdit
    Created on : 20 abr. 2024, 14:14:44
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Prestamo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Prestamo p = (Prestamo) request.getAttribute("dato");
        %>

        <form action="control" action="post">

            <input type="hidden" name="opc" value="3">
            <table border="1" class="table table-info">
                <tr><td>Nro prestamo<td> <input class="form-control" name="nro" value="<%=p.getNropre()%>">
                <tr><td>Cliente<td> <input class="form-control" name="cliente" value="<%=p.getCliente()%>">
                <tr><td>Monto<td> <input class="form-control" name="monto" value="<%=p.getMonto()%>">
                <tr><td>Meses<td> <input class="form-control" name="mes" value="<%=p.getMeses()%>">
                <tr><td><input class="btn btn-success" type="submit">
            </table>

        </form>






    </body>
</html>
