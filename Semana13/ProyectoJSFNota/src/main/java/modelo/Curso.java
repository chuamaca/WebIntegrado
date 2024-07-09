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
public class Curso extends Nota{

    private String IdCurso;
    private String NomCurso;
    private int credito;

    public String getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(String IdCurso) {
        this.IdCurso = IdCurso;
    }

    public String getNomCurso() {
        return NomCurso;
    }

    public void setNomCurso(String NomCurso) {
        this.NomCurso = NomCurso;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }
    
    

}
