
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
            List<Articulo> lista = (ArrayList<Articulo>) request.getAttribute("dato");
        %>    
        <h1>Lista de Articulos</h1>

<!--        <table border="1" cellpadding="15" cellspacing="15">
            <tr>
                <%
                    int cuenta = 0;
                    for (Articulo x : lista) {
                %>
                <td align="center">
                    <a href="control?opc=2&cod=<%=x.getIdArticulo()%>">
                        <img src="FOTOS/<%=x.getIdArticulo()%>.jpg" width="100" height="100">
                        <br><p class="text-body-secondary"><%=x.getDescripcion()%></p>
                    </a>
                    <%
                            cuenta++;
                            if (cuenta % 3 == 0) {
                                out.print("<tr>");
                            }
                        }
                    %>    

        </table>-->


        <table border="1" cellpadding="15" cellspacing="15">
            <tr>
                <%
                    int cuenta2 = 0;
                    for (Articulo x : lista) {
                %>
                <td align="center">
                    <a href="control?opc=2&cod=<%=x.getIdArticulo()%>">
                        <div class="card border-primary mb-3" style="max-width: 20rem;">
                            <div class="card-header"></div>
                            <div class="card-body">
                                <h4 class="card-title"><%=x.getDescripcion()%></h4>
                                <img src="FOTOS/<%=x.getIdArticulo()%>.jpg" width="100" height="100">
                            </div>
                        </div>


                    </a>
                    <%
                            cuenta++;
                            if (cuenta % 3 == 0) {
                                out.print("<tr>");
                            }
                        }
                    %>    

        </table>






    </center>  

</body>
</html>
