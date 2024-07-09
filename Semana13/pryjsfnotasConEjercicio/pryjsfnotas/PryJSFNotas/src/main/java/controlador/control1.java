package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import dao.Negocio;
import beans.*;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class control1 implements Serializable {

    private List<Alumno> lisalu;
    private List<Notas> lisaluN;
    private List<Pagos> lispago;
    private String nombre;
    private double total;
    private String texto;
    private String Idesp;
    List<SelectItem> lisep ;//ASIGNAR PARA COMBOS
    Especialidad ep;
    
    List<SelectItem> lisCur ;//ASIGNAR PARA COMBOS
    Curso cur;
    private int CantDesa;
    private int CantAPO;

    @PostConstruct //anotacion que se ejecuta cunado la pagina asociada se carge    
    public void init() {
        //lisalu = new Negocio().LisAlu();
        lisaluN = new Negocio().LisNotCursoG();
        //lisep = new ArrayList();
        lisCur = new ArrayList();
        //for (Especialidad x: new Negocio().LisESp()){
        //    SelectItem sle = new SelectItem(x.getCode(), x.getNomes());
        //    lisep.add(sle);
        //}
        
        for (Curso x: new Negocio().LisCurso()){
            SelectItem sle = new SelectItem(x.getIdCurso(), x.getNomCurso());
            lisCur.add(sle);
        }
        
    }

    public void verpago(Alumno a) {
        lispago = new Negocio().LisPago(a.getCoda());
        nombre = a.getApe() + "," + a.getNoma();
        total = 0;
        for (Pagos x : lispago) {
            total = +x.getMonto();
        }
    }

    public void filtra() {
        lisalu = new Negocio().LisAlu(texto);
    }
    
    public void filtraEsp() {
        lisalu = new Negocio().LisEsp(ep.getCode());
    }
    
    public void filtraCur() {
        lisaluN = new Negocio().LisNotCurso(cur.getIdCurso());
        CantDesa=0;
        CantAPO=0;
        for (Notas x: lisaluN){
            if(x.getPromedio()<11){
                CantDesa= CantDesa+1;
            }else{
                CantAPO= CantAPO+1;
            }
        }
    }

    public control1() {
        texto = "";
        ep= new Especialidad();
        cur = new Curso();
    }

    public List<Alumno> getLisalu() {
        return lisalu;
    }

    public void setLisalu(List<Alumno> lisalu) {
        this.lisalu = lisalu;
    }

    public List<Pagos> getLispago() {
        return lispago;
    }

    public void setLispago(List<Pagos> lispago) {
        this.lispago = lispago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getIdesp() {
        return Idesp;
    }

    public void setIdesp(String Idesp) {
        this.Idesp = Idesp;
    }

    public List<SelectItem> getLisep() {
        return lisep;
    }

    public Especialidad getEp() {
        return ep;
    }

    public void setLisep(List<SelectItem> lisep) {
        this.lisep = lisep;
    }

    public void setEp(Especialidad ep) {
        this.ep = ep;
    }

    public List<SelectItem> getLisCur() {
        return lisCur;
    }

    public Curso getCur() {
        return cur;
    }

    public void setLisCur(List<SelectItem> lisCur) {
        this.lisCur = lisCur;
    }

    public void setCur(Curso cur) {
        this.cur = cur;
    }

    public List<Notas> getLisaluN() {
        return lisaluN;
    }

    public void setLisaluN(List<Notas> lisaluN) {
        this.lisaluN = lisaluN;
    }

    public int getCantDesa() {
        return CantDesa;
    }

    public int getCantAPO() {
        return CantAPO;
    }

    public void setCantDesa(int CantDesa) {
        this.CantDesa = CantDesa;
    }

    public void setCantAPO(int CantAPO) {
        this.CantAPO = CantAPO;
    }
    
    

}
