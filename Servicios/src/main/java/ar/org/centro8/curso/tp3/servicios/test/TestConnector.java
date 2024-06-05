package ar.org.centro8.curso.tp3.servicios.test;


import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDateTime;

import ar.org.centro8.curso.tp3.servicios.connectors.Connector;


public class TestConnector {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static void main(String[] args) {

        LocalDateTime inicio=LocalDateTime.now();

        try (ResultSet rs=Connector
                .getConnection()
                .createStatement()
                //.executeQuery("select version()")) {     
                .executeQuery("select * from clientes")) {

            if (rs.next()) {
                System.out.println(rs.getString("nombre"));
                System.out.println(ANSI_GREEN + "OK - Se conectó a la BD");
                LocalDateTime fin=LocalDateTime.now();
                Duration duration=Duration.between(inicio, fin);
                long segundos=duration.toSeconds();

                if(segundos<1){
                    System.out.println(ANSI_GREEN + "OK - Tiempo de conexión menor a 1 segundo.");
                }else{
                    System.out.println(ANSI_RED + "Error - Tiempo de conexión " + segundos + " segundos.");
                }
            } else {
                System.out.println(ANSI_RED + "Error - No se conectó a la BD");
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println(ANSI_RED + "Error - No se conectó a la BD");
        }
        System.out.println(ANSI_RESET);
    }
}
 
