<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
   
 <%
     List<Alumno> lista=(ArrayList<Alumno>)request.getAttribute("dato");
     String nome=(String)request.getAttribute("nome");
 %>    
 <h2 class="text-blue">Lista de Alumno de <%=nome%></h2>
 <a href="#" onclick="history.back()" class="btn btn-success">Retroceder</a>
 <table class="table table-hover">
     <thead>
         <tr class="text-white bg-black">
             <th>Codigo<th>Nombre<th>foto<td>accion     
     </thead>  
    <%
       for(Alumno x:lista){
       out.print("<tr><td>"+x.getCoda()+"<td>"+x.apeNom());
     %>
     <td><img src="fotos/<%=x.getCoda()%>.jpg" width="90" height="90"
              class="img-circle" onerror="src='fotos/sin_foto.jpg' ">
     <td><a href="control?opc=2&cod=<%=x.getCoda()%>&nom=<%=x.apeNom()%>" class="btn btn-success">Pagos</a>
         <a href="control?opc=3&cod=<%=x.getCoda()%>&nom=<%=x.apeNom()%>" class="btn btn-success">Notas</a>
         
     <%
        }     
    %>     
     
 </table> 
    </body>
</html>
