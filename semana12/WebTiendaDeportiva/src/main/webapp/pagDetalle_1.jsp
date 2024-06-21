
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="modelo.*,java.util.*" %>
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
        <%@include file="menu1.jsp"%>
    <center>
        <%
            Articulo art = (Articulo) request.getAttribute("dato");
        %>    


        <div class="card border-primary mb-6" style="max-width: 40rem;">
            <div class="card-header">Venta  de un Articulo</div>
            <div class="card-body">
               
                <form method="post" name="fr">
                    <input type="hidden" name="opc" value="3"/>
                    <input type="hidden" name="coda" value="<%=art.getIdArticulo()%>"/>
                    <table border="0" cellspacing="15" cellpadding="15">
                        <tr><td rowspan="5">
                                  <img src="FOTOS/<%=art.getIdArticulo()%>.jpg" width="100" height="100">
                         <tr><td><h4 class="card-title"><%=art.getDescripcion()%></h4>
                        <tr><td>Precio  <td><%=art.getPrecioUnidad()%>
                        <tr><td>Stock   <td><%=art.getStock()%>
                        <tr><td> Cantidad <td><input name="cantidad">        
                        <tr><td><a href="#" onclick="valida()"> <img src="images/cesta.gif"></a>       
                    </table>
                </form>
            </div>
        </div>

        <script>
            function valida() {
                st =<%=art.getStock()%>;
                can = Number(fr.cantidad.value)
                if (can > st) {
                    alert('stock no disponible');
                    return;
                }
                fr.action = "control";
                fr.submit();
            }

        </script>          
    </center>   
</body>
</html>
