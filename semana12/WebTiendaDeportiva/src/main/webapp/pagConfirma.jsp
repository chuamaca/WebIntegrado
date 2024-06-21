
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
          <%@include file="menu1.jsp"%>
    <center>
        <%
            HttpSession ses = request.getSession();
            List<FacturaDetalle> lista = (List<FacturaDetalle>) ses.getAttribute("canasta");
        %>    
        <h1>Confirmar Compra</h1>
        <a href="control?opc=6" target="zona" class="btn btn-primary">Aceptar</a>
        <a href="control?opc=7" class="btn btn-danger">Cancelar Compra</a>

        <table border="1" cellpadding="15" cellspacing="15" class="table table-bordered">
            <thead>
                <tr class="text-white bg-dark">
                    <th>codigo<th>Descripcion<th>Precio<th>Cantidad<th>Total
                    <td>Imagen<td>Accion
                </tr>
            </thead>
            <%
                double sm = 0;
                for (FacturaDetalle x : lista) {
                    out.print("<tr><td>" + x.getIdArticulo() + "<td>" + x.getDescripcion() + "<td>" + x.getPrecioUnidad() + "<td>" + x.getCantidad() + "<td>" + x.total());

                    sm += x.total();
                }
                ses.setAttribute("total", sm);
            %>
            <tr><td colspan="4">Total Compra<td><%=sm%>

        </table>

        <iframe name="zona" height="400" width="400">  </iframe>

            <a href="pagCategoria.jsp" class="btn btn-success">Otra Compra</a>
      
    </center>   
</body>
</html>