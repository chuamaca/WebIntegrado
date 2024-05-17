<%-- 
    Document   : pagListado
    Created on : 20 abr. 2024, 13:27:41
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Prestamo, dao.PrestamoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>

        <%
            PrestamoDAO obj = new PrestamoDAO();
        %>
    <center>
        <h2>Listado de Prestamo</h2>
        <a href="pagRegistra.jsp" class="btn-btn-success">Registrar Prestamo</a>
        <table border="1" class="table table-hover">

            <thead>
                <tr class="text-white bg-dark">
                    <th>Nro<th>Cliente<th>Monto<th>Mes<th>Interes<th>acciones

            </thead>

            <%
                for (Prestamo x : obj.listado()) {
                    out.print("<tr><td>" + x.getNropre() + "<td>" + x.getCliente() + "<td>" + x.getMonto() + "<td>" + x.getMeses() + "<td>" + x.intereses());
            %>

            <td> <a href="control?opc=2&nro=<%=x.getNropre()%>" class="btn btn-success">Editar </a>
                <a href="control?opc=4&nro=<%=x.getNropre()%>" class="btn btn-danger">Anular </a>
                <%

                    }
                %>

        </table>

    </center>

</body>
</html>
