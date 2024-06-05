package ar.org.centro8.curso.tp3.servicios.connectors;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connector {

    //localhost
    private static String url="jdbc:mariadb://localhost:3306/servicios";
    private static String user="root";
    private static String pass="";

    //db4free
    //private static String url="jdbc:mariadb://db4free.net:3306/basegeneral";
    //private static String user="basegeneral";
    //private static String pass="basegeneral";

    //SQLite
    //private static String url="jdbc:sqlite:./data/servicios";
    //private static String user="";
    //private static String pass="";

    private static Connection conn=null;
    private Connector(){}

    public static String getUrl(){
        return url;
    }

    public synchronized static Connection getConnection(){
        try {
            if(conn==null || conn.isClosed()){
                conn=DriverManager.getConnection(url, user, pass);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}


