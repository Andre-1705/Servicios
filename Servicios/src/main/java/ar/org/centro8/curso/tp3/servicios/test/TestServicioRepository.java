package ar.org.centro8.curso.tp3.servicios.test;
import ar.org.centro8.curso.tp3.servicios.entities.Servicio;
import ar.org.centro8.curso.tp3.servicios.repositories.ServicioRepository;


public class TestServicioRepository {
    public static void main(String[] args) {
        ServicioRepository servicioRepository = new ServicioRepository();

        System.out.println("-- Método .save() --");
        Servicio servicio = new Servicio(
                                    1, 
                                    "Servicios Programación de Aplicaciones", 
                                    "Creación de proyectos, Consultoría, etc", 
                                    "Programación");
    
        servicioRepository.save(servicio);
        System.out.println(servicio);

        System.out.println("-- Método .getById()");
        System.out.println(servicioRepository.getById(1));

        System.out.println("-- Método remove() --");
        servicioRepository.remove(servicioRepository.getById(22));

        System.out.println("-- Método getLikeNombre()");
        servicioRepository.getLikeNombre("ser").forEach(System.out::println);

        System.out.println("-- Método .getAll() --");
        servicioRepository.getAll().forEach(System.out::println);
    }
}

