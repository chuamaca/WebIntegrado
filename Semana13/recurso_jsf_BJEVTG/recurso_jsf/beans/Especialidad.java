/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author MORENO
 */
public class Especialidad implements Serializable{
    private String code;
    private String nomes;

    public Especialidad() {
    }

    public Especialidad(String code, String nomes) {
        this.code = code;
        this.nomes = nomes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNomes() {
        return nomes;
    }

    public void setNomes(String nomes) {
        this.nomes = nomes;
    }
    
}
