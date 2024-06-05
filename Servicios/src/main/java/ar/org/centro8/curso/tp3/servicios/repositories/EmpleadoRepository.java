package ar.org.centro8.curso.tp3.servicios.repositories;

import ar.org.centro8.curso.tp3.servicios.connectors.Connector;
import ar.org.centro8.curso.tp3.servicios.entities.Empleado;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoRepository {
 
    private Connection conn=Connector.getConnection();

    public void save(Empleado empleado){

        if(empleado == null) return;

            try (PreparedStatement ps = conn.prepareStatement(
                "insert into empleados (apellido, nombre, salario, fecha_contrato) values (?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)){

                ps.setString(1, empleado.getApellido());
                ps.setString(2, empleado.getNombre());
                ps.setDouble(3, empleado.getSalario());
                ps.setDate(4, Date.valueOf(empleado.getFecha_contrato()));
                ps.execute();
            
                ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) empleado.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void remove(Empleado empleado){

        if(empleado == null) return;
        try (PreparedStatement ps = conn.prepareStatement(
            "delete from empleados where id=?")){
            ps.setInt(1, empleado.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Empleado>getAll(){
        List<Empleado> list = new ArrayList();
        try (ResultSet rs = conn
                                .createStatement()
                                .executeQuery("select * from empleados")){
            while(rs.next()){
                list.add(new Empleado(
                                    rs.getInt("id"), 
                                    rs.getString("apellido"), 
                                    rs.getString("nombre"), 
                                    rs.getDouble("salario"),
                                    rs.getDate("fecha_contrato").toLocalDate()
                ));
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return list;
    }

    public Empleado getById(int id){
        return getAll()
                        .stream()
                        .filter(empleado->empleado.getId() == id)
                        .findFirst()
                        .orElse(new Empleado());
    }

    public List<Empleado>getLikeApellido(String apellido){

        if(apellido == null) return new ArrayList();
        return getAll()
                        .stream()
                        .filter(empleado->empleado
                                                .getApellido()
                                                .toLowerCase()
                                                .contains(apellido.toLowerCase()))
                        .toList();
    }

}
