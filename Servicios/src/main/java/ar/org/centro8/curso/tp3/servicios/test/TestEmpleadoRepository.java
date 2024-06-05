package ar.org.centro8.curso.tp3.servicios.test;
import ar.org.centro8.curso.tp3.servicios.entities.Empleado;
import ar.org.centro8.curso.tp3.servicios.repositories.EmpleadoRepository;
import java.time.LocalDate;


public class TestEmpleadoRepository {
    public static void main(String[] args){ EmpleadoRepository empleadoRepository = new EmpleadoRepository();

        System.out.println("-- Método .save() --");
        Empleado empleado = new Empleado(
                                    1, 
                                    "Lopez",
                                    "Carlos", 
                                    5000000, 
                                    (LocalDate.of(2024, 1, 1)));
                                    
        empleadoRepository.save(empleado);
        System.out.println(empleado);

        System.out.println("-- Método .getById()");
        System.out.println(empleadoRepository.getById(1));

        System.out.println("-- Método remove() --");
        empleadoRepository.remove(empleadoRepository.getById(22));

        System.out.println("-- Método getLikeApellido()");
        empleadoRepository.getLikeApellido("Lo").forEach(System.out::println);

        System.out.println("-- Método .getAll() --");
        empleadoRepository.getAll().forEach(System.out::println);    
    }
}