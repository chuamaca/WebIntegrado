package beans;

import java.io.Serializable;

public class Alumno implements Serializable{
    private String coda;
    private String ape;
    private String noma;
    private String colegio;
    private String codes;
    public Alumno() {
    }

    public Alumno(String coda, String ape, String noma) {
        this.coda = coda;
        this.ape = ape;
        this.noma = noma;
    }

    
    public String getCoda() {
        return coda;
    }

    public void setCoda(String coda) {
        this.coda = coda;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getNoma() {
        return noma;
    }

    public void setNoma(String noma) {
        this.noma = noma;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }
    
}
