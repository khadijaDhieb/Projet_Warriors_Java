package com.projet_warriors.bdd;

import com.projet_warriors.personnages.Guerrier;
import com.projet_warriors.personnages.Magicien;
import com.projet_warriors.personnages.Personnage;

import java.sql.*;

public class Requette {

   private Statement state = null;
   private ResultSet result = null;
   private PreparedStatement prepare = null;


    public void getHeroes() {

        try {

            Connection conn = Connect.ConnectBdd();
            // System.out.println(conn);

            //Création d'un objet Statement

            assert conn != null;
            this.state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            this.result = state.executeQuery("SELECT * FROM Hero");

            while (result.next()) {
                System.out.print("\t" + result.getInt("id") + "\t |");
                System.out.print("\t" + result.getString("type") + "\t |");
                System.out.print("\t" + result.getString("nom") + "\t |");
                System.out.print("\t" + result.getInt("niveauVie") + "\t |");
                System.out.print("\t" + result.getInt("niveauForce") + "\t |");
                System.out.print("\t" + result.getString("attaque") + "\t |");
                System.out.print("\t" + result.getString("defense") + "\t |");
                System.out.println("\n---------------------------------");
            }


        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            this.close(this.result,this.state);
        }


    }

    //--------------------------------------------

    public void getHero(Personnage perso) {

        try {

            Connection conn = Connect.ConnectBdd();

            String query = "SELECT * FROM Hero WHERE nom = ? ";

            //On crée l'objet avec la requête en paramètre
            this.prepare = conn.prepareStatement(query);
            //On remplace le premier ? par
            this.prepare.setString(1, perso.getNom());

            //L'objet ResultSet contient le résultat de la requête SQL
            this.result = this.prepare.executeQuery();

            while (this.result.next()) {

                System.out.print("\t" + result.getInt("id") + "\t |");
                System.out.print("\t" + result.getString("type") + "\t |");
                System.out.print("\t" + result.getString("nom") + "\t |");
                System.out.print("\t" + result.getInt("niveauVie") + "\t |");
                System.out.print("\t" + result.getInt("niveauForce") + "\t |");
                System.out.print("\t" + result.getString("attaque") + "\t |");
                System.out.print("\t" + result.getString("defense") + "\t |");
                System.out.println("\n---------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            this.close(this.result, this.prepare);
        }

    }


    //----------------------------------

    public void createHero(Personnage perso) {

        try {

            Connection conn = Connect.ConnectBdd();

            String query = "INSERT into Hero  (type, nom, niveauVie, niveauForce, attaque, defense) VALUES(?, ?, ?, ?, ?, ?)";

            //On crée l'objet avec la requête en paramètre
           this.prepare = conn.prepareStatement(query);
            //On remplace les ? par
            this.prepare.setString(2, perso.getNom());
            this.prepare.setInt(3, perso.getVie());
            this.prepare.setInt(4, perso.getForce());
            this.prepare.setString(6, perso.getDefense());

            if (perso instanceof Guerrier) {
                this.prepare.setString(1, "Guerrier");
                this.prepare.setString(5, "arme");
            }

            if (perso instanceof Magicien) {
                this.prepare.setString(1, "Magicien");
                this.prepare.setString(5, "sort");
            }

            this.prepare.executeUpdate();
            System.out.println("Votre personnage est bien été enregistré dans notre base de données");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.close(this.result , this.prepare);
        }

    }

    //-------------------------------

    public void updateHero(Personnage perso, String nom, String defense) {

        try {

            Connection conn = Connect.ConnectBdd();

            String query = "UPDATE `hero` SET `nom`= ?,`Defense`=? WHERE hero.nom = ?";

            //On crée l'objet avec la requête en paramètre
            PreparedStatement prepare = conn.prepareStatement(query);
            //On remplace les ? par
            prepare.setString(1, nom);
            prepare.setString(2, defense);
            prepare.setString(3, perso.getNom());


            prepare.executeUpdate();
            System.out.println("Votre personnage est bien été mis à jour dans notre base de données");
            prepare.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//--------------------------------
    public void deleteHero(Personnage perso) {
        try {

            Connection conn = Connect.ConnectBdd();

            String query = "DELETE FROM `hero` WHERE hero.nom = ?";

            //On crée l'objet avec la requête en paramètre
            PreparedStatement prepare = conn.prepareStatement(query);
            //On remplace les ? par
            prepare.setString(1, perso.getNom());


            prepare.executeUpdate();
            System.out.println("Votre personnage est bien été mis à jour dans notre base de données");
            prepare.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//----------------------- Méthode qui permet

    private void close(ResultSet result, Statement state) {
        try {
            if (result != null) {
                result.close();
            }
            if (state != null) {
                state.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
