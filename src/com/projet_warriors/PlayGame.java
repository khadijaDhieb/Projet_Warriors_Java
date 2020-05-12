package com.projet_warriors;

import java.util.Scanner;

public class PlayGame {

    public Object createPlayer(String choice ) {

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
        return null ;
    }

    public Boolean quitteJeu() {
        Boolean status = false ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez vous continuer ou quitter le jeu? Quitter ou Continuer ");
        String str = sc.nextLine();

        if (str.equals("quitter")) {
            status = true ;
        }
        return status ;
    }
}
