package ar.org.centro8.curso.tp3.servicios.test;
import ar.org.centro8.curso.tp3.servicios.entities.Producto;
import ar.org.centro8.curso.tp3.servicios.repositories.ProductoRepository;


public class TestProductoRepository {
    public static void main(String[] args) {
        ProductoRepository productoRepository = new ProductoRepository();

        System.out.println("-- Método .save() --");
        Producto producto = new Producto(
                                    1, 
                                    "Manual Programación", 
                                    50000, 
                                    10000);
    
        productoRepository.save(producto);
        System.out.println(producto);

        System.out.println("-- Método .getById()");
        System.out.println(productoRepository.getById(1));

        System.out.println("-- Método remove() --");
        productoRepository.remove(productoRepository.getById(22));

        System.out.println("-- Método .getAll() --");
        productoRepository.getAll().forEach(System.out::println);
    }
}

