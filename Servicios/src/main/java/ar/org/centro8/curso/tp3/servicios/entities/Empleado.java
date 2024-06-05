package ar.org.centro8.curso.tp3.servicios.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    private int id;
    private String apellido;
    private String nombre;
    private double salario;
    private LocalDate fecha_contrato;
}
