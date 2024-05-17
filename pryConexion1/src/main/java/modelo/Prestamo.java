/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Cesar
 */
public class Prestamo {

    int nropre;
    String cliente;
    double monto;
    int meses;

    public Prestamo() {
    }
    

    public Prestamo(int nropre, String cliente, double monto, int meses) {
        this.nropre = nropre;
        this.cliente = cliente;
        this.monto = monto;
        this.meses = meses;
    }

    public double intereses() {
        return monto * 0.02 * meses;
    }

    public double saldo() {
        return monto + intereses();
    }

    public double couta() {
        return saldo() / meses;
    }

    public int getNropre() {
        return nropre;
    }

    public void setNropre(int nropre) {
        this.nropre = nropre;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

}
