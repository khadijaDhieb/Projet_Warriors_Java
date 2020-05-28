package com.projet_warriors.bdd;

import com.projet_warriors.personnages.Guerrier;
import com.projet_warriors.personnages.Magicien;
import com.projet_warriors.personnages.Personnage;

import java.sql.*;

public class Requette {

    public static void getHeroes() {

        try {

           Connection conn = Connect.ConnectBdd() ;
            System.out.println(conn);

            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery("SELECT * FROM Hero");

            while(result.next()){
                System.out.print("\t" + result.getInt("id") + "\t |");
                System.out.print("\t" + result.getString("type") + "\t |");
                System.out.print("\t" + result.getString("nom") + "\t |");
                System.out.print("\t" + result.getInt("niveauVie") + "\t |");
                System.out.print("\t" + result.getInt("niveauForce") + "\t |");
                System.out.print("\t" + result.getString("attaque") + "\t |");
                System.out.print("\t" + result.getString("defense") + "\t |");
                System.out.println("\n---------------------------------");
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //--------------------------------------------

    public static void getHero( int id){

        try {

            Connection conn = Connect.ConnectBdd() ;

            String query = "SELECT * FROM Hero WHERE id = ? ";

            //On crée l'objet avec la requête en paramètre
            PreparedStatement prepare = conn.prepareStatement(query);
            //On remplace le premier ? par
            prepare.setInt(1, id);

            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = prepare.executeQuery();

            while(result.next()){

                System.out.print("\t" + result.getInt("id") + "\t |");
                System.out.print("\t" + result.getString("type") + "\t |");
                System.out.print("\t" + result.getString("nom") + "\t |");
                System.out.print("\t" + result.getInt("niveauVie") + "\t |");
                System.out.print("\t" + result.getInt("niveauForce") + "\t |");
                System.out.print("\t" + result.getString("attaque") + "\t |");
                System.out.print("\t" + result.getString("defense") + "\t |");
                System.out.println("\n---------------------------------");
            }

            result.close();
            prepare.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //----------------------------------

    public static void createHero(Personnage perso ){

        try {

            Connection conn = Connect.ConnectBdd() ;

            String query = "INSERT into Hero  (type, nom, niveauVie, niveauForce, attaque, defense) VALUES(?, ?, ?, ?, ?, ?)";

            //On crée l'objet avec la requête en paramètre
            PreparedStatement prepare = conn.prepareStatement(query);
            //On remplace les ? par
            prepare.setString(2, perso.getNom());
            prepare.setInt(3 , perso.getVie());
            prepare.setInt(4, perso.getForce());
            prepare.setString(6 , perso.getDefense());

            if(perso instanceof Guerrier){
                prepare.setString(1 , "Guerrier");
                prepare.setString(5 , "arme");
            }

            if(perso instanceof Magicien){
                prepare.setString(1 , "Magicien");
                prepare.setString(5 , "sort");
            }

            prepare.executeUpdate();
            System.out.println("Votre personnage est bien été enregistré dans notre base de données");
            prepare.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //-------------------------------

    public static void updateHero(Personnage perso , String nom , String defense){

        try {

            Connection conn = Connect.ConnectBdd() ;

            String query = "UPDATE `hero` SET `nom`= ?,`Defense`=? WHERE hero.nom = ?";

            //On crée l'objet avec la requête en paramètre
            PreparedStatement prepare = conn.prepareStatement(query);
            //On remplace les ? par
            prepare.setString(1, nom);
            prepare.setString(2 , defense);
            prepare.setString(3 , perso.getNom());


            prepare.executeUpdate();
            System.out.println("Votre personnage est bien été mis à jour dans notre base de données");
            prepare.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
