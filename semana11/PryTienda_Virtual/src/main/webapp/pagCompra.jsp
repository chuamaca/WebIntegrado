
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="beans.*,java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <%
            HttpSession ses = request.getSession();
            List<Compra> lista = (List<Compra>) ses.getAttribute("canasta");
        %>    
        <h1>Lista de Compras</h1>
        <a href="pagCategoria.jsp" class="btn btn-success">Categorias</a>
        <a href="pagLogin.jsp" class="btn btn-success">Efectuar Compra</a>

        <table border="1" cellpadding="15" cellspacing="15" class="table table-bordered">
            <thead>
                <tr class="text-white bg-dark">
                    <th>codigo<th>Descripcion<th>Precio<th>Cantidad<th>Total
                    <td>Imagen<td>Accion
                </tr>
            </thead>
            <%
                int cuenta = 0;
                for (Compra x : lista) {
                    out.print("<tr><td>" + x.getCoda() + "<td>" + x.getNomart() + "<td>" + x.getPrecio() + "<td>" + x.getCantidad() + "<td>" + x.total());
                    cuenta++;

            %>
            <td><image src="images/<%=x.getImagen()%>" height="90" width="90">
            <td><a href="tienda?op=4&ind=<%=cuenta%>" class="btn btn-danger">Eliminar</a>
                <%

                    }
                %>
        </table>
    </center>   
</body>
</html>
