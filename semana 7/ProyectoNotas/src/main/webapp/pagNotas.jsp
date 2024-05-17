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
     List<Notas> lista=(ArrayList<Notas>)request.getAttribute("dato");
  //  String nom=(String)request.getAttribute("nom");
 %>    
 <h2 class="text-blue">notas del Alumno de ${nom}</h2>
 <a href="#" onclick="history.back()" class="btn btn-success">Retroceder</a>
 <table class="table table-hover">
     <thead>
         <tr class="text-white bg-black">
             <th>codc<th>Curso<th>Exp<td>Exf<td>Promedio<td>Observ     
     </thead>  
    <% double sm=0;
       int cuenta=0;
       for(Notas x:lista){
       out.print("<tr><td>"+x.getCodc()+"<td>"+x.getNomc()+"<td>"+x.getExp()+
       "<td>"+x.getExf()+"<td>"+x.prome()+"<td>"+x.obser());
       sm=sm+x.prome(); cuenta++;
        }     
      double pcic=cuenta>0?sm/cuenta:0;
    %>     
    <tr><td colspan="4">Promedio de Ciclo <td><%=pcic%>   
 </table> 
    </body>
</html>
