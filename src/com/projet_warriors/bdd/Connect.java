package com.projet_warriors.bdd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    public static Connection ConnectBdd() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           // System.out.println("Driver O.K.");

            String url = "jdbc:mysql://localhost:3307/my_bdd";
            String user = "root";
            String passwd = "";

            Connection conn = DriverManager.getConnection(url, user, passwd);
           // System.out.println("Connexion effective !");

            return conn ;

        } catch (Exception e) {
            e.printStackTrace();
            return null ;
        }
    }

}
