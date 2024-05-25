<%-- 
    Document   : categoria
    Created on : 25 may. 2024, 13:27:36
    Author     : Cesar
--%>

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


        <%
            Negocio negocio = new Negocio();
        %>
    <center>
        <h1>Lista de Categorias</h1>

        <div class="panel panel-primary">
            <table border="1" cellpading="15" cellspacing="15" class="table table-info align-content-lg-center">
                <tr>
                    <%
                        int cuenta = 0;
                        for (Categoria x : negocio.ListaCategoria()) {
                    %>
                    <td onmouseover="bgColor = 'red'" onmouseout="bgColor = 'white'"><a href="tienda?opc=1&cod=<%=x.getCodc()%>"><img src="images/<%=x.getImagen()%>" width="100" height="100"/><br><%=x.getNomc()%>
                        </a>
                        <%
                                cuenta++;
                                if (cuenta == 3) {
                                    out.print("<tr>");
                                }

                            }

                        %>
            </table>
        </div>
    </center>


</body>
</html>
