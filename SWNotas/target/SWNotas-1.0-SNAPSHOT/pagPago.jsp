<%-- 
    Document   : pagPago
    Created on : 4 may. 2024, 13:59:00
    Author     : Cesar
--%>

<%@page import="modelo.*,java.util.*"%>
<%@page import="dao.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
   
    </head>
    <body>
        <%
        
        List<Pago> list=(ArrayList<Pago>)request.getAttribute("dato");
        /*
         obj.setIdAlumno(rs.getString(1));
                obj.setCICLO(rs.getString(2));
                obj.setNCUOTA(rs.getInt(3));
                obj.setMONTO(rs.getDouble(4));
                obj.setFECHA(rs.getString(5));
        */
        %>
        
        
        
        
        <table border="1" class="table table-hover">
            <tr><th>Ciclo<th>Couta<th>Monto<th>Fecha
                
                    <%
                    
                    for(Pago x:list){
                    
                     out.print("<tr><td>" + x.getCICLO() + "<td>" + x.getNCUOTA() + "<td>" + x.getMONTO() + "<td>" + x.getFECHA());

                        }
                    
                    %>
                    
                    
        </table>
        
        
    </body>
</html>
