/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utpcode.demo.modelo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Cesar
 */
public interface EmpleadoInterface extends CrudRepository<Empleado, Integer>{
    public List<Empleado> findByNombreContains(String palabra);
}
