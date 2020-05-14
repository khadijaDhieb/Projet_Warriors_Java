package com.projet_warriors;

import com.projet_warriors.exception.PersonnageHorsPlateauException;
import com.projet_warriors.personnages.Guerrier;
import com.projet_warriors.personnages.Magicien;
import com.projet_warriors.personnages.Personnage;

import java.util.Scanner;

public class PlayGame {


    //---------- Méthode qui permet de créer soit un guerrier soit un magicien selon le choix de l'utilisateur

    public Personnage createPlayer(String choice) {

        if (choice.toLowerCase().equals("guerrier")) {
            Personnage guerrier = new Guerrier();
            System.out.println(" Votre personnage sera : un Geurrier , Feliciations très bon choix ! ");
            return guerrier;
        } else if (choice.toLowerCase().equals("magicien")) {
            Personnage magicien = new Magicien();
            System.out.println(" Votre personnage sera : un Magicien , Feliciations très bon choix ! ");
            return magicien;
        }
        return null;
    }

    //------------ Méthode qui permet à l'utilisateur de choisir le nom de son personnage et l'attribuer au personnage créé

    public Personnage chooseName(Personnage hero, Scanner input) {
        String heroName = "";

        while (heroName.equals("")) {
            System.out.println("Un super héros demande un super nom nn ? Merci d'entrer le nom de votre personnage ");
            heroName = input.nextLine();
        }
        this.exitJeu(heroName, input);
        hero.setNom(heroName);
        return hero;
    }


    //-------------- Méthode qui permet de simuler un dé de 6

    public int lanceDice() {
        int dice = 1 + (int) (Math.random() * 6);
        return dice;
    }


    //---------------- Méthode qui permet de lancer le dè et avancer le joueur


    public void play(Scanner input) {

        int posPlayer = 0;
        int plateau = 64;
        int dice = 0;
        int tour = 0;

        while (posPlayer < plateau) {

            System.out.println("Appuyer sur entrer pour lancer le dè");
            System.out.println("----------------------");
            input.nextLine();

            dice = lanceDice();
            System.out.println("Vous avancez de  : " + dice + " cases.");

            posPlayer = posPlayer + dice;
            System.out.println("Votre position actuelle est  : " + posPlayer);

            tour++;
        }

        try {
            controlePos(posPlayer);
        } catch (PersonnageHorsPlateauException e) {
            System.out.println("Ah non ! Vous avez depassez la derniere case !");
        }

        System.out.println("Bravo! vous avez gagner la partie ! ");
        System.out.println("Elle a duré : " + tour + " tours.");

    }


    //----------------- Méthode qui permet d'évaluer le choix de l'utilisateur en cas de réponse

    public String statusJeu(Scanner input) {
        String status = "";
        System.out.println("Ah non c'est pas la bonne réponse ! Voulez vous continuer ou quitter le jeu? Quitter ou Continuer ");
        String str = input.nextLine();
        if (str.toLowerCase().equals("quitter")) {
            status = "quitter";
        }
        return status;
    }


    //------------------ Méthode qui permet de quitter le jeu

    public void exitJeu(String status, Scanner input) {
        if (status.equals("quitter")) {
            System.out.println("Voulez vous continuer ou quitter le jeu? Quitter ou Continuer ");
            String str = input.nextLine();
            if (str.equals("quitter")) {
                System.exit(0);
            }
        }
    }

    //------------- Méthode qui gère le PersonnageHorsPlateauException

    public void controlePos(int pos) throws PersonnageHorsPlateauException {
        if (pos > 64) {
            throw new PersonnageHorsPlateauException("Dépassement de la dernière case ");
        }

    }


}
