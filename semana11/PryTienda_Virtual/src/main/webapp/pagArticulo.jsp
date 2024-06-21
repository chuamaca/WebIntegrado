
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
          List<Articulo> lista=(ArrayList<Articulo>)request.getAttribute("dato");
        %>    
        <h1>Lista de Articulos</h1>
        <a href="pagCategoria.jsp" class="btn btn-success">Categorias</a>
        <table border="1" cellpadding="15" cellspacing="15">
            <tr>
            <%
             int cuenta=0;
             for(Articulo x:lista){
             %>
             <td align="center" onmouseover="bgColor='red'" onmouseout="bgColor='white'">
                 <a href="tienda?opc=2&cod=<%=x.getCoda()%>">
                     <img src="images/<%=x.getImagen()%>" width="100" height="100">
                     <br><%=x.getNomart()%>
                 </a>
             <%
                 cuenta++;
                 if(cuenta%3==0)out.print("<tr>");
                }   
            %>    
            
        </table>
    </center> 
    </body>
</html>
