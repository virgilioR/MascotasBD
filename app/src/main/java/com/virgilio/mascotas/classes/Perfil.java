package com.virgilio.mascotas.classes;

public class Perfil {

    private int image;
    private int raiting;

    public Perfil(int image, int raiting) {
        this.image = image;
        this.raiting = raiting;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}
