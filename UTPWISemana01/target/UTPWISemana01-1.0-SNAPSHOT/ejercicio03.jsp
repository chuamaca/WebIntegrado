<%-- 
    Document   : ejercicio03
    Created on : 6 abr. 2024, 11:24:44
    Author     : Cesar
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ejercicio 03</title>
    
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   
</head>
<body>
    <h1>Velocidades de Autos</h1>
    <table border="1" class="table">
        <tr>
            <th>Auto</th>
            <th>Velocidad (km/hr)</th>
            <th>Estado</th>
        </tr>
        <% 
            Random random = new Random();
            int limiteVelocidad = 60;
            int autosSobrepasados = 0;

            for (int i = 1; i <= 20; i++) {
                // Generar velocidad aleatoria entre 30 y 90 km/hr
                int velocidad = random.nextInt(61) + 30;

                // Verificar si la velocidad supera el límite
                String estado;
                if (velocidad > limiteVelocidad) {
                    estado = "<img src='infraccion.png' alt='Infracción'>";
                    autosSobrepasados++;
                } else {
                    estado = "<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-emoji-laughing-fill' viewBox='0 0 16 16'>
  <path d='M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16M7 6.5c0 .501-.164.396-.415.235C6.42 6.629 6.218 6.5 6 6.5s-.42.13-.585.235C5.164 6.896 5 7 5 6.5 5 5.672 5.448 5 6 5s1 .672 1 1.5m5.331 3a1 1 0 0 1 0 1A5 5 0 0 1 8 13a5 5 0 0 1-4.33-2.5A1 1 0 0 1 4.535 9h6.93a1 1 0 0 1 .866.5m-1.746-2.765C10.42 6.629 10.218 6.5 10 6.5s-.42.13-.585.235C9.164 6.896 9 7 9 6.5c0-.828.448-1.5 1-1.5s1 .672 1 1.5c0 .501-.164.396-.415.235'/>
</svg>";
                }

                // Imprimir los datos del auto en una fila de la tabla
                out.println("<tr>");
                out.println("<td>" + i + "</td>");
                out.println("<td>" + velocidad + "</td>");
                out.println("<td>" + estado + "</td>");
                out.println("</tr>");
            } 
        %>
    </table>

    <p>Autos sobrepasados: <%= autosSobrepasados %></p>
</body>
</html>
