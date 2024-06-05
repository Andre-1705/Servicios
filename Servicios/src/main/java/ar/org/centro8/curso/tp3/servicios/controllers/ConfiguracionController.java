package ar.org.centro8.curso.tp3.servicios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfiguracionController {
    
    @GetMapping("/configuracion")
    public String getConfiguracion(){
        return "configuracion";
    }
}