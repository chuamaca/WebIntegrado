<%-- 
    Document   : Ejercicio01
    Created on : 6 abr. 2024, 10:36:47
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ejercicio 01</h1>

        <div>

            <%
                Calendar t = Calendar.getInstance();

                int dia = t.get(Calendar.DAY_OF_WEEK);
                String monthText = t.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());

                String longDayName = t.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());

                int year = t.get(Calendar.YEAR);

                out.print("<h2>Hoy es " + longDayName + ", " + dia + "  de " + monthText + " " + year + "</h2>");


            %>


        </div>
    </body>
</html>
