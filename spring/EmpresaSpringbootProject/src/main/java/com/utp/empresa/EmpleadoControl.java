package com.utp.empresa;

import com.utp.empresa.modelo.*;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class EmpleadoControl {

    @Autowired
    private EmpleadoInterface servicio;

    @GetMapping("/listar")
    public String listado(Model modelo,@Param ("palabra") String palabra) {
        if(palabra!=null){
            modelo.addAttribute("empleados", servicio.findByNombreContaining(palabra));
        }else{
            modelo.addAttribute("empleados", servicio.findAll());
        }        
        double sm = 0;
        for (Empleado x : servicio.findAll()) {
            sm += x.total();
        }
        modelo.addAttribute("totales", sm);
        return "index";
    }
    
    @GetMapping("/listar2")
    public String listado2(Model modelo) {
        modelo.addAttribute("empleados", servicio.findAll());
        double sm = 0;
        for (Empleado x : servicio.findAll()) {
            sm += x.total();
        }
        modelo.addAttribute("totales", sm);
        return "index";
    }

    @GetMapping("/new")
    public String nuevo(Model modelo) {
        modelo.addAttribute("persona", new Empleado());
        modelo.addAttribute("titulo", "Nuevo Registro");
        return "pagina1";
    }

    @PostMapping("/save")
    public String graba(Model modelo, Empleado ep) {
        servicio.save(ep);
        return "redirect:/listar"; //redirigir
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model modelo) {
        Optional<Empleado> persona = servicio.findById(id);
        modelo.addAttribute("titulo", "Formulario Editar");
        modelo.addAttribute("persona", persona);
        return "pagina1";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model modelo) {
        servicio.deleteById(id);
        return "redirect:/listar";
    }

}
