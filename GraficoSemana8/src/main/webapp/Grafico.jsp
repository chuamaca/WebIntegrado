<%-- 
    Document   : Grafico
    Created on : 18 may. 2024, 11:52:16
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.MVentas, Data.Dventas"%>
<html>
    <head>
        <script src=
        "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.2.2/Chart.min.js"></script>
        <style>
            .container {
                width: 70%;
                margin: 15px auto;
            }
            body {
                text-align: center;
                color: green;
            }
            h2 {
                text-align: center;
                font-family: "Verdana", sans-serif;
                font-size: 30px;
            }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>

        <%

            Dventas listaventas = new Dventas();
            int anio = Integer.parseInt(request.getParameter("anio"));
            String tipo=request.getParameter("opc");
            System.out.println("anio" + anio);
            String label = "", data = "";
            for (MVentas ventas : listaventas.Select(anio)) {

                label = label + "'" + ventas.Lmes() + "',";
                data = data + ventas.getMonto() + ",";

            }

            data = data.substring(0, data.length() - 1);
        %>



        <div class="container">
            <h2>Line Chart</h2>
            <div>
                <canvas id="myChart"></canvas>
            </div>
        </div>
    </body>
    <script>
        var ctx = document.getElementById("myChart").getContext("2d");
        var myChart = new Chart(ctx, {
            type: "<%=tipo%>",
            data: {
                //Eje X
                labels: [<%=label%>  ],
                datasets: [
                    {
                        label: "work load",
                        data: [<%=data%>],
                      

                        backgroundColor: ["rgba(153,205,1,0.6)","lightgreen","green","grey"],
                    },
                ],
            },
        });
    </script>
</html>