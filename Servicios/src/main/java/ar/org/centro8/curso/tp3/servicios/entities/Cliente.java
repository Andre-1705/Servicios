package ar.org.centro8.curso.tp3.servicios.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private int id;
    private String apellido;
    private String nombre;
    private int edad;
    private String email;
    private int telefono;
}

