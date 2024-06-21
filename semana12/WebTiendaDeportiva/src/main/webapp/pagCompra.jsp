
<%@page import="modelo.FacturaDetalle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="modelo.*,java.util.*" %>
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
            List<FacturaDetalle> lista = (List<FacturaDetalle>) ses.getAttribute("canasta");
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
                for (FacturaDetalle x : lista) {
                    out.print("<tr><td>" + x.getIdArticulo()+ "<td>" + x.getDescripcion()+ "<td>" + x.getPrecioUnidad()+ "<td>" + x.getCantidad() + "<td>" + x.total());
                    cuenta++;
            %>
            <td><image src="FOTOS/<%=x.getIdArticulo()+".jpg"%>" height="90" width="90">
            <td><a href="control?op=4&ind=<%=cuenta%>" class="btn btn-danger">Eliminar</a>
                <%

                    }
                %>
        </table>
    </center>   
</body>
</html>
