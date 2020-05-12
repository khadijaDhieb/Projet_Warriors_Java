package com.projet_warriors;

import java.util.Scanner;

public class PlayGame {

    int posPlayer = 0;
    int plateau = 64;
    int dice = 0;
    int tour =0;


    public Object createPlayer(String choice) {

        if (choice.toLowerCase().equals("guerrier")) {

            Guerrier guerrier1 = new Guerrier();

            System.out.println(" Votre personnage sera : un Geurrier , Feliciations très bon choix ! ");
            Scanner sc = new Scanner(System.in);
            System.out.println("Et maintenant, il faut lui donner un nom : ? ");
            String heroName = sc.nextLine();
            guerrier1.setNomGuerrier(heroName);

            return guerrier1;

        } else if (choice.toLowerCase().equals("magicien")) {

            Magicien magicien1 = new Magicien();

            System.out.println(" Votre personnage sera : un Magicien , Feliciations très bon choix ! ");
            Scanner sc = new Scanner(System.in);
            System.out.println("Et maintenant, il faut lui donner un nom : ? ");
            String heroName = sc.nextLine();
            magicien1.setNomMagicien(heroName);
            return magicien1;

        }
        return null;
    }

    public int lanceDice() {
        int dice = 1 + (int) (Math.random() * 6);
        return dice;
    }

    public void play(){
        while (posPlayer <plateau){

            Scanner avance = new Scanner(System.in);
            System.out.println("Appuyer sur entrer pour lancer le dès");
            System.out.println("----------------------");
            avance.nextLine();

            dice = lanceDice();
            System.out.println("Vous avancez de  : " + dice + " cases.");

            posPlayer =  posPlayer + dice ;
            System.out.println("Votre position actuelle est  : " + posPlayer);

            tour++ ;
        }

        System.out.println("Bravo! vous avez gagner la partie ! ");
        System.out.println("Elle a duré : " + tour + " tours.");

    }

    public Boolean quitteJeu() {
        Boolean status = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ah non c'est pas la bonne réponse ! Voulez vous continuer ou quitter le jeu? Quitter ou Continuer ");
        String str = sc.nextLine();

        if (str.equals("quitter")) {
            status = true;
        }
        return status;
    }
}
