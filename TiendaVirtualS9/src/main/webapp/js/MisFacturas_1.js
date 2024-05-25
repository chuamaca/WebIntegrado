$(document).ready(function () {
    var funcion = "";
    // listarFacturas();
  
    function listarFacturas(consulta) {
        op = "9";
        $.post("tienda", {op, consulta}, (response) => {
            const misFacturas = JSON.parse(response);
            let template = "";
            console.log(misFacturas);
            template += `
          
             <table class="table tabla table-hover text-nowrap">
                                    <thead class="text-white bg-dark">
                                        <tr>
                                            <th>Id Art</th>
                                            <th>descripcion</th>
                                            <th>precio</th>
                                           </tr>
                                    </thead>
                                    <tbody>`;
            misFacturas.forEach(miFactura => {
                template += `
                <tr>
                    <td>${miFactura.coda}</td>
                    <td>${miFactura.nomart}</td>
                    <td>${miFactura.precio}</td>
                             </tr>`;
            })
            template += `</tbody></table>`;
            $("#tablares").html(template);

        })
    }
    
    $(document).on('keyup','#txtnom',function(){
        let valor = $(this).val();
        if(valor!=""){
            listarFacturas(valor);
        }
        else{
            listarFacturas();
        }
        
    });
})