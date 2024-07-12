
package com.utp.hospital.modelo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PacienteInterface extends CrudRepository<Paciente, Integer>{
 public List<Paciente> findByNombresContaining(String palabra);   
    
}
