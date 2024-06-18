<%-- 
    Document   : categoria
    Created on : 25 may. 2024, 13:27:36
    Author     : Cesar
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.*, dao.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>




    </head>
    <body>
        <%@include file="menu1.jsp"%>

    <center>
        <%
            Articulo objArticulo = (Articulo) request.getAttribute("dato");

        %>
        <h1>Lista de Articulos</h1>
        <a href="articulo.jsp" class="btn btn-success">Articulo Detalle</a>
        <form name="fr" method="post">

            <table border="1" cellspacing="15" cellpadding="15">
                <tr><td rowspan="5">
                        <image src="images/<%=objArticulo.getImagen()%>" width="200" height="200"/>
                    <td>Descripcion<dt><%=objArticulo.getNomart()%>
                <tr><td>Precio<dt><%=objArticulo.getPrecio()%>
                <tr><td>Stock<dt><%=objArticulo.getStk()%>
                <tr><td>Cantidad<dt><input name="cantidad">
                <tr><td><a href="#" onClick="valida()"><img src="images/cesta.gif"></a> 
            </table>
        </form>


        <script>
            function valida() {
                st=<%=objArticulo.getStk()%>
                can=Number(fr.cantidad.value);
                if (can>st) {
                    alert("Stock No Disponible");
                    return;
                }
                fr.action="tienda";
                fr.submit();
            }
        </script>

    </center>


</body>
</html>
