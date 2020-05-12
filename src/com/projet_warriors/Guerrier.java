package com.projet_warriors;

public class Guerrier {

    private String nomGuerrier;
    private int vieGuerrier;
    private int forceGuerrier;
    private String imageGuerrier;


    public Guerrier() {
    }


    public Guerrier(String name) {
        this.nomGuerrier = name;
        this.forceGuerrier = 5;
        this.vieGuerrier = 5;
        this.imageGuerrier = "image Guerrier";
    }

    public Guerrier(String name, int lifeLevel, int power, String photo) {
        this.nomGuerrier = name;
        this.vieGuerrier = lifeLevel;
        this.forceGuerrier = power;
        this.imageGuerrier = photo;
    }

    public String getNomGuerrier() {
        return nomGuerrier;
    }

    public void setNomGuerrier(String nomGuerrier) {
        this.nomGuerrier = nomGuerrier;
    }

    public int getVieGuerrier() {
        return vieGuerrier;
    }

    public void setVieGuerrier(int vieGuerrier) {
        this.vieGuerrier = vieGuerrier;
    }

    public int getForceGuerrier() {
        return forceGuerrier;
    }

    public void setForceGuerrier(int forceGuerrier) {
        this.forceGuerrier = forceGuerrier;
    }

    public String getImageGuerrier() {
        return imageGuerrier;
    }

    public void setImageGuerrier(String imageGuerrier) {
        this.imageGuerrier = imageGuerrier;
    }



    @Override
    public String toString() {
        return "Guerrier{" +
                "nomGuerrier='" + nomGuerrier + '\'' +
                ", vieGuerrier=" + vieGuerrier +
                ", forceGuerrier=" + forceGuerrier +
                ", imageGuerrier='" + imageGuerrier + '\'' +
                '}';
    }
}
