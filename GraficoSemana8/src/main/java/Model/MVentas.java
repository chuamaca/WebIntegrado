/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
public class MVentas {
    int mes;
    double monto;
    public String Lmes(){

        String vec[]={"","Enero","Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre","Octubre","Noviembre","Diciembre"};
        return vec[mes];
    }
    
    public int getMes(){
        return mes;
    }
    
}
