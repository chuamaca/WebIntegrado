<%-- 
    Document   : indexjsp
    Created on : 6 abr. 2024, 10:27:58
    Author     : Cesar
--%>



<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>EJercico 02</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
       <h3>EJercico 02</h3>
        <table border="1" class="table">
            <tr>
                <th>Cliente</th>
                <th>Préstamo</th>
                <th>Meses</th>
                <th>Interés</th>
                <th>Saldo</th>
                <th>Cuota</th>
            </tr>
            <%
                Random random = new Random();

                for (int i = 1; i <= 25; i++) {

                    int cliente = i;
                    // Generar el valor del préstamo aleatorio entre 500 y 4000
                    int prestamo = random.nextInt(3501) + 500;

                    // Generar el número de meses aleatorio entre 6 y 24
                    int meses = random.nextInt(19) + 6;

                    // Calcular la tasa de interés según los meses
                    double tasaInteres;
                    if (meses <= 10) {
                        tasaInteres = 0.12;
                    } else if (meses <= 15) {
                        tasaInteres = 0.18;
                    } else if (meses <= 20) {
                        tasaInteres = 0.20;
                    } else {
                        tasaInteres = 0.24;
                    }

                    double interes = prestamo * tasaInteres;

                    double saldo = prestamo + interes;

                    double cuotaMensual = saldo / meses;
                    out.println("<tr>");
                    out.println("<td>" + cliente + "</td>");
                    out.println("<td>" + prestamo + "</td>");
                    out.println("<td>" + meses + "</td>");
                    out.println("<td>" + Math.round(interes*100.0)/100.0 + "</td>");
                    out.println("<td>" + Math.round(saldo*100.0)/100.0 + "</td>");
                    out.println("<td>" + Math.round(cuotaMensual*100.0)/100.0 + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>
