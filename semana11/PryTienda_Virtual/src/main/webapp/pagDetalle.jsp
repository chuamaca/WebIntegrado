
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="beans.*,java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>


        <script src="js/sweetalert2.min.js" type="text/javascript"></script>

        <link href="css/sweetalert.css" rel="stylesheet" type="text/css"/>
   

    </head>
    <body>
    <center>
        <%
            Articulo art = (Articulo) request.getAttribute("dato");
        %>    
        <h1>Venta  de un Articulo</h1>
        <form method="post" name="fr">
            <input type="hidden" name="opc" value="3"/>
            <input name="coda" value="<%=art.getCoda()%>"/>
            <table border="1" cellspacing="15" cellpadding="15">
                <tr><td rowspan="5">
                        <img src="images/<%=art.getImagen()%>" width="200" height="200">         
                    <td>descripcion<td><%=art.getNomart()%>
                <tr><td>Precio  <td><%=art.getPrecio()%>
                <tr><td>Stock   <td><%=art.getStk()%>
                <tr><td> Cantidad <td><input name="cantidad">        
                <tr><td><a href="#" onclick="valida()"> <img src="images/cesta.gif"></a>       
            </table>
        </form>
        <script>
            function valida() {
                st =<%=art.getStk()%>;
                can = Number(fr.cantidad.value)
                if (can > st) {
                    alert('stock no disponible');
                    return;
                }
                fr.action = "tienda";
                fr.submit();
            }

        </script>          
    </center>   
</body>
</html>
