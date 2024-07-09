
package beans;


public class Detalle {
  String coda;
  String noma;
double puni;
int can;

    public Detalle(String coda, String noma, double puni, int can) {
        this.coda = coda;
        this.noma = noma;
        this.puni = puni;
        this.can = can;
    }

    public Detalle() {
    }

public double total(){
    return puni*can;
}

    public String getCoda() {
        return coda;
    }

    public void setCoda(String coda) {
        this.coda = coda;
    }

    public String getNoma() {
        return noma;
    }

    public void setNoma(String noma) {
        this.noma = noma;
    }

    public double getPuni() {
        return puni;
    }

    public void setPuni(double puni) {
        this.puni = puni;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }


}
