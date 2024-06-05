package ar.org.centro8.curso.tp3.servicios.test;
import ar.org.centro8.curso.tp3.servicios.entities.Cliente;
import ar.org.centro8.curso.tp3.servicios.repositories.ClienteRepository;


public class TestClienteRepository {
    public static void main(String[] args) {
        ClienteRepository clienteRepository = new ClienteRepository();

        System.out.println("-- Método .save() --");
        Cliente cliente = new Cliente(
                                    1, 
                                    "Rios", 
                                    "Carlos", 
                                    50, 
                                    "carlos@gmail.com",
                                    1151112222);
    
        clienteRepository.save(cliente);
        System.out.println(cliente);

        System.out.println("-- Método .getById()");
        System.out.println(clienteRepository.getById(1));

        System.out.println("-- Método remove() --");
        clienteRepository.remove(clienteRepository.getById(22));

        System.out.println("-- Método getLikeTitulo()");
        clienteRepository.getLikeApellido("ri").forEach(System.out::println);

        System.out.println("-- Método .getAll() --");
        clienteRepository.getAll().forEach(System.out::println);

    }
}
