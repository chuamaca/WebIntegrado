
package com.utp.empresa.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private String nombre;
    private double tarifa;
    private int horas;
    public double total(){
     return tarifa*horas;   
    }

    public Empleado() {
    }

    public Empleado(int code, String nombre, double tarifa, int horas) {
        this.code = code;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
}
