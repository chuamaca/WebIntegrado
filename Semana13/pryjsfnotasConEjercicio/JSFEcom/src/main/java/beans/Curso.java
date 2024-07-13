/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Alondra
 */
public class Curso {
    private String IdCurso;
    private String NomCurso;

    public Curso() {
    }

    
    
    public Curso(String IdCurso, String NomCurso) {
        this.IdCurso = IdCurso;
        this.NomCurso = NomCurso;
    }

    public String getIdCurso() {
        return IdCurso;
    }

    public String getNomCurso() {
        return NomCurso;
    }

    public void setIdCurso(String IdCurso) {
        this.IdCurso = IdCurso;
    }

    public void setNomCurso(String NomCurso) {
        this.NomCurso = NomCurso;
    }
    
    
}
