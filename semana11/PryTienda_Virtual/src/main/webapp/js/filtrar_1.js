
$(document).ready(function () {  
   //cuando se escriba caracteres en la caja de texto  
    $(document).on('keyup','#txtnom',function(){ 
        let valor = $(this).val();  
             listado(valor);  
         
    });  
     
   function listado(consulta) {  
        opc = "4";  
        $.get("control", {opc, consulta}, (response) => {  
            const misDatos = JSON.parse(response);//recuperar la informacion q envio el controlador  
            let template = "";  
             console.log(misDatos);  
             
           template += `  
             <table class="table table-hover">  
                                    <thead class="text-white bg-dark">  
                                        <tr>  
                                            <th>Codigo</th>  
                                            <th>Nombre</th>  
                                            <th>apellido</th> 
                                             <th>Esp</th>
                                            <th>Proce</th>
                                            <th>Foto</th> 
                                            <th>Buscar</th>
                                           </tr>  
                                    </thead>  
                                    <tbody>`;    
            misDatos.forEach(midato => {  
                template += `  
                <tr>  
                <td>${midato.coda}</td>  
                    <td>${midato.noma}</td>  
                    <td>${midato.ape}</td> 
                   <td>${midato.code}</td> 
                   <td>${midato.proce}</td> 
                    <td><img src="fotos/${midato.coda}.jpg" width="90" height="90" class="img-circle"
                        onerror="src='fotos/sin_foto.jpg'" ></td>
                    <td><a href="javascript:pasaSeleccion('${midato.coda}', '${midato.noma}', 
'${midato.ape}');"> 
<img src="botones/Edit.gif" height="20" width="20" class="center-block"></a> 
                                </tr>`;              
                  
            })  
            template += `</tbody></table>`;  
            $("#tablares").html(template);  
  
        })  
    } //fin de listado 
     
}) 
    