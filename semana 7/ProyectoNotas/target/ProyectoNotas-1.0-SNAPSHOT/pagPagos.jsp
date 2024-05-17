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
     List<Pagos> lista=(ArrayList<Pagos>)request.getAttribute("dato");
     String nom=(String)request.getAttribute("nom");
 %>    
 <h2 class="text-blue">Lista de Alumno De<%=nom%></h2>
 <a href="#" onclick="history.back()" class="btn btn-success">Retroceder</a>
 <table class="table table-hover">
     <thead>
         <tr class="text-white bg-black">
             <th>Ciclo<th>Ncuota<th>fecha<td>monto     
     </thead>  
    <% double sm=0;
       for(Pagos x:lista){
       out.print("<tr><td>"+x.getCiclo()+"<td>"+x.getNcuota()+"<td>"+x.getFecha()+
       "<td>"+x.getMonto());
       sm=sm+x.getMonto();
        }     
    %>     
    <tr><td colspan="3">Total Monto <td><%=sm%>   
 </table> 
    </body>
</html>
