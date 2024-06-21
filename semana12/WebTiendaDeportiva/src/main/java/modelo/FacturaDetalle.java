/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Cesar
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacturaDetalle extends Articulo{

    private String nroFactura;
    private String idArticulo;
    private int cantidad;
    
    
    public double total(){
       return super.getPrecioUnidad()*cantidad;
   }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   
}