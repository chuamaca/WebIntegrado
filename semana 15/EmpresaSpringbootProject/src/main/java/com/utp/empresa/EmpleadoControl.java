
package com.utp.empresa;

import com.utp.empresa.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class EmpleadoControl {
    @Autowired
    private EmpleadoInterface servicio;
    @GetMapping("/listar")
    public String listado(Model modelo){
     modelo.addAttribute("empleados",servicio.findAll());
    double sm=0;
    for(Empleado x:servicio.findAll()){
        sm += x.total();
    }
     modelo.addAttribute("totales",sm);
     return "index";
    }
    @GetMapping("/new")
    public String nuevo(Model modelo){
       modelo.addAttribute("persona",new Empleado());
       modelo.addAttribute("titulo","Nuevo Registro");
       return "pagina1"; 
    }
    @PostMapping("/save")
    public String graba(Model modelo, Empleado ep){
        servicio.save(ep);
        return "redirect:/listar"; //redirigir
    }
    
}
