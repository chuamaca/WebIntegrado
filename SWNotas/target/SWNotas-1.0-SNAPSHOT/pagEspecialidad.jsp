<%-- 
    Document   : pagExpecial
    Created on : 4 may. 2024, 12:47:07
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Especialidad, dao.Negocio"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%
            Negocio obj = new Negocio();


        %>

        <h2>Lista de especialidades</h2>
        <table border="1" class="table table-hover">
            <tr><th>Codigo<th>nombre<th>Accion

                    <%                for (Especialidad x : obj.listaEspecialidad()) {

                            out.print("<tr><td>" + x.getIdesp() + "<td>" + x.getNomesp());

                    %>


                <td><a href="control?opc=1&id=<%=x.getIdesp()%>" class="btn btn-primary">Ver Alumno</a>




                    <%
                        }

                    %>
        </table>





    </body>
</html>
