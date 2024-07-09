/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Alondra
 */
public class Notas {
    private String coda;
    private String ape;
    private String noma;
    private double ExaParcial;
    private double ExaFinal;
    private double Promedio;

    public Notas(String coda, String ape, String noma, double ExaParcial, double ExaFinal, double Promedio) {
        this.coda = coda;
        this.ape = ape;
        this.noma = noma;
        this.ExaParcial = ExaParcial;
        this.ExaFinal = ExaFinal;
        this.Promedio = Promedio;
    }

    public String getCoda() {
        return coda;
    }

    public String getApe() {
        return ape;
    }

    public String getNoma() {
        return noma;
    }

    public double getExaParcial() {
        return ExaParcial;
    }

    public double getExaFinal() {
        return ExaFinal;
    }

    public double getPromedio() {
        return Promedio;
    }

    public void setCoda(String coda) {
        this.coda = coda;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public void setNoma(String noma) {
        this.noma = noma;
    }

    public void setExaParcial(double ExaParcial) {
        this.ExaParcial = ExaParcial;
    }

    public void setExaFinal(double ExaFinal) {
        this.ExaFinal = ExaFinal;
    }

    public void setPromedio(double Promedio) {
        this.Promedio = Promedio;
    }
    
    
}
