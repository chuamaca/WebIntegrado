
package beans;

public class Pagos {
    private String ciclo;
    private String fecha;
    private double monto;

    public Pagos(String ciclo, String fecha, double monto) {
        this.ciclo = ciclo;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Pagos() {
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
