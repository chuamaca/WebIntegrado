<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*, dao.Negocio" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
   <%@include file="menu1.jsp"%>
   
 <%
     Negocio  obj=new Negocio();  
 %>    
 <h2 class="text-red">Lista de especialidad</h2>
 <table class="table table-hover">
     <thead>
         <tr class="text-white bg-black">
             <th>Codigo<th>Nombre<th>alumno     
     </thead>  
    <%
       for(Especial x:obj.lisEsp()){
       out.print("<tr><td>"+x.getCode()+"<td>"+x.getNome());
     %>
     <td><a href="control?opc=1&cod=<%=x.getCode()%>&nom=<%=x.getNome()%>" class="btn btn-success">Alumno</a>
     <%
        }     
    %> 




    
     
 </table> 
    
    
    
    
    
    
    
    </body>
    
    
  
</html>
