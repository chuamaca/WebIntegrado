
package beans;

public class Cliente {
  private String codc;
  private String nomc;
  private double cre;

    public Cliente() {
    }

    public Cliente(String codc, String nomc, double cre) {
        this.codc = codc;
        this.nomc = nomc;
        this.cre = cre;
    }

    public String getCodc() {
        return codc;
    }

    public void setCodc(String codc) {
        this.codc = codc;
    }

    public String getNomc() {
        return nomc;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }

    public double getCre() {
        return cre;
    }

    public void setCre(double cre) {
        this.cre = cre;
    }
  
}
