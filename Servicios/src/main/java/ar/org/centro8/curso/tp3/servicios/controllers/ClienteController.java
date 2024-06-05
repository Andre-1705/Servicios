package ar.org.centro8.curso.tp3.servicios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
    
    @GetMapping("/clientes")
    public String getClientes(){
        return "clientes";
    }

}

