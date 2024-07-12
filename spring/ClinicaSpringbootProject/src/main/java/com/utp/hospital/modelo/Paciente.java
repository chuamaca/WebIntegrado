package com.utp.hospital.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.*;
@Entity
@Table(name="paciente2")
public class Paciente {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int idPaciente;
     private String nombres, apellidoPaterno, apellidoMaterno, genero, telefono, tipo_documento, num_doc;

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public String getNum_doc() {
        return num_doc;
    }
     private Date fechanac;
    
     //constructor

    public Paciente() {
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public Paciente(int idPaciente, String nombres, String apellidoPaterno, String apellidoMaterno, String genero, String telefono, Date fechanac) {
        this.idPaciente = idPaciente;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.telefono = telefono;
        this.fechanac = fechanac;
    }

     //getter y setter

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }



    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    
    
}