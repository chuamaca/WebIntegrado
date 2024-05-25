<%-- 
    Document   : Grafico
    Created on : 18 may. 2024, 11:52:16
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.MVentasAnio, Data.Dventas"%>
<html>
    <head>
        <script src=
        "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.2.2/Chart.min.js"></script>
        <style>
            .container {
                width: 100%;
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

        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%
            Dventas listaventas = new Dventas();
            int anio = 0;
            String tipo = "";

            if (request.getParameter("anio") != null) {
                anio = Integer.parseInt(request.getParameter("anio"));
            }
            if (request.getParameter("opc") != null) {
                tipo = request.getParameter("opc");
            }


        %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-2">
                    <div class="card">
                        <div class="card-body">
                            <form action="" method="pos">
                                <div class="form-group">
                                    <label>Ingrese Año</label>
                                    <input name="anio" type="text" class="form-control" value="<%=anio%>">

                                </div>
                                <div class="form-group">
                                    <label>Seleccione Tipo de Grafico</label>
                                    <input type="radio" name="opc" value="bar">Barra
                                    <input type="radio" name="opc" value="pie">Torta
                                    <input type="radio" name="opc" value="line">Lineal
                                </div>
                                <button type="submit" class="btn btn-primary">Generar</button>
                                <br>
                                <table class="table table-bordered">
                                    <tr><th>Mes<th>Monto

                                            <%
                                                for (MVentasAnio ventas : listaventas.SelectVentasAnio()) {
                                                    out.println("<tr><td>" + ventas.getAnio() + "<td>" + ventas.getCantidad());
                                                }
                                            %>
                                    </tr>
                                </table>
                            </form>

                        </div>
                    </div>

                </div>
                <div class="col-sm-8">
                    <div class="container-fluid">
                        <h2>Line Chart</h2>
                        <div>
                            <canvas id="myChart"></canvas>
                        </div>
                    </div>

                </div>
            </div>
        </div>


        <%System.out.println("anio" + anio);
            String label = "", data = "";
            for (MVentasAnio ventas : listaventas.SelectVentasAnio()) {

                label = label + "'" + ventas.getCantidad()+ "',";
                data = data + ventas.getCantidad()+ ",";

            }
            if (data.length() >0) {
                data = data.substring(0, data.length() - 1);
            }


        %>

    </body>
    <script>
        var ctx = document.getElementById("myChart").getContext("2d");
        var myChart = new Chart(ctx, {
            type: "<%=tipo%>",
            data: {
                //Eje X
                labels: [<%=label%>],
                datasets: [
                    {
                        label: "work load",
                        data: [<%=data%>],

                        backgroundColor: ["rgba(153,205,1,0.6)", "lightgreen", "green", "grey"],
                    },
                ],
            },
        });
    </script>
</html>