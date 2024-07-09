
package beans;

public class Facturas {
  private String nro;
  private String fecha;
private String tipo;

    public Facturas(String nro, String fecha, String tipo) {
        this.nro = nro;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public Facturas() {
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
