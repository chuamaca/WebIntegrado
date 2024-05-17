package modelo;

public class Alumno {
    private String coda;
    private String ape;
    private String noma;
    private String code;
    private String proce;
    public String apeNom(){
        return ape+","+noma;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProce() {
        return proce;
    }

    public void setProce(String proce) {
        this.proce = proce;
    }
    
}
