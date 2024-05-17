<%-- 
    Document   : pagNota
    Created on : 4 may. 2024, 14:11:35
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

            List<Curso> list = (ArrayList<Curso>) request.getAttribute("dato");
            String Nombre = (String) request.getAttribute("nombre");

            /*
      private String IdCurso;
 private String NomCurso;
 private int credito;
     private int ExaParcial;
 private int ExaFinal;
             */

        %>



        <a href="javascript:history.go(-1)" class="btn btn-success">Back</a>

        <h2>Notas del Alumno <%=Nombre%></h2>

        <table border="1" class="table table-hover">
            <tr><th>NomCurso<th>credito<th>ExaParcial<th>ExaFinal<th>Promedio

                    <%                        for (Curso x : list) {

                            out.print("<tr><td>" + x.getNomCurso() + "<td>" + x.getCredito() + "<td>" + x.getExaParcial()
                                    + "<td>" + x.getExaFinal() + "<td>" + (x.getExaParcial() + x.getExaFinal()) / 2);

                        }

                    %>


        </table>









    </body>
</html>
