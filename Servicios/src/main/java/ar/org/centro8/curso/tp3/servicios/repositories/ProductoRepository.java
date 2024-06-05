package ar.org.centro8.curso.tp3.servicios.repositories;

import ar.org.centro8.curso.tp3.servicios.connectors.Connector;
import ar.org.centro8.curso.tp3.servicios.entities.Producto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoRepository {  
    
    private Connection conn=Connector.getConnection();
    
    public void save(Producto producto){

        if(producto == null) return;
        try (PreparedStatement ps = conn.prepareStatement(
            "insert into productos (nombre, precio, stock) values (?,?,?)",
            PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) producto.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void remove(Producto producto){

        if(producto == null) return;
        try (PreparedStatement ps = conn.prepareStatement(
            "delete from productos where id=?")){
            ps.setInt(1, producto.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Producto>getAll(){
        List<Producto> list = new ArrayList();
        try (ResultSet rs = conn
                                .createStatement()
                                .executeQuery("select * from productos")){
            while(rs.next()){
                list.add(new Producto(
                                    rs.getInt("id"), 
                                    rs.getString("nombre"), 
                                    rs.getDouble("precio"),
                                    rs.getInt("stock")
                ));
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return list;
    }

    public Producto getById(int id){
        return getAll()
                        .stream()
                        .filter(producto->producto.getId()==id)
                        .findFirst()
                        .orElse(new Producto());
    }

    public List<Producto>getLikeApellido(String nombre){

        if(nombre == null) return new ArrayList();
        return getAll()
                        .stream()
                        .filter(producto->producto
                                                .getNombre()
                                                .toLowerCase()
                                                .contains(nombre.toLowerCase()))
                        .toList();
    }

}

