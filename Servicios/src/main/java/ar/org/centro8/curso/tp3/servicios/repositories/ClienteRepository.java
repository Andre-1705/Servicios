package ar.org.centro8.curso.tp3.servicios.repositories;
import ar.org.centro8.curso.tp3.servicios.connectors.Connector;
import ar.org.centro8.curso.tp3.servicios.entities.Cliente;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteRepository{   

    private Connection conn=Connector.getConnection();

    public void save(Cliente cliente){

        if(cliente == null) return;
            try (PreparedStatement ps=conn.prepareStatement(
                "insert into clientes (apellido, nombre, edad, email, telefono) values (?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)){

                ps.setString(1, cliente.getApellido());
                ps.setString(2, cliente.getNombre());
                ps.setInt(3, cliente.getEdad());
                ps.setString(4, cliente.getEmail());
                ps.setInt(5, cliente.getTelefono());
                ps.execute();

                ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) cliente.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void remove(Cliente cliente){

        if(cliente == null) return;
        try (PreparedStatement ps = conn.prepareStatement(
            "delete from clientes where id=?")){
            ps.setInt(1, cliente.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Cliente>getAll(){
        List<Cliente> list = new ArrayList();
        try (ResultSet rs = conn
                                .createStatement()
                                .executeQuery("select * from clientes")){
            while(rs.next()){
                list.add(new Cliente(
                                    rs.getInt("id"), 
                                    rs.getString("apellido"), 
                                    rs.getString("nombre"), 
                                    rs.getInt("edad"),
                                    rs.getString("email"),
                                    rs.getInt("telefono")
                ));
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return list;
    }

    public Cliente getById(int id){
        return getAll()
                        .stream()
                        .filter(cliente->cliente.getId()==id)
                        .findFirst()
                        .orElse(new Cliente());
    }

    public List<Cliente>getLikeApellido(String apellido){

        if(apellido == null) return new ArrayList();
        return getAll()
                        .stream()
                        .filter(cliente->cliente
                                                .getApellido()
                                                .toLowerCase()
                                                .contains(apellido.toLowerCase()))
                        .toList();
    }

}