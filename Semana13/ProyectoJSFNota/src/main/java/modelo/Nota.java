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
public class Nota {

    private String IdAlumno;
    private String IdCurso;
    private int ExaParcial;
    private int ExaFinal;

    public double promedio() {
        return (ExaParcial + ExaFinal) / 2;
    }

    public String Observacion() {
        return promedio() >= 11.5 ? "Aprobado" : "Desaprobado";
    }

}
