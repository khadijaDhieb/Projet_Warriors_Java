package com.projet_warriors.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSingleton {

    private String url = "jdbc:mysql://localhost:3306/bdd_java";
    private String user = "root";
    private String passwd = "";
    //Objet Connection
    private static Connection connect = null;

    //Constructeur privé
    private ConnectSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
    public static Connection getInstance(){
        if(connect == null){
            new ConnectSingleton();
            //System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");
        } else{
           // System.out.println("CONNEXION SQL EXISTANTE ! ");
        }
        return connect;
    }
/*

//    public static Connection ConnectBdd() {

        private static String url = "jdbc:mysql://localhost:3306/bdd_java";
        private static String user = "root";
        private static String passwd = "";
        private static Connection connect = null;

        private ConnectSingleton()
        {

        }

        public static Connection getInstance(){
            if(connect == null){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connect = DriverManager.getConnection(url, user, passwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return connect;
        }
  //  }
*/
}
