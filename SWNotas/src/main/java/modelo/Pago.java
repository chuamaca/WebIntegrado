/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Cesar
 */
public class Pago {
    	private String IdAlumno;
	private String CICLO;
	private int NCUOTA;
	private double MONTO;
	private String FECHA;

    public String getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(String IdAlumno) {
        this.IdAlumno = IdAlumno;
    }

    public String getCICLO() {
        return CICLO;
    }

    public void setCICLO(String CICLO) {
        this.CICLO = CICLO;
    }

    public int getNCUOTA() {
        return NCUOTA;
    }

    public void setNCUOTA(int NCUOTA) {
        this.NCUOTA = NCUOTA;
    }

    public double getMONTO() {
        return MONTO;
    }

    public void setMONTO(double MONTO) {
        this.MONTO = MONTO;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

        

}
