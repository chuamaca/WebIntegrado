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
    </head>
    <body>
    <center>
        <h3>Autenticacion</h3>
    </center>
    <%
        String men = "";
        if (request.getAttribute("mensaje") == null) {
        men=(String)request.getAttribute("mensaje");
        }
    %>
    <form action="tienda" method="post">
        <input type="hidden" name="opc" value="5">
        <table border="1" cellspacing="15" cellspadding="15">
            <tr><td rowspan="3">
                    <image src="imagen2/foto_candado.jpg">
                <td>usuario<td><input name="usr">
            <tr><td>Clave<td><input type="password" name="pas">
            <tr><td><input type="submit" class="btn btn-success">
                <td><%=men%>
        </table>

    </form>
</body>
</html>
