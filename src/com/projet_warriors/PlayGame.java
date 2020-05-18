package com.projet_warriors;

import com.projet_warriors.exception.PersonnageHorsPlateauException;
import com.projet_warriors.personnages.Guerrier;
import com.projet_warriors.personnages.Magicien;
import com.projet_warriors.personnages.Personnage;

import java.util.ArrayList;
import java.util.Scanner;


public class PlayGame {


    //---------- Méthode qui permet de créer soit un guerrier soit un magicien selon le choix de l'utilisateur

    /**
     * @param choice une string
     * @return
     */
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

    //------------ Méthode qui permet d'attribuer le nom du personnage créé

    /**
     *
     * @param hero : objet personnage
     * @param name : une string
     * @return retourne un objet personnage
     */
    public Personnage setPlayerName(Personnage hero, String name) {
        hero.setNom(name);
        return hero;
    }


    //-------------- Méthode qui permet de simuler un dé de 6

    /**
     * @return
     */
    public int lanceDice() {
        int dice = 1 + (int) (Math.random() * 6);
        return dice;
    }


    //---------------- Méthode qui permet de lancer le dè et avancer le joueur

    /**
     *
     * @param input : objet scanner
     * @param player : objet player
     */

    public void play(Scanner input, Personnage player) {

        int posPlayer = 0;
        int dice;
        int tour = 0;
        PlateauJeu plateau = new PlateauJeu();
        plateau.randamPlateau();

        while (posPlayer < plateau.getPlateau()) {

            System.out.println("Appuyer sur entrer pour lancer le dè");
            System.out.println("----------------------");
            input.nextLine();

            dice = lanceDice();
            System.out.println("Vous avancez de  : " + dice + " cases.");

            posPlayer = posPlayer + dice;
            System.out.println("Votre position actuelle est  : " + posPlayer);

            try {
                controlePos(posPlayer, plateau.getPlateau());
            } catch (PersonnageHorsPlateauException e) {
                System.out.println("Ah non ! Vous avez depassez la derniere case de " + (posPlayer - plateau.getPlateau()) + "! Votre hèro sera automatiquement placer sur la case 64 ;) ");
                posPlayer = plateau.getPlateau();
            }

            if (posPlayer != plateau.getPlateau()) {
                this.interactionPlateau(player, plateau, posPlayer);
            }
            tour++;
        }


        System.out.println("Bravo! vous avez gagner la partie ! ");
        System.out.println("Elle a duré : " + tour + " tours.");

    }


    //----------------- Méthode qui permet d'évaluer une réponse pas bonne de l'utilisateur

    /**
     * @param input : objet scanner
     * @return : retourne une string
     */
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

    /**
     * @param status : string
     * @param input : objet scanner
     */
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

    /**
     * @param pos : int qui represente l'objet joueur
     * @param plateau : int qui represente la taille du plateau du jeu
     * @throws PersonnageHorsPlateauException : exception du dépassement du plateau
     */
    public void controlePos(int pos, int plateau) throws PersonnageHorsPlateauException {
        if (pos > plateau) {
            throw new PersonnageHorsPlateauException("Dépassement de la dernière case ");
        }

    }


    //---------------- Méthode qui permet l'intéraction plateau

    /**
     * @param perso : objet personnage
     * @param plateauJeu : objet plateau de jeu
     * @param posJ int : position u joueur
     */
    public void interactionPlateau(Personnage perso, PlateauJeu plateauJeu, int posJ) {

        ArrayList<Case> cases = plateauJeu.getCases();
        System.out.println(cases.get(posJ));
        Case casePlateau = cases.get(posJ);
        casePlateau.interact(perso);
    }


}
