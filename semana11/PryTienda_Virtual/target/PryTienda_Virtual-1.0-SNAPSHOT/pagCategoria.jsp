
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="beans.*,dao.Negocio" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <%
          Negocio obj=new Negocio();
        %>    
        <h1>Lista de Categorias</h1>
        <table border="1" cellpadding="15" cellspacing="15">
            <tr>
            <%
             int cuenta=0;
             for(Categoria x:obj.lisCategoria()){
             %>
             <td align="center" onmouseover="bgColor='red'" onmouseout="bgColor='white'">
                 <a href="tienda?opc=1&cod=<%=x.getCodc()%>">
                     <img src="images/<%=x.getImagen()%>" width="100" height="100">
                     <br><%=x.getNomc()%>
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
