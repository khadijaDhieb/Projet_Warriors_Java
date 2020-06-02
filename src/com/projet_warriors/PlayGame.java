package com.projet_warriors;

import com.projet_warriors.ennemis.Ennemis;
import com.projet_warriors.exception.PersonnageHorsPlateauException;
import com.projet_warriors.personnages.Guerrier;
import com.projet_warriors.personnages.Magicien;
import com.projet_warriors.personnages.Personnage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe PlayGame qui gère le jeu
 */

public class PlayGame {

    private Personnage playerHero;
    private int posPlayer = 0;

    public Personnage getPlayerHero() {
        return playerHero;
    }

    public void setPlayerHero(Personnage playerHero) {
        this.playerHero = playerHero;
    }

//---------- Méthode qui permet de créer soit un guerrier soit un magicien selon le choix de l'utilisateur
    /**
     * permet de creer soit un guerrier soit un magicien selon le choix de l'utilisateur
     * @param choice une string
     * @return un objet Personnage : soit un guerrier ou un magicien ou null
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


    //-------------- Méthode qui permet de simuler un dé de 6

    /**
     * permet de simuler un dice de 6
     * @return un int d'une valeur entre 1 et 6
     */


    public int lanceDice() {
        int dice = 1 + (int) (Math.random() * 6);
        return dice;
    }


    //---------------- Méthode qui permet de lancer le dè et avancer le joueur
    /**
     * permet de lancer le dice et avancer le joueur sur le plateau de jeu et interagir avec l'objet d'une case
     * @param input : objet scanner
     */

    public void play(Scanner input) {
        int dice;
        int tour = 0;
        PlateauJeu plateau = new PlateauJeu();
        //plateau.randamPlateau();

        Boolean playerLost = false;
        while (this.posPlayer < plateau.getPlateau()) {

            System.out.println("----------------------");
            input.nextLine();

            dice = lanceDice();
            System.out.println("Vous avancez de  : " + dice + " cases.");

            this.posPlayer += dice;

            try {
                controlePos(plateau.getPlateau());
            } catch (PersonnageHorsPlateauException e) {
                System.out.println("Ah non ! Vous avez depassez la derniere case de " + (this.posPlayer - plateau.getPlateau()) + "! Votre hèro sera automatiquement placer sur la case " + plateau.getPlateau());
                this.posPlayer = plateau.getPlateau();
            }

            System.out.println("Votre position actuelle est  : " + this.posPlayer);

            if (this.posPlayer != plateau.getPlateau()) {
                playerLost = this.interactionPlateau(plateau, input);
                if (playerLost == true) {
                    break;
                }
            }
            tour++;
        }

        if (playerLost == false) {
            System.out.println("Bravo! vous avez gagner la partie ! ");
        }

        System.out.println("La partie a duré : " + tour + " tours.");

    }



    //---------------- Méthode qui permet l'intéraction plateau

    /**
     * Méthode qui permet l'intéraction entre le personnage du joueur et l'objet situé sur une case du plateau
     * @param plateauJeu : objet plateau de jeu qui contient mon ArrayList de Case avec les obejts : arme , sort , potion , case vide et ennemi
     * @param input : objet Scanner
     */
    public Boolean interactionPlateau(PlateauJeu plateauJeu, Scanner input) {
        boolean status = false;
        Case caseActive = plateauJeu.caseAt(this.posPlayer);
        System.out.println(caseActive);

        if (caseActive instanceof Ennemis) {
            status = jouerFuire(input, caseActive, status , plateauJeu);
            if (status == false){
                plateauJeu.setCaseAt(this.posPlayer , new CaseVide());
            }
        } else {
            caseActive.interact(this.playerHero);
        }

        return status;
    }

    //------------ Méthode combat tour par tour et permet à l'utilisitauer de faire un choix entre combattre et fuire

    /**
     * Méthode combat tour par tour et permet à l'utilisitauer de faire un choix entre combattre et fuire
     * @param input : objet Scanner
     * @param pcase : Objet Case : represente la case du plateau ou le joueur se situe
     * @param pstatus : Boolean pour passer le statut du combat quand le personnage joueur a perdu contre un ennemi
     * @param plateauJeu : objet plateau de jeu qui contient mon ArrayList de Case avec les obejts : arme , sort , potion , case vide et ennemi
     * @return
     */
    public Boolean jouerFuire(Scanner input, Case pcase, Boolean pstatus , PlateauJeu plateauJeu) {
        System.out.println(" Ouups! Vous venez de tomber sur un Ennemi ! Un combat s'engage ! ");

        System.out.println("Round 1 : c'est '" + this.playerHero.getNom() + "' qui commence !");
        Boolean test = false;
        do {
            System.out.println("Vous avez deux options : Combattre ou Fuire ? C ou F ");
            String choix = input.nextLine();
            if (choix.equals("c")) {

                System.out.println("Vous êtes courageux !");
                pcase.interact(this.playerHero);
                pstatus = ((Ennemis) pcase).getStatus();
                test = true;
            } else if (choix.equals("f")) {

                System.out.println("Oui, parfois c'est plus sage de fuire ;)");
                int recul = lanceDice();
                this.posPlayer -= recul;
                System.out.println("Mais ça a un prix! Vous reculez de " + recul + " cases.");
                System.out.println("Votre nouvelle poistion est : " + this.posPlayer);

                System.out.println("Vous êtes tombez sur :" + plateauJeu.caseAt(this.posPlayer));
                plateauJeu.caseAt(this.posPlayer).interact(this.playerHero);

                test = true;
            } else {
                System.out.println("Merci d'entrer un choix valide");

            }
        } while (test == false);

        return pstatus;
    }



    //----------------- Méthode qui permet d'évaluer une réponse pas bonne de l'utilisateur
    /**
     * permet d'évaluer une reponse pas bonne de l'utilisateur ( exemple : reponse vide ...)
     * @param input : objet scanner
     * @return : retourne une string soit quitter si l'utilisateur confirme son choix de quitter le jeu ou vide s'il veut continuer
     */

    public String statusJeu(Scanner input) {
        String status = "";
        System.out.println("Ah non c'est pas la bonne réponse ! Voulez vous continuer ou quitter le jeu? ");
        String str = input.nextLine();
        if (str.toLowerCase().equals("quitter")) {
            status = "quitter";
        }
        return status;
    }

    //------------------ Méthode qui permet de quitter le jeu
    /**
     * Méthode qui permet de quitter le jeu
     * @param status : string
     * @param input  : objet scanner
     */

    public void exitJeu(String status, Scanner input) {
        if (status.equals("quitter")) {
            System.out.println("Confirmer votre choix? Oui ou Non ");
            String str = input.nextLine();
            if (str.equals("oui")) {
                System.exit(0);
            }
        }
    }

    //------------- Méthode qui gère le PersonnageHorsPlateauException
    /**
     * Méthode qui gère le PersonnageHorsPlateauException
     * @param plateau : int qui represente la taille du plateau du jeu
     * @throws PersonnageHorsPlateauException : exception du dépassement du plateau
     */

    public void controlePos(int plateau) throws PersonnageHorsPlateauException {
        if (this.posPlayer > plateau) {
            throw new PersonnageHorsPlateauException("Dépassement de la dernière case ");
        }

    }


   }
