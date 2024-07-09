
package com.utp.empresa.modelo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoInterface extends CrudRepository<Empleado, Integer>{
 public List<Empleado> findByNombreContaining(String palabra);   
    
}
