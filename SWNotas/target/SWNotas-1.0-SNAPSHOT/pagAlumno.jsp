<%-- 
    Document   : pagAlumno
    Created on : 4 may. 2024, 13:37:11
    Author     : Cesar
--%>

<%@page import="modelo.*,java.util.*"%>
<%@page import="dao.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            List<Alumno> lista = (ArrayList<Alumno>) request.getAttribute("dato");

        %>

        
        
        <table border="1" class="table table-hover">
            <tr><th>Codigo<th>Nombre Completo<th>Accion

                    <%                for (Alumno x : lista) {

                            out.print("<tr><td>" + x.getIdAlumno() + "<td>" + x.getNomAlumno() + " " + x.getApeAlumno());

                    %>

                <td><img src="fotos/<%=x.getIdAlumno()%>.jpg" height="80" alt="80" class="img img-circle" onerror="src='fotos/sin_foto.jpg'"/>

                <td><a href="control?opc=2&id=<%=x.getIdAlumno()%>" class="btn btn-success">Ver Pagos</a>
                <td><a href="control?opc=3&id=<%=x.getIdAlumno()%>&nombre=<%=x.getNomAlumno()%>" class="btn btn-success">Ver Notas</a>

                    <%
                        }

                    %>
        </table>




    </body>
</html>
