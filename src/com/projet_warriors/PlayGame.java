package com.projet_warriors;

import com.projet_warriors.exception.PersonnageHorsPlateauException;
import com.projet_warriors.personnages.Guerrier;
import com.projet_warriors.personnages.Magicien;
import com.projet_warriors.personnages.Personnage;

import java.util.ArrayList;
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


    public void play(Scanner input, Personnage player) {

        int posPlayer = 0;
        int dice;
        int tour = 0;
        PlateauJeu plateau = new PlateauJeu();

        while (posPlayer < plateau.getPlateau()) {

            System.out.println("Appuyer sur entrer pour lancer le dè");
            System.out.println("----------------------");
            input.nextLine();

            dice = lanceDice();
            System.out.println("Vous avancez de  : " + dice + " cases.");

            posPlayer = posPlayer + dice;
            System.out.println("Votre position actuelle est  : " + posPlayer);
            this.interactionPlateau(player, plateau, posPlayer);

            try {
                controlePos(posPlayer, plateau.getPlateau());
            } catch (PersonnageHorsPlateauException e) {
                System.out.println("Ah non ! Vous avez depassez la derniere case de " + (posPlayer - plateau.getPlateau()) + "! Votre hèros sera automatiquement placer sur la case 64 ;) ");
                posPlayer = plateau.getPlateau();
            }


            tour++;
        }


        System.out.println("Bravo! vous avez gagner la partie ! ");
        System.out.println("Elle a duré : " + tour + " tours.");

    }


    //----------------- Méthode qui permet d'évaluer une réponse pas bonne de l'utilisateur

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
            System.out.println("Confirmer votre choix? Quitter ou Continuer ");
            String str = input.nextLine();
            if (str.equals("quitter")) {
                System.exit(0);
            }
        }
    }

    //------------- Méthode qui gère le PersonnageHorsPlateauException

    public void controlePos(int pos, int plateau) throws PersonnageHorsPlateauException {
        if (pos > plateau) {
            throw new PersonnageHorsPlateauException("Dépassement de la dernière case ");
        }

    }


    //---------------- Méthode qui permet l'intéraction plateau

    public void interactionPlateau(Personnage perso, PlateauJeu plateauJeu, int posJ) {

        ArrayList<Case> cases = plateauJeu.getCases();
        for (int i = 0; i < plateauJeu.getPlateau(); i++) {
            if (posJ == i) {
                System.out.println(cases.get(i));
                Case casePlateau = cases.get(i);
                casePlateau.interact(perso);
            }
        }
    }


}
